package com.wanglijun.statusbar

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main3.*

/**
 * @author wlj
 * @des toast dialog snackBar
 */
class Main3Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        dialog.setOnClickListener(this)
        toast.setOnClickListener(this)
        snackBar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            dialog -> {
                myDialog()
            }
            toast -> {
                ToastUtils(this, "这是一个toast")
            }
            snackBar -> {
                mySnackBar()
            }
        }
    }

    private fun myDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("标题")
            .setMessage("我是内容 \n 你好吗？")
            .setPositiveButton(
                "是"
            ) { dialog, which ->

            }
            .setNegativeButton(
                "否"
            ) { dialog, which ->

            }.show()
    }

    private fun mySnackBar() {
        Snackbar.make(dialog, "我是一个snackbar", Snackbar.LENGTH_SHORT)
            .setAction("关闭") {

            }
            .show()
    }
}
