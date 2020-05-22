package com.wanglijun.statusbar

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

/**
 * @author wlj
 * @des 透明状态栏
 */
class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //会盖住状态栏
//        setStatusBar1()
        //不会盖着状态栏
//        setStatusBar2()

        //在状态栏和导航栏下方
        setStatusBar3()


    }


//    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        super.onWindowFocusChanged(hasFocus)
    //  会完全盖住顶部状态栏
//        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
//            val decorView = window.decorView;
//            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                    or View.SYSTEM_UI_FLAG_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
//        }
//    }

    /**
     * 在状态栏和导航栏下方
     */
    private fun setStatusBar3() {
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            val option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            decorView.systemUiVisibility = option;
            window.navigationBarColor = Color.TRANSPARENT;
            window.statusBarColor = Color.TRANSPARENT;
        }
        val actionBar = supportActionBar;
        actionBar?.hide();
    }

    /**
     * 在顶部状态栏下方
     */
    private fun setStatusBar2() {
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        }
        val actionBar = supportActionBar
        actionBar?.hide()
    }

    /**
     * 盖着顶部状态栏
     */
    private fun setStatusBar1() {
        val decorView = window.decorView
        val option = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = option
        val actionBar = supportActionBar
        actionBar?.hide()
    }
}
