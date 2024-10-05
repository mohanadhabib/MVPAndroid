package com.mohanad.myapplication.data.datasource

import com.mohanad.myapplication.data.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostsApi {

    @GET("posts")
    fun getPosts():Call<List<PostModel>>

}