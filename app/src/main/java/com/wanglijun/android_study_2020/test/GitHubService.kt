package com.wanglijun.android_study_2020.test

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author： wlj
 * @Date: 2020-04-29
 * @email: wanglijundev@gmail.com
 * @desc:
 */
interface GitHubService {
    @GET("users/wanglijun93/repos")
    fun getRepos(): Call<ResponseBody>
}