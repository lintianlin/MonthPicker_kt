package com.sinfeeloo.monthpickerforkt

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import java.util.*

/**
 * @author: mhj
 * @date: 2018/1/17 11:30
 * @desc:
 */
class MonthAdapter(val mContext: Context, datas: ArrayList<DateBean>) : RecyclerView.Adapter<MonthAdapter.MonthViewHolder>() {

    private var listener: OnMonthClickListener? = null
    private var mList = ArrayList<DateBean>()

    fun setOnMonthClickListener(onMonthClickListener: OnMonthClickListener) {
        this.listener = onMonthClickListener
    }

    init {
        this.mList = datas
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthAdapter.MonthViewHolder {
        return MonthViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_select_month, parent,
                false))
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        if (!mList.isEmpty()) {
            if (null != mList[position]) {
                val item = mList[position]
                holder.radioButton.setText(item.name)
                holder.radioButton.setOnClickListener {
                    if (null != listener)
                        listener!!.onItemSelect(position)
                }
                holder.radioButton.isChecked = item.isSelected
            }

        }


    }


    override fun getItemCount(): Int {
        return mList.size
    }


    interface OnMonthClickListener {
        fun onItemSelect(position: Int)
    }

    inner class MonthViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var radioButton: RadioButton

        init {
            radioButton = view.findViewById(R.id.rb_select_month_name)
        }
    }


}