package com.wanglijun.calendarviewlj

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 自定义日历
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val year = calendarView.curYear.toString().plus("年")
        val month = calendarView.curMonth.toString().plus("月")
        tvTime.text = year.plus(month)
        tvTime.setOnClickListener {
            if (!calendarLayout.isExpand) {
                calendarLayout.expand()
            } else {
                calendarLayout.shrink()
            }
        }
    }
}
