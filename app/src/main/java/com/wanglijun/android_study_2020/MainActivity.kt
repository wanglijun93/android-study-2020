package com.wanglijun.android_study_2020

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        topBar.setOnTopBarClickListener(object : TopBarView.topBarOnClickListener {
            override fun leftClick() {
                Toast.makeText(this@MainActivity,getString(R.string.back),Toast.LENGTH_SHORT).show()
            }

            override fun rightClick() {
                Toast.makeText(this@MainActivity,getString(R.string.more),Toast.LENGTH_SHORT).show()
            }

            override fun titleClick() {
                Toast.makeText(this@MainActivity,getString(R.string.title),Toast.LENGTH_SHORT).show()
            }
        })
    }
}
