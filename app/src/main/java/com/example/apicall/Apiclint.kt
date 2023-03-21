package com.example.apicall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Apiclint {

    companion object{
   var Base_url="https://gorest.co.in/public/v2/"

        lateinit var retrofit :Retrofit

        fun getdata():Retrofit{

            retrofit=Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
    }
}