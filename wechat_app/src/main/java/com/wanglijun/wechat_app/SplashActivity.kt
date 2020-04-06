package com.wanglijun.wechat_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.wanglijun.wechat_app.fragment.SplashFragment
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * @author： wlj
 * @Date: 2020-04-04
 * @email: wanglijundev@gmail.com
 * @desc: APP欢迎页
 */
@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    private val imageList = arrayListOf<Int>(
        R.mipmap.bg_01,
        R.mipmap.bg_02,
        R.mipmap.bg_03,
        R.mipmap.bg_04,
        R.mipmap.bg_05
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        vpMain.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return SplashFragment.newInstance(imageList[position])
            }

            override fun getCount() = imageList.size
        }
    }
}
