package com.mohanad.myapplication.ui.presenter

import com.mohanad.myapplication.data.datasource.PostsApi
import com.mohanad.myapplication.data.model.PostModel
import com.mohanad.myapplication.util.RetrofitCon
import retrofit2.Call

class PostsPresenter (private val iPostsPresenter: IPostsPresenter){

    private fun getPostsFromApi(): Call<List<PostModel>> {
         val posts = RetrofitCon.getRetrofit()
            .create(PostsApi::class.java)
            .getPosts()
        return posts
    }

    fun getPosts(){
        iPostsPresenter.getPosts(getPostsFromApi())
    }

}