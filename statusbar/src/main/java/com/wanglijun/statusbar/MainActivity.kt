package com.wanglijun.statusbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

/**
 * @author wlj
 * @des 透明状态栏
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val decorView = window.decorView
        val option = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = option
        val actionBar = supportActionBar
        actionBar?.hide()
    }
}
