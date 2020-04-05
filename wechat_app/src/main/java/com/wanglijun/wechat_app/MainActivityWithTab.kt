package com.wanglijun.wechat_app

import android.os.Bundle
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.wanglijun.wechat_app.fragment.TabFragment
import com.wanglijun.wechat_app.view.TabView
import kotlinx.android.synthetic.main.activity_main.vpMain
import kotlinx.android.synthetic.main.activity_tab.*

/**
 * @author： wlj
 * @Date: 2020-04-04
 * @email: wanglijundev@gmail.com
 * @desc: 首页
 */
@Suppress("DEPRECATION")
class MainActivityWithTab : AppCompatActivity(), View.OnClickListener {
    private val mTitleList = arrayListOf<String>("微信", "联系人", "朋友圈", "我")
    private var mFragmentList: SparseArray<TabFragment>? = SparseArray()
    private var mTabs = arrayListOf<TabView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        mFragmentList
        initView()
        initViewPager()

    }

    /**
     * 初始化viewpager
     */
    private fun initViewPager() {
        vpMain.offscreenPageLimit = mTitleList.size
        vpMain.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return TabFragment.newInstance(mTitleList[position])
            }

            override fun getCount() = mTitleList.size

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                val fragment = super.instantiateItem(container, position) as TabFragment
                mFragmentList?.put(position, fragment)
                return fragment
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                mFragmentList?.remove(position)
                super.destroyItem(container, position, `object`)
            }
        }
        vpMain.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (positionOffset > 0) {
                    val left = mTabs.get(position)
                    val right = mTabs.get(position + 1)

                    left.setProgress(1 - positionOffset)
                    right.setProgress(positionOffset)
                }
            }

            override fun onPageSelected(position: Int) {
            }
        })
    }

    /**
     * 初始化控件
     */
    private fun initView() {
        tabWeChat.setOnClickListener(this)
        tabFriend.setOnClickListener(this)
        tabFind.setOnClickListener(this)
        tabMe.setOnClickListener(this)

        tabWeChat.setIconAndText(R.mipmap.wechat,R.mipmap.wechat_select,"微信")
        tabFriend.setIconAndText(R.mipmap.friend,R.mipmap.friend_select,"联系人")
        tabFind.setIconAndText(R.mipmap.find,R.mipmap.find_select,"查找")
        tabMe.setIconAndText(R.mipmap.me,R.mipmap.me_select,"我")

        mTabs.add(tabWeChat)
        mTabs.add(tabFriend)
        mTabs.add(tabFind)
        mTabs.add(tabMe)

        tabWeChat.setProgress(1f)
    }

    override fun onClick(v: View?) {
    }

}
