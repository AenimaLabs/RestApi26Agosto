package com.example.restapi26agosto.network

import com.example.restapi26agosto.pojo.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {

    @GET("users")
    fun groupList(): Call<ArrayList<Post>>
}