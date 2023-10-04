package com.example.kayuringinsehat

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import com.example.kayuringinsehat.Rest.ApiClient
import com.example.kayuringinsehat.dataModel.ResponseLogin
//import com.example.kayuringinsehat.dataModel.ResponseLogin
import com.example.kayuringinsehat.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var mProgressDialog: Dialog
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var bLogin: Button? = null
    private var isAllDetailsChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth= FirebaseAuth.getInstance()
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        etEmail = binding.inputNik
        etPassword = binding.inputKatasandi
        bLogin = binding.btnMasuk

        binding.tvDaftar.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        bLogin!!.setOnClickListener {

            if (validateLoginDetails()) {
                val email = etEmail!!.text.toString().trim()
                val password = etPassword!!.text.toString().trim()
                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                            val intent= Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                    }
                    .addOnFailureListener {
                        hideProgressDialog()
                        Toast.makeText(
                            this,
                            "Login Failed due to ${it.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            }
        }
    }

    private fun hideProgressDialog() {
        mProgressDialog.dismiss()
    }

    private fun validateLoginDetails(): Boolean {
        isAllDetailsChecked = checkAllDetails()

        return if (isAllDetailsChecked) {
            true
        } else {
            Toast.makeText(this, "Login Gagal", Toast.LENGTH_LONG).show()
            false
        }
    }

    private fun isEmail(text: Editable?): Boolean {
        val email: CharSequence = text.toString()
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun checkAllDetails(): Boolean {
        if (etEmail?.length() == 0) {
            etEmail?.error = "Email tidak boleh kosong"
            return false
        }
        if (!isEmail(etEmail?.editableText)) {
            etEmail?.error = "Alamat email tidak valid"
            return false
        }
        if (etPassword!!.length() == 0) {
            etPassword!!.error = "Kata sandi tidak boleh kosong"
            return false
        } else if (etPassword!!.length() < 8) {
            etPassword!!.error = "Kata sandi minimal 8 karakter"
            return false
        }
        return true
    }
}
