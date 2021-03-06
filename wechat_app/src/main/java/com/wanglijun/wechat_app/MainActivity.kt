package com.wanglijun.wechat_app

import android.os.Bundle
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.wanglijun.wechat_app.fragment.TabFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author： wlj
 * @Date: 2020-04-04
 * @email: wanglijundev@gmail.com
 * @desc: 首页
 */
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val mTitleList = arrayListOf<String>("微信", "联系人", "朋友圈", "我")
    private var mFragmentList: SparseArray<TabFragment>? = SparseArray()
    private var mTabs = arrayListOf<Button>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
                val fragment = TabFragment.newInstance(mTitleList[position])
                if (position == 0) {
                    fragment.setOnTitleChangeListener(object : TabFragment.onTitleChangeListener {
                        override fun onClick(title: String) {
                            changeWeChatTitle(title)
                        }
                    })
                }
                return fragment
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

                    left.text = (1 - positionOffset).toString()
                    right.text = positionOffset.toString()
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
        btWeChat.setOnClickListener(this)
        btFriend.setOnClickListener(this)
        btFind.setOnClickListener(this)
        btMe.setOnClickListener(this)

        mTabs.add(btWeChat)
        mTabs.add(btFriend)
        mTabs.add(btFind)
        mTabs.add(btMe)
    }

    override fun onClick(v: View?) {
        when (v) {
            btWeChat -> {
                mFragmentList?.get(0)?.changeTitle("changeTitle = 微信")
            }
            btFriend -> {
            }
            btFind -> {
            }
            btMe -> {
            }
        }
    }

    /**
     * 修改微信标题
     *
     * @param title 标题
     */
    fun changeWeChatTitle(title: String) {
        btWeChat.text = title
    }
}
