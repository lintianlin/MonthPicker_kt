package com.sinfeeloo.monthpicker_kt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sinfeeloo.monthpickerforkt.MonthPicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        monthPicker.setOnMonthSelectEventListener(object : MonthPicker.OnMonthSelectEventListener {
            override fun onMonthSelected(year: String, month: String) {
                Toast.makeText(this@MainActivity, "$year 年 $month 月", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
