package com.wanglijun.wechat_app.transformer

import android.view.View
import androidx.viewpager.widget.ViewPager

/**
 * @author： wlj
 * @Date: 2020-04-06
 * @email: wanglijundev@gmail.com
 * @desc: 控制viewPager左右滑动时候的view大小
 */
const val MIN_SCALE = 0.75F

class ScaleTransformer : ViewPager.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        when {
            position < -1 -> {
                page.scaleX = MIN_SCALE
                page.scaleY = MIN_SCALE
            }
            position <= 1 -> {
                //左边页面
                if (position < 0) {
                    val scaleA = MIN_SCALE + (1 - MIN_SCALE) * (1 + position)
                    page.scaleX = scaleA
                    page.scaleY = scaleA
                } else {
                    //右边页面
                    val scaleB = MIN_SCALE + (1 - MIN_SCALE) * (1 - position)
                    page.scaleX = scaleB
                    page.scaleY = scaleB
                }
            }
            else -> {
                page.scaleX = MIN_SCALE
                page.scaleY = MIN_SCALE
            }
        }
    }
}