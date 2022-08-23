package com.b.alkhatib.retrofit_with_mvvm_pattern_examble.ui.main

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b.alkhatib.retrofit_with_mvvm_pattern_examble.databinding.PostItemBinding
import com.b.alkhatib.retrofit_with_mvvm_pattern_examble.pojo.PostModel

class PostsAdapter(var activity: Activity,var data: List<PostModel>) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    class PostViewHolder(var binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = PostItemBinding.inflate(activity.layoutInflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.binding.tvTitle.text = data[position].title
        holder.binding.tvBody.text = data[position].body
        holder.binding.tvUserId.text = data[position].userId.toString()

    }

    override fun getItemCount(): Int {
        if(data == null){
            return 0
        }else{
            return data!!.size
        }
    }
}