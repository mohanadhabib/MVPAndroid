package com.mohanad.myapplication.ui.presenter

import com.mohanad.myapplication.data.model.PostModel
import retrofit2.Call

interface IPostsPresenter {

    fun getPosts(call:Call<List<PostModel>>)

}