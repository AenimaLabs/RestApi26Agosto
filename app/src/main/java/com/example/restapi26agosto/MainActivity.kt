package com.example.restapi26agosto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi26agosto.network.ClientRetrofit
import com.example.restapi26agosto.pojo.Post
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private var postList = ArrayList<Post>()
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewAdapter = PostAdapter(postList)
        postRecyclerView.adapter = viewAdapter
        loadApiDAta()
    }

    private fun loadApiDAta(){
        val service = ClientRetrofit.retrofitInstance()
        val call= service.groupList()
        
        call.enqueue(object : Callback<ArrayList<Post>> {
            override fun onResponse(call: Call<ArrayList<Post>>, response: Response<ArrayList<Post>>) {
               response.body()?.map {

                   Log.wtf("MAIN", "${it.id} - ${it.name} - ${it.email} - ${it.phone}")
                        postList.add(it)


            }
                viewAdapter.notifyDataSetChanged()}


            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                Log.wtf("MAIN", "Error" + t)
                Toast.makeText(applicationContext, "Error: cagó la weá", Toast.LENGTH_SHORT).show()
            }

        })
    }
}




