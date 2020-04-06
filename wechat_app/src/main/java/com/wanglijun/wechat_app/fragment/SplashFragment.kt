package com.wanglijun.wechat_app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wanglijun.wechat_app.R
import kotlinx.android.synthetic.main.fragment_splash.*

/**
 * @author： wlj
 * @Date: 2020-04-06
 * @email: wanglijundev@gmail.com
 * @desc: viewpager 配合 splash
 */
class SplashFragment : Fragment() {

    private var mResId = 0

    companion object {
        const val BUNDLE_KEY_RES_ID = "bundle_key_res_id"
        fun newInstance(resId: Int): SplashFragment {
            val bundle = Bundle()
            bundle.putInt(BUNDLE_KEY_RES_ID, resId)
            val fragment = SplashFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivContent.setImageResource(mResId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         mResId = arguments?.getInt(BUNDLE_KEY_RES_ID,0) ?: 0
    }
}