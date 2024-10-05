package com.mohanad.myapplication.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohanad.myapplication.data.model.PostModel
import com.mohanad.myapplication.databinding.ActivityPostsBinding
import com.mohanad.myapplication.ui.presenter.IPostsPresenter
import com.mohanad.myapplication.ui.presenter.PostsPresenter
import com.mohanad.myapplication.ui.view.adapter.PostsRecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostsActivity : AppCompatActivity(),IPostsPresenter{
    private lateinit var binding:ActivityPostsBinding
    private lateinit var presenter:PostsPresenter
    private lateinit var adapter:PostsRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = PostsPresenter(this)
        presenter.getPosts()
    }

    override fun getPosts(call: Call<List<PostModel>>) {
        call.enqueue(object :Callback<List<PostModel>>{
            override fun onResponse(p0: Call<List<PostModel>>, posts: Response<List<PostModel>>) {
                adapter = PostsRecyclerAdapter(posts.body()!!)
                binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
                binding.recyclerView.adapter = adapter
            }

            override fun onFailure(p0: Call<List<PostModel>>, p1: Throwable) {
                Toast.makeText(applicationContext,"Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

}