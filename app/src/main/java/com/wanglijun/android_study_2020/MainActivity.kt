package com.wanglijun.android_study_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author 王丽君
 * Email：wanglijundev@gmail.com
 * 描述：APP入口页面
 * 修改历史:
 * 修改日期         作者        版本        描述说明
 *
 * 创建于： 2020-03-17 21:02
 **/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTopBar.setOnClickListener {
            startActivity(Intent(this, TopBarActivity::class.java))
        }
        tvView.setOnClickListener {
            startActivity(Intent(this, MyViewActivity::class.java))
        }
    }
}
