package com.example.restapi26agosto

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.RuntimeException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

fun main(){

    val test = Test()
    test.connectApi()

}

class Test {
fun connectApi(){
    try {
        val url = URL("https://jsonplaceholder.typicode.com/posts")
        val conn = url.openConnection() as HttpURLConnection

        conn.requestMethod = "GET"
        if (conn.responseCode != 200){
            throw RuntimeException("Failed: HTTP error code . " + conn.responseCode)
        }
    val br = BufferedReader(InputStreamReader(conn.inputStream))
        println("Output from server ...")
        while (br.readLine() != null){
            println(br.readLine())
        }
        conn.disconnect()
    }catch (e: MalformedURLException){
        e.printStackTrace()
    }catch (e: IOException){
        e.printStackTrace()
    }
}}