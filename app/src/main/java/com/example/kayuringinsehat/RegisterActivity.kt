package com.example.kayuringinsehat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kayuringinsehat.Rest.ApiClient
import com.example.kayuringinsehat.dataModel.ResponseRegister
import com.example.kayuringinsehat.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: ketika pencet tombol Masuk
        binding.btnMasukRegister.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        //TODO: ketika pencet tombol DAFTAR
        binding.btnDaftarRegister.setOnClickListener {
            val nik = binding.inputDaftarNik.text.toString()
            val nama = binding.inputDaftarNama.text.toString()
            val telepon = binding.inputDaftarTelepon.text.toString()
            val no_bpjs = binding.inputDaftarNoBPJS.text.toString()
            val kataSandi = binding.inputDaftarKataSandi.text.toString()
            val ulangKataSandi = binding.inputDaftarKataSandi2.text.toString()

            var valid = true

            if(nik.isEmpty()){
                binding.inputDaftarNik.error = "NIK Belum Diisi"
                valid = false
            }
            if(nama.isEmpty()){
                binding.inputDaftarNama.error = "Nama Belum Diisi"
                valid = false
            }
            if(telepon.isEmpty()){
                binding.inputDaftarTelepon.error = "Telepon Belum Diisi"
                valid = false
            }
            if(no_bpjs.isEmpty()){
                binding.inputDaftarNoBPJS.error = "Nomor BPJS Belum Diisi"
                valid = false
            }
            if(kataSandi.isEmpty()){
                binding.inputDaftarKataSandi.error = "Kata Sandi Belum Diisi"
                valid = false
            }
            if(ulangKataSandi.isEmpty() && ulangKataSandi != kataSandi){
                binding.inputDaftarKataSandi2.error = "Kata Sandi Belum Sesuai"
                valid = false
            }

            if(valid){
                Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                getRegister()
            }else{
                Toast.makeText(this, "Isi Bidang Yang Kosong", Toast.LENGTH_SHORT).show()
            }
            //startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun getRegister(){
        val nik = binding.inputDaftarNik.text.toString().toInt()
        val nama = binding.inputDaftarNama.text.toString()
        val telepon = binding.inputDaftarTelepon.text.toString().toInt()
        val no_bpjs = binding.inputDaftarNoBPJS.text.toString().toInt()
        val kataSandi = binding.inputDaftarKataSandi.text.toString()

        val apiRegister = ApiClient().getInstance()
        apiRegister.register(nik, nama, telepon, no_bpjs, kataSandi).enqueue(object : Callback<ResponseRegister> {
            override fun onResponse(call: Call<ResponseRegister>, response: Response<ResponseRegister>){
                if (response.isSuccessful) {
                    if (response.body()?.response == true) {
                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this@RegisterActivity, "Register Gagal", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this@RegisterActivity, "Register Gagal", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                Log.e("Pesan error","${t.message}" )
            }
        })
    }
}
