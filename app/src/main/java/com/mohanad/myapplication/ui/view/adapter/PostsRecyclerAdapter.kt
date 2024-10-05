package com.mohanad.myapplication.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohanad.myapplication.data.model.PostModel
import com.mohanad.myapplication.databinding.ItemPostBinding

class PostsRecyclerAdapter(private val posts:List<PostModel>) : RecyclerView.Adapter<PostsRecyclerAdapter.PostsViewHolder>() {



    class PostsViewHolder(val binding:ItemPostBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(layoutInflater)
        return PostsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.binding.body.text = posts[position].body
        holder.binding.title.text = posts[position].title
    }
}