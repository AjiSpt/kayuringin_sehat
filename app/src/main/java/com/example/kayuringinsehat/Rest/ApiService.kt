package com.example.kayuringinsehat.Rest


import com.example.kayuringinsehat.dataModel.ResponseLogin
import com.example.kayuringinsehat.dataModel.ResponseRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("kayuringin_backend/autentik_akun.php?function=login_user")
    fun login(
        @Field("nik") nik: String,
        @Field("kata_sandi") kata_sandi: String
    ): Call<ResponseLogin>

    @POST("kayuringin_backend/autentik_akun.php?function=register_user")
    fun register(
        @Field("nik") nik: Int,
        @Field("nama") nama: String,
        @Field("telepon") telepon: Int,
        @Field("no_bpjs") no_bpjs: Int,
        @Field("kata_sandi") kata_sandi: String
    ): Call<ResponseRegister>
}





//import okhttp3.Call
//interface ApiService {
//
//    fun register(
//        nik: Int,
//        nama: String,
//        telepon: Int,
//        noBpjs: Int,
//        kataSandi: String
//    ): Call
//}





//Buat interface Retrofit utk mendefinisikan metode2 API
    //Method utk menambahkan data dari API
//    @POST("phpapi/phpapi_1.php?function=daftar_user")
//    fun DaftarUser(): Call<daftar_user>
//}

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
