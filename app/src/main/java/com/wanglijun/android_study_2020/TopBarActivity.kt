package com.wanglijun.android_study_2020

import android.os.Bundle
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_top_bar.*

/**
 * @author 王丽君
 * Email：wanglijundev@gmail.com
 * 描述：topBar测试类
 * 修改历史:
 * 修改日期         作者        版本        描述说明
 *
 * 创建于： 2020-03-17 21:02
 **/
class TopBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_bar)
        topBar.setOnTopBarClickListener(object : TopBarView.topBarOnClickListener {
            override fun leftClick() {
                Toast.makeText(this@TopBarActivity, getString(R.string.back), Toast.LENGTH_SHORT)
                    .show()
                finish()
            }

            override fun rightClick() {
                Toast.makeText(this@TopBarActivity, getString(R.string.more), Toast.LENGTH_SHORT)
                    .show()
            }

            override fun titleClick() {
                Toast.makeText(this@TopBarActivity, getString(R.string.title), Toast.LENGTH_SHORT)
                    .show()
            }
        })
        viewTouch()
    }

    private var mLastX = 0f
    private var mLastY = 0f
    private fun viewTouch() {
        view.setOnTouchListener { v, event ->
            val rawX = event.rawX
            val rawY = event.rawY

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                }
                MotionEvent.ACTION_MOVE -> {
                    val deltaX = rawX - mLastX
                    val deltaY = rawY - mLastY
                    val moveX = v.translationX + deltaX
                    val moveY = v.translationY + deltaY
                    v.translationX = moveX
                    v.translationY = moveY
                }
                MotionEvent.ACTION_UP -> {
                }
            }
            mLastX = rawX
            mLastY = rawY
            return@setOnTouchListener true
        }
    }
}
