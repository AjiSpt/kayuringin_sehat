package com.example.kayuringinsehat.Rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    //Alamat server localhost
    private val BASE_URL = "http://127.0.0.1/"

    //Buat Retrofit Instance
    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
}
