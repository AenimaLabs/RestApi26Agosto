package com.example.restapi26agosto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.restapi26agosto.network.ClientRetrofit
import com.example.restapi26agosto.pojo.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadApiDAta()
    }

    private fun loadApiDAta(){
        val service = ClientRetrofit.retrofitInstance()
        val call= service.groupList()
        
        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                Log.wtf("TAG", response.body().toString())
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.wtf("ERROR", t.message.toString())
            }

        })
    }
}