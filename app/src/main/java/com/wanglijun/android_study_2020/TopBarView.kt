package com.wanglijun.android_study_2020

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView

/**
 * @author： wlj
 * @Date: 2020-03-17
 * @email: wanglijundev@gmail.com
 * @desc: 自定义TopBar
 */
class TopBarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    private var mTvTitle: TextView? = null
    private var mLeftButton: Button? = null
    private var mRightButton: Button? = null

    private var mTitleColor: Int? = null
    private var mTitleSize: Float? = null
    private var mTitle: String? = null

    private var mLeftText: String? = null
    private var mLeftBackground: Drawable? = null
    private var mLeftTextSize: Float? = null
    private var mLeftTextColor: Int? = null

    private var mRightText: String? = null
    private var mRightBackground: Drawable? = null
    private var mRightTextSize: Float? = null
    private var mRightTextColor: Int? = null

    private var mLeftLayoutParams: LayoutParams? = null
    private var mRightLayoutParams: LayoutParams? = null
    private var mTitleLayoutParams: LayoutParams? = null

    interface topBarOnClickListener {
        fun leftClick()
        fun rightClick()
        fun titleClick()
    }

    var listener: topBarOnClickListener? = null

    fun setOnTopBarClickListener(listener: topBarOnClickListener) {
        this.listener = listener
    }

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.TopBar)
        mTitle = attributes.getString(R.styleable.TopBar_title)
        mTitleSize = attributes.getDimension(R.styleable.TopBar_titleSize, 0f)
        mTitleColor = attributes.getColor(R.styleable.TopBar_titleColor, 0)

        mLeftText = attributes.getString(R.styleable.TopBar_leftText)
        mLeftTextSize = attributes.getDimension(R.styleable.TopBar_leftTextSize, 0f)
        mLeftTextColor = attributes.getColor(R.styleable.TopBar_leftTextColor, 0)
        mLeftBackground = attributes.getDrawable(R.styleable.TopBar_leftTextBackground)

        mRightText = attributes.getString(R.styleable.TopBar_rightText)
        mRightTextSize = attributes.getDimension(R.styleable.TopBar_rightTextSize, 0f)
        mRightTextColor = attributes.getColor(R.styleable.TopBar_rightTextColor, 0)
        mRightBackground = attributes.getDrawable(R.styleable.TopBar_rightTextBackground)

        attributes.recycle()

        initView(context)

    }

    private fun initView(context: Context) {
        mTvTitle = TextView(context)
        mLeftButton = Button(context)
        mRightButton = Button(context)

        mTvTitle?.text = mTitle
        mTitleColor?.let {
            mTvTitle?.setTextColor(it)
        }
        mTvTitle?.textSize = mTitleSize as Float
        mTvTitle?.gravity = Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL

        mLeftButton?.text = mLeftText
        mLeftTextColor?.let {
            mLeftButton?.setTextColor(it)
        }
        mLeftButton?.textSize = mLeftTextSize as Float
        mLeftButton?.background = mLeftBackground

        mRightButton?.text = mRightText
        mRightTextColor?.let {
            mRightButton?.setTextColor(it)
        }
        mRightButton?.textSize = mRightTextSize as Float
        mRightButton?.background = mRightBackground

        setBackgroundColor(0xff59563)

        mLeftLayoutParams =
            LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        mLeftLayoutParams?.addRule(ALIGN_PARENT_LEFT, TRUE)
        addView(mLeftButton, mLeftLayoutParams)

        mRightLayoutParams =
            LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        mRightLayoutParams?.addRule(ALIGN_PARENT_RIGHT, TRUE)
        addView(mRightButton, mRightLayoutParams)

        mTitleLayoutParams =
            LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
        mTitleLayoutParams?.addRule(CENTER_IN_PARENT, TRUE)
        addView(mTvTitle, mTitleLayoutParams)

        mLeftButton?.setOnClickListener {
            listener?.leftClick()
        }
        mRightButton?.setOnClickListener {
            listener?.rightClick()
        }
        mTvTitle?.setOnClickListener {
            listener?.titleClick()
        }
    }


}