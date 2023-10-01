package com.example.kayuringinsehat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kayuringinsehat.Rest.ApiClient
//import com.example.kayuringinsehat.dataModel.ResponseLogin
import com.example.kayuringinsehat.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    //private var nik = binding.inputNik.text.toString().toInt()
    //private var kataSandi = binding.inputKatasandi.text.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

         //TODO: UNTUK CEK KONEKSI INTERNET ANDROID ANDA WAHAI USER!!!!
//        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val networkInfo = connectivityManager.activeNetworkInfo
//
//        if (networkInfo != null && networkInfo.isConnected) {
//        } else {
//            // Tidak ada koneksi internet
//            Toast.makeText(this, "Tidak Ada Koneksi Internet", Toast.LENGTH_LONG).show()
//        }

        // TODO: ketika pencet tombol MASUK
        binding.btnMasuk.setOnClickListener {
            val nik = binding.inputNik.text.toString()
            val kataSandi = binding.inputKatasandi.text.toString()

            var valid = true

            if(nik.isEmpty()){
                binding.inputNik.error = "NIK Belum Diisi"
                valid = false
            }
            if(kataSandi.isEmpty()){
                binding.inputKatasandi.error = "Kata Sandi Belum Diisi"
                valid = false
            }
            if(valid){
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                getData()
            }else{
                Toast.makeText(this, "Isi Bidang Yang Kosong", Toast.LENGTH_SHORT).show()
            }
        }

        // TODO: ketika pencet tombol DAFTAR
        binding.tombolDaftar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
                }
        }

    private fun getData(){
        val nik = binding.inputNik.text.toString()
        val kataSandi = binding.inputKatasandi.text.toString()
        val api = ApiClient().getInstance()
        api.login(nik, kataSandi).enqueue(/* callback = */ object : Callback<ResponseLogin> {
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                if (response.isSuccessful) {
                    if (response.body()?.response == true) {
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity, "Login Gagal", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Login Gagal", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.e("Pesan error","${t.message}" )
            }
        })
    }
}
