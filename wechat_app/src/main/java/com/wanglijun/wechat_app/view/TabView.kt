package com.wanglijun.wechat_app.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.wanglijun.wechat_app.R
import kotlinx.android.synthetic.main.view_tab.view.*
import kotlin.math.pow
import kotlin.math.roundToInt


/**
 * @author： wlj
 * @Date: 2020-04-04
 * @email: wanglijundev@gmail.com
 * @desc: 自定义底部view
 */
class TabView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    companion object {
        var COLOR_DEFAULT = Color.parseColor("#ff000000")
        var COLOR_SELECT = Color.parseColor("#ff13227a")
    }

    init {
        View.inflate(context, R.layout.view_tab, this)
        ivIcon
        ivIconSelect
        tvTitle
        setProgress(0f)
    }

    fun setIconAndText(icon: Int, iconSelect: Int, title: String) {
        ivIcon.setImageResource(icon)
        ivIconSelect.setImageResource(iconSelect)
        tvTitle.text = title
    }

    fun setProgress(progress: Float) {
        ivIcon.alpha = 1 - progress
        ivIconSelect.alpha = progress
        tvTitle.setTextColor(evaluate(progress, COLOR_DEFAULT, COLOR_SELECT))
    }

    private fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
        val startA = (startValue shr 24 and 0xff) / 255.0f
        var startR = (startValue shr 16 and 0xff) / 255.0f
        var startG = (startValue shr 8 and 0xff) / 255.0f
        var startB = (startValue and 0xff) / 255.0f
        val endA = (endValue shr 24 and 0xff) / 255.0f
        var endR = (endValue shr 16 and 0xff) / 255.0f
        var endG = (endValue shr 8 and 0xff) / 255.0f
        var endB = (endValue and 0xff) / 255.0f
        // convert from sRGB to linear
        startR = startR.toDouble().pow(2.2).toFloat()
        startG = startG.toDouble().pow(2.2).toFloat()
        startB = startB.toDouble().pow(2.2).toFloat()
        endR = endR.toDouble().pow(2.2).toFloat()
        endG = endG.toDouble().pow(2.2).toFloat()
        endB = endB.toDouble().pow(2.2).toFloat()
        // compute the interpolated color in linear space
        var a = startA + fraction * (endA - startA)
        var r = startR + fraction * (endR - startR)
        var g = startG + fraction * (endG - startG)
        var b = startB + fraction * (endB - startB)
        // convert back to sRGB in the [0..255] range
        a *= 255.0f
        r = r.toDouble().pow(1.0 / 2.2).toFloat() * 255.0f
        g = g.toDouble().pow(1.0 / 2.2).toFloat() * 255.0f
        b = b.toDouble().pow(1.0 / 2.2).toFloat() * 255.0f
        return a.roundToInt() shl 24 or (r.roundToInt() shl 16) or (g.roundToInt() shl 8) or Math.round(b)
    }
}