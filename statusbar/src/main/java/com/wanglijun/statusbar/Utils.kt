package com.wanglijun.statusbar

import android.content.Context
import android.widget.Toast

/**
 * @author： wlj
 * @Date: 2020-05-22
 * @email: wanglijundev@gmail.com
 * @desc:
 */
fun ToastUtils(context: Context, content: String) {

    var toast: Toast? = null
    if (toast == null) {
        toast = Toast.makeText(context, content, Toast.LENGTH_SHORT)
    } else {
        toast.setText(content)
    }
    toast?.show()
}