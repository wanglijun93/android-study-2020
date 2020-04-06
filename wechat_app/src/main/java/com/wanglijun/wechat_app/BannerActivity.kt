package com.wanglijun.wechat_app

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.wanglijun.wechat_app.transformer.ScaleTransformer
import kotlinx.android.synthetic.main.activity_banner.*

/**
 * @author： wlj
 * @Date: 2020-04-04
 * @email: wanglijundev@gmail.com
 * @desc: APP欢迎页
 */
@Suppress("DEPRECATION")
class BannerActivity : AppCompatActivity() {
    private val imageList = arrayListOf<Int>(
        R.mipmap.bg_01,
        R.mipmap.bg_02,
        R.mipmap.bg_03,
        R.mipmap.bg_04,
        R.mipmap.bg_05
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)
        vpMain.offscreenPageLimit = 3
        vpMain.adapter = object : PagerAdapter() {
            override fun isViewFromObject(view: View, `object`: Any): Boolean {
                return view == `object`
            }

            override fun getCount(): Int = imageList.size

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                val view = View(container.context)
                view.setBackgroundResource(imageList[position])
                val lp = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                container.addView(view)
                return view
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                container.removeView(`object` as View)
            }
        }
        vpMain.setPageTransformer(true,ScaleTransformer())
    }
}
