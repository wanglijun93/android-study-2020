package com.wanglijun.wechat_app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wanglijun.wechat_app.R
import kotlinx.android.synthetic.main.fragment_tab.*

/**
 * @author： wlj
 * @Date: 2020-04-04
 * @email: wanglijundev@gmail.com
 * @desc: Fragment
 */
class TabFragment : Fragment() {

    private var mTitle: String? = null

    companion object {
        const val BUNDLE_KEY_TITLE = "key_title"
        fun newInstance(title: String): TabFragment {
            val bundle = Bundle()
            bundle.putString(BUNDLE_KEY_TITLE, title)
            val tabFragment = TabFragment()
            tabFragment.arguments = bundle
            return tabFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mTitle = arguments?.getString(BUNDLE_KEY_TITLE, "")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle.text = mTitle
        tvTitle.setOnClickListener {
            mListener?.onClick("微信改变")
        }
    }

    fun changeTitle(title: String) {
        if (isAdded.not()) {
            return
        }
        tvTitle.text = title
    }

    interface onTitleChangeListener {
        fun onClick(title: String)
    }

    var mListener: onTitleChangeListener? = null

    fun setOnTitleChangeListener(onTitleChangeListener: onTitleChangeListener) {
        mListener = onTitleChangeListener
    }
}
