package com.example.apicall

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {


    @GET("posts")



    fun Datainterface():Call<List<PassmodelItem>>
}