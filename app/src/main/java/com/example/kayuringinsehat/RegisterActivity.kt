package com.example.kayuringinsehat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kayuringinsehat.Rest.ApiClient
import com.example.kayuringinsehat.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Response
import okhttp3.ResponseBody
import retrofit2.Callback


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: ketika pencet tombol DAFTAR
        binding.btnMasukRegister.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnDaftarRegister.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }


//        val nik = binding.tfDaftarNik.text.toString().toInt()
//        val nama = binding.tfDaftarNama.text.toString()
//        val telepon = binding.tfDaftarTelepon.text.toString().toInt()
//        val noBpjs = binding.tfDaftarNoBPJS.text.toString().toInt()
//        val kataSandi = binding.tfDaftarKataSandi.text.toString()
//
//        //val user = registerPage(nik, nama, telepon, noBpjs, kataSandi)
//
//        val apiClient = ApiClient().getInstance()
//        apiClient.register(nik, nama, telepon, noBpjs, kataSandi).enqueue(object: Callback<ResponseBody> {
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                runOnUiThread {
//                    Toast.makeText(this@RegisterActivity, "Register Gagal", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//             override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                if (response.isSuccessful) {
//                    runOnUiThread {
//                        Toast.makeText(this@RegisterActivity, "Register Berhasil", Toast.LENGTH_SHORT)
//                            .show()
//                    }
//                }
//            }
//        })
    }
}
