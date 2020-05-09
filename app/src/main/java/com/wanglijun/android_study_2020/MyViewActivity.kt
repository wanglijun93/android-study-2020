package com.wanglijun.android_study_2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.wanglijun.android_study_2020.test.GitHubService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author 王丽君
 * Email：wanglijundev@gmail.com
 * 描述：view
 * 修改历史:
 * 修改日期         作者        版本        描述说明
 *
 * 创建于： 2020-03-17 21:02
 **/
class MyViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_view)
        val gson = Gson()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val gitHubService = retrofit.create(GitHubService::class.java)

        gitHubService.getRepos().enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                val reponse = Gson().toJson(response)
                print("wlj=success $reponse")
            }
        })
    }
}
