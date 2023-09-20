package com.example.kayuringinsehat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat


class BmiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        val berBadanText = findViewById<EditText>(R.id.berat_badan)
        val tingBadanText = findViewById<EditText>(R.id.tinggi_badan)
        val tombolHitung = findViewById<Button>(R.id.btn_hitung_bmi)

        tombolHitung.setOnClickListener {
            val berat = berBadanText.text.toString()
            val tinggi = tingBadanText.text.toString()
            if (validateInput(berat, tinggi)) {
                val bmi = berat.toFloat() / ((tinggi.toFloat() / 100) * (tinggi.toFloat() / 100))
                // get result with two decimal place
                val bmi2digits = String.format("%.2f", bmi).toFloat()
                hasilTampilan(bmi2digits)
            }
        }
    }

    private fun validateInput(berat: String?, tinggi: String?): Boolean {
        return when {
            berat.isNullOrEmpty() -> {
                Toast.makeText(this, "Berat Badan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
                return false
            }
            tinggi.isNullOrEmpty() -> {
                Toast.makeText(this, "Tinggi Badan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
                return false
            }
            else -> {
                return true
            }
        }
    }

    private fun hasilTampilan(bmi: Float) {
        val gambarBMI = findViewById<ImageView>(R.id.iv_status_obesitas)
        val hasilBMI = findViewById<TextView>(R.id.tv_status_obesitas)

        hasilBMI.text = bmi.toString()
        var color = 0

        when {
            bmi < 18.5 -> {
                gambarBMI.setImageResource(R.drawable.underweight)
                color = R.color.biruBMICharacter
            }

            bmi in 18.5..24.9 -> {
                gambarBMI.setImageResource(R.drawable.normal)
                color = R.color.hijauBMIcharacter
            }

            bmi in 25.0..29.9 -> {
                gambarBMI.setImageResource(R.drawable.overweight)
                color = R.color.orangeBMICharacter
            }

            bmi > 30 -> {
                gambarBMI.setImageResource(R.drawable.obesity)
                color = R.color.merahBMICharacter
            }
        }
        hasilBMI.setTextColor(ContextCompat.getColor(this, color))
    }
}
