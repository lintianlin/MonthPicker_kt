package com.sinfeeloo.monthpickerforkt

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout

import kotlinx.android.synthetic.main.view_month_picker.*
import kotlinx.android.synthetic.main.view_month_picker.view.*
import java.util.*

/**
 * @author: mhj
 * @date: 2018/1/17 11:44
 * @desc:
 */
class MonthPicker : LinearLayout, View.OnClickListener {

    private val mList = ArrayList<DateBean>()
    private val calendar: Calendar
    private val adapter: MonthAdapter
    private var listener: OnMonthSelectEventListener? = null
    private var currentYear: Int

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        LayoutInflater.from(context).inflate(R.layout.view_month_picker, this)
        iv_year_sub.setOnClickListener(this)
        iv_year_add.setOnClickListener(this)
        val layoutManager = GridLayoutManager(getContext(), 4)
        recyclerView.layoutManager = layoutManager
        calendar = Calendar.getInstance()
        currentYear = calendar.get(Calendar.YEAR)
        tv_year.text = currentYear.toString()
        adapter = MonthAdapter(context, getAllMonth())
        recyclerView.adapter = adapter
        adapter.setOnMonthClickListener(object : MonthAdapter.OnMonthClickListener {
            override fun onItemSelect(position: Int) {
                var month = mList[position].name
                var monthId = mList[position].id
                var year = tv_year.text
                for (i in mList.indices) {
                    mList[i].isSelected = position == i
                }
                if (RecyclerView.SCROLL_STATE_IDLE == recyclerView.scrollState) {
                    if (!recyclerView.isComputingLayout) {
                        adapter.notifyDataSetChanged()
                    }
                }

                if (null != listener) {
                    listener!!.onMonthSelected(year as String, monthId.toString())
                }
            }

        })
    }


    fun getAllMonth(): ArrayList<DateBean> {
        mList.clear()
        var currentMonth = calendar.get(Calendar.MONTH);
        for (i in 1..12) {
            val dateBean = DateBean()
            dateBean.id = i
            dateBean.name = "$i 月"
            if (currentMonth + 1 == i) {
                dateBean.isSelected = true
            }
            mList.add(dateBean)
        }
        return mList
    }


    override fun onClick(v: View?) {
        val i = v?.id
        if (i == R.id.iv_year_add) {
            addYear()
        } else if (i == R.id.iv_year_sub) {
            subYear()
        }
    }

    /**
     * 加年份
     */
    fun addYear() {
        calendar.add(Calendar.YEAR, 1)
        currentYear = calendar.get(Calendar.YEAR)
        tv_year.text = currentYear.toString()
    }

    /**
     * 减年份
     */
    fun subYear() {
        calendar.add(Calendar.YEAR, -1)
        currentYear = calendar.get(Calendar.YEAR)
        tv_year.text = currentYear.toString()
    }

    fun setOnMonthSelectEventListener(onMonthSelectEventListener: OnMonthSelectEventListener) {
        listener = onMonthSelectEventListener
    }

    interface OnMonthSelectEventListener {
        fun onMonthSelected(year: String, month: String)
    }

}