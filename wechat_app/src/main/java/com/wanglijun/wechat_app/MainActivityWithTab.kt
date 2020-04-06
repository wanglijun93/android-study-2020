package com.wanglijun.wechat_app

import android.os.Bundle
import android.util.SparseArray
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
const val BUNDLE_KEY_POS = "bundle_key_pos"
@Suppress("DEPRECATION")
class MainActivityWithTab : AppCompatActivity() {
    private val mTitleList = arrayListOf<String>("微信", "联系人", "发现", "我")
    private var mFragmentList: SparseArray<TabFragment>? = SparseArray()
    private var mTabs = arrayListOf<TabView>()
    private var mCurTabPos = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        mCurTabPos = savedInstanceState?.getInt(BUNDLE_KEY_POS,0) ?: 0
        mFragmentList
        initView()
        initViewPager()
        initEvents()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(BUNDLE_KEY_POS,vpMain.currentItem)
        super.onSaveInstanceState(outState)
    }

    /**
     * 给底部tab设置点击事件
     */
    private fun initEvents(){
        mTabs.forEachIndexed { index, tabView ->
            tabView.setOnClickListener {
                vpMain.setCurrentItem(index,false)
                setCurrentTab(index)
            }
        }
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
                    val left = mTabs[position]
                    val right = mTabs[position + 1]

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
        tabWeChat.setIconAndText(R.mipmap.wechat, R.mipmap.wechat_select, "微信")
        tabFriend.setIconAndText(R.mipmap.friend, R.mipmap.friend_select, "联系人")
        tabFind.setIconAndText(R.mipmap.find, R.mipmap.find_select, "发现")
        tabMe.setIconAndText(R.mipmap.me, R.mipmap.me_select, "我")

        mTabs.add(tabWeChat)
        mTabs.add(tabFriend)
        mTabs.add(tabFind)
        mTabs.add(tabMe)
        //默认选中第0个tab
        setCurrentTab(mCurTabPos)
    }

    /**
     * 设置选中的tab
     *
     * @param pos 选中的位置
     */
    private fun setCurrentTab(pos: Int) {
        mTabs.forEachIndexed { index, tabView ->
            if (index == pos) {
                tabView.setProgress(1f)
            } else {
                tabView.setProgress(0f)
            }
        }
    }
}
