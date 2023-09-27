package com.example.kayuringinsehat

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // TODO: UNTUK CEK KONEKSI INTERNET ANDROID ANDA WAHAI USER!!!!
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {
            // Ada koneksi internet
        } else {
            // Tidak ada koneksi internet
        }


    }
}