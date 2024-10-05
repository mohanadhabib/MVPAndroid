package com.mohanad.myapplication.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitCon {

    companion object {

        @Volatile
        private var retrofit:Retrofit? = null

        fun getRetrofit():Retrofit{
            synchronized(this){
                if(retrofit == null){
                    retrofit = Retrofit.Builder()
                        .baseUrl(Constant.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit!!
            }
        }
    }
}