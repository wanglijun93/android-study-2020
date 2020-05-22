package com.wanglijun.statusbar

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author wlj
 * @des 功能入口
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            button1 -> {
                startActivity(Intent(this,Main2Activity::class.java))
            }
            button2 -> {
                startActivity(Intent(this,Main3Activity::class.java))
            }
        }
    }

}
