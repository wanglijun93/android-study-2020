package com.wanglijun.wechat_app.utils

import android.util.Log
import com.wanglijun.wechat_app.BuildConfig
import java.util.*

/**
 * @author： wlj
 * @Date: 2020-04-04
 * @email: wanglijundev@gmail.com
 * @desc: Log封装
 */
class L {

    companion object {
        private const val Tag = "wlj"
        private val sDebug = BuildConfig.DEBUG
        fun d(msg: String, args: Objects? = null) {
            if (sDebug.not()) {
                return
            }
            Log.d(Tag, String.format(msg, args))
        }
    }
}