package com.example.restapi26agosto.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {

    companion object {
        private const val Base_Url = "https://jsonplaceholder.typicode.com"

        fun retrofitInstance(): ApiClient{
            val retrofit= Retrofit.Builder().baseUrl(Base_Url).addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit.create(ApiClient::class.java)

        }
    }
}