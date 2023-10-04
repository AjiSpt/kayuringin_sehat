package com.example.kayuringinsehat

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.example.kayuringinsehat.Rest.ApiClient
import com.example.kayuringinsehat.dataModel.ResponseRegister
import com.example.kayuringinsehat.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterActivity : AppCompatActivity() {

    companion object
    {
        lateinit var auth: FirebaseAuth

    }
    private lateinit var binding:ActivityRegisterBinding
    //buttons
    private var bRegister: Button?=null
    private var bLogin: TextView?=null

    var etNIK: EditText?=null
    var etNama: EditText?=null
    var etEmail: EditText?=null
    var etNoBPJS: EditText?=null
    var etPassword: EditText?=null
    var etConfPassword: EditText?=null
    var isAllEditTextCheck=false
    var nik=""
    var name=""
    var email=""
    var nobpjs=""
    var password=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        etNIK=binding.inputDaftarNik
        etNama=binding.inputDaftarNama
        etEmail=binding.inputDaftarTelepon
        etNoBPJS=binding.inputDaftarNoBPJS
        etPassword=binding.inputDaftarKataSandi
        etConfPassword=binding.inputDaftarKataSandi2
        bRegister=binding.btnDaftarRegister
        bLogin=binding.tvMasuk

        bRegister?.setOnClickListener { registerUser() }

        bLogin?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
    private fun registerUser()
    {
        email= etEmail?.text.toString().trim()
        password=etPassword?.text.toString().trim()
        name=etNama?.text.toString().trim()
        nik=etNIK?.text.toString().trim()
        nobpjs=etNoBPJS?.text.toString().trim()
        isAllEditTextCheck=checkAllEditText()
        if(isAllEditTextCheck){
            auth.createUserWithEmailAndPassword(email,password)
                .addOnSuccessListener {
                    updateUserInfo()
                }
                .addOnFailureListener{
                    Toast.makeText(this,"Gagal membuat akun", Toast.LENGTH_SHORT).show()
                }
        }
        else
        {
            Toast.makeText(this,"Pendaftaran Gagal", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isEmail(text: Editable?): Boolean {
        val email: CharSequence = text.toString()
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun checkAllEditText(): Boolean {
        if(etNama?.length()  ==0)
        {
            etNama?.error = "Nama harus di-isi"
            return false;
        }
        if(etNIK?.length()  ==0)
        {
            etNIK?.error = "NIK harus di-isi"
            return false;
        }
        if(etEmail?.length()==0)
        {
            etEmail?.error="Alamat Email harus di-isi"
            return false;
        }
        if(!isEmail(etEmail?.editableText))
        {
            etEmail?.error="Alamat email tidak valid"
            return false
        }
        if(etNoBPJS?.length()  ==0)
        {
            etNoBPJS?.error = "Nomor BPJS harus di-isi"
            return false;
        }
        if (etPassword!!.length() == 0) {
            etPassword!!.error = "Kata sandi tidak boleh kosong"
            return false
        } else if (etPassword!!.length() < 8) {
            etPassword!!.error = "Kata sandi minimal 8 karakter"
            return false
        }
        if(etConfPassword!!.length()==0)
        {
            etConfPassword!!.error="Konfirmasi kata sandi anda"
            return false
        }
        if(!etConfPassword?.equals(etConfPassword)!!)
        {
            etConfPassword!!.error="Kata sandi tidak cocok"
            return false
        }
        return true
    }
    private  fun updateUserInfo(){
//        save user info in firebase realtime database
//        showProgressDialog(resources.getString(R.string.Saving_User_Info))
        val uid= auth.uid
        val hashMap:HashMap<String,Any?> = HashMap()
        hashMap["uid"]=uid
        hashMap["email"]=email
        hashMap["name"]=name
        hashMap["nik"]=nik
        hashMap["nobpjs"]=nobpjs
        hashMap["profileImage"]=" "//add empty,will do in profile edit
//        set data to db
        val ref= FirebaseDatabase.getInstance().getReference("Users")
        ref.child(uid!!)
            .setValue(hashMap)
            .addOnSuccessListener {
//                user info saved dashboard open
                Toast.makeText(this,"Akun berhasil dibuat", Toast.LENGTH_SHORT).show()
                val intent= Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
            .addOnFailureListener{
//                failed adding data to db
                Toast.makeText(this,"Gagal menyimpan user info", Toast.LENGTH_SHORT).show()
            }

    }
}