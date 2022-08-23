package com.b.alkhatib.retrofit_with_mvvm_pattern_examble.data

import com.b.alkhatib.retrofit_with_mvvm_pattern_examble.pojo.PostModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 كنا لما نستخدم ريتيروفيت نستخدم دائماالbuilder جديد مع كل مثود لكن باستخدام هذا الكلاس سنستخدم بيلدر واحد مع تكريره
    ولو مش موجود نعمله create
 * */

//*** 4
class PostClient {
    private var postInterface:PostInterface

    init {
        val retrofit = Retrofit.Builder()//**3
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        postInterface = retrofit.create(PostInterface::class.java)

    }


    companion object{
        val BASE_URL = "https://jsonplaceholder.typicode.com/"
        private var INSTANCE:PostClient? = null


        fun getINSTANCE(): PostClient {
           if(INSTANCE == null) {
                INSTANCE = PostClient()
            }
            return INSTANCE as PostClient
        }


    }


    fun getPosts():Call<List<PostModel>>{
        return  postInterface.getPosts()
    }

}
