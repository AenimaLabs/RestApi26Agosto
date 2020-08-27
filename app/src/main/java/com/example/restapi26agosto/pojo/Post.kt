package com.example.restapi26agosto.pojo

import com.google.gson.annotations.SerializedName
import java.net.Inet4Address

data class Post (@SerializedName ("id") val id: Int, val name: String, val email: String, val phone: String){
}