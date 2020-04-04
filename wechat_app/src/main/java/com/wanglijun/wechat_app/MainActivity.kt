package com.wanglijun.wechat_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.wanglijun.wechat_app.fragment.TabFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author： wlj
 * @Date: 2020-04-04
 * @email: wanglijundev@gmail.com
 * @desc: 首页
 */
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private val titleList = arrayListOf<String>("微信", "联系人", "朋友圈", "我")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vpMain.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return TabFragment.newInstance(titleList[position])
            }

            override fun getCount() = titleList.size
        }

    }
}
