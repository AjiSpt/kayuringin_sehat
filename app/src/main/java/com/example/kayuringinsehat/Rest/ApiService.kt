package com.example.kayuringinsehat.Rest

import com.example.kayuringinsehat.DataModel.User
import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    //Buat interface Retrofit utk mendefinisikan metode2 API

    //Method utk menambahkan data dari API
    @POST("phpapi/phpapi_1.php?function=daftar_user")
    fun DaftarUser(): Call<daftar_user>
}

//        // Contoh metode untuk menambahkan data baru ke API
//        @POST("user")
//        fun addUser(@Body user: User): Call<User>
//
//        // Contoh metode untuk memperbarui data di API
//        @PUT("user/{userId}")
//        fun updateUser(@Path("userId") userId: Int, @Body user: User): Call<User>
//
//        // Contoh metode untuk menghapus data dari API
//        @DELETE("user/{userId}")
//        fun deleteUser(@Path("userId") userId: Int): Call<Void>
//    }
//
//    // Mendapatkan instance ApiService dari Retrofit
//    val apiService: ApiService by lazy {
//        retrofit.create(ApiService::class.java)
//    }
//}
