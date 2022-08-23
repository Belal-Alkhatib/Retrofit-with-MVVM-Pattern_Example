package com.b.alkhatib.retrofit_with_mvvm_pattern_examble.data

import com.b.alkhatib.retrofit_with_mvvm_pattern_examble.pojo.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostInterface {

    // *** 3
    @GET("posts")
    fun getPosts(): Call<List<PostModel>>
}