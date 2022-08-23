package com.b.alkhatib.retrofit_with_mvvm_pattern_examble.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.b.alkhatib.retrofit_with_mvvm_pattern_examble.R
import com.b.alkhatib.retrofit_with_mvvm_pattern_examble.data.PostClient
import com.b.alkhatib.retrofit_with_mvvm_pattern_examble.databinding.ActivityMainBinding
import com.b.alkhatib.retrofit_with_mvvm_pattern_examble.pojo.PostModel

class MainActivity : AppCompatActivity() {
    lateinit var postViewModel: PostViewModel
    lateinit var postAdapter:PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
/**
         تذكر اضافة الدبندنسي الخاصة بالفيو مودل والايف داتا
         نختار ViewModelProviders اللي بs
        this: الخاص بنا هو هذه الاكتيفيتيview model الذي سيستمع لل ui controlerال
        get(PostViewModel::class.java):  الذي أريده view model نوع ال
*/


        // *** 6
        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        postViewModel.getPosts()


        // *** 7 : RecyclerView -> a.item view رسم ال ___ b.انشاء الادابتر ___ c.  داخل الاكتيفيتي الخاصة فيهاrv عمل ال
        // *** 7 b :call back اذهب للفيو مودل لاعداد ال rv بعد الانتهاء من اعداد ال


        postViewModel.postMutableLiveData.observe(this,object : Observer<List<PostModel>>{
            override fun onChanged(t: List<PostModel>?) {
                binding.rvPosts.layoutManager = LinearLayoutManager(this@MainActivity)
                postAdapter = PostsAdapter(this@MainActivity, t!!)
                binding.rvPosts.adapter = postAdapter




            //Log.e("hzm",t[0].userId.toString())
            }

        })


    }
}