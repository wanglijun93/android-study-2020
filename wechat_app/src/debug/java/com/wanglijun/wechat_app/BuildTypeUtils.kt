package com.wanglijun.wechat_app

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.view.ViewGroup

/**
 * @author： wlj
 * @Date: 2020-04-18
 * @email: wanglijundev@gmail.com
 * @desc:
 */
class BuildTypeUtils {
    companion object {
        fun buildType(activity: Activity) {
            val decorView = activity.window.decorView as ViewGroup
            val view = View(activity)
            view.setBackgroundColor(Color.RED)
            decorView.addView(view,200,200)
        }
    }
}