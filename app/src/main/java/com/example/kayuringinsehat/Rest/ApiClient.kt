package com.example.kayuringinsehat.Rest


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "http://192.168.43.110"
    private fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getInstance(): ApiService {
        return getRetrofitClient().create(ApiService::class.java)
    }
}

//192.168.43.110









//import okhttp3.Call
//import okhttp3.FormBody
//import okhttp3.OkHttpClient
//import okhttp3.Request

//class ApiClient: ApiService {
//
//     private val client = OkHttpClient()
//
//     override fun register(
//         nik: Int,
//         nama: String,
//         telepon: Int,
//         noBpjs: Int,
//         kataSandi: String
//     ): Call {
//         val url = "http://localhost/phpapi/phpapi_1.php"
//         val requestBody = FormBody.Builder()
//             .add("nik", nik.toString())
//             .add("nama", nama)
//             .add("telepon", telepon.toString())
//             .add("no_bpjs", noBpjs.toString())
//             .add("kata_sandi", kataSandi)
//             .build()
//         val request = Request.Builder()
//             .url(url)
//             .post(requestBody)
//             .build()
//         return client.newCall(request)
//     }
// }




    //Alamat server localhost
    //private val BASE_URL = "http://127.0.0.1/"

    //Buat Retrofit Instance
    //private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
