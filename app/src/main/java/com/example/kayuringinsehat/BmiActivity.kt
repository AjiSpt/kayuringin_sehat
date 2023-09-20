package com.example.kayuringinsehat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.kayuringinsehat.databinding.ActivityBmiBinding
import java.util.Locale


class BmiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitungBmi.setOnClickListener {
            val berat = binding.beratBadan.text.toString()
            val tinggi = binding.tinggiBadan.text.toString()
            if (validateInput(berat, tinggi)) {
                val bmi = berat.toFloat() / ((tinggi.toFloat() / 100) * (tinggi.toFloat() / 100))
                val bmi2digits = String.format(Locale.US, "%.2f", bmi).toFloat()
                hasilTampilan(bmi2digits)
            }
        }
    }

    private fun validateInput(berat: String?, tinggi: String?): Boolean {
        return when {
            berat.isNullOrEmpty() -> {
                Toast.makeText(this, "Berat Badan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
                false
            }
            tinggi.isNullOrEmpty() -> {
                Toast.makeText(this, "Tinggi Badan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }

    private fun hasilTampilan(bmi: Float) {
        binding.tvStatusObesitas.text = bmi.toString()
        var color = 0

        when {
            bmi < 18.5 -> {
                binding.ivStatusObesitas.setImageResource(R.drawable.underweight)
                color = R.color.biruBMICharacter
            }

            bmi in 18.5..24.9 -> {
                binding.ivStatusObesitas.setImageResource(R.drawable.normal)
                color = R.color.hijauBMIcharacter
            }

            bmi in 25.0..29.9 -> {
                binding.ivStatusObesitas.setImageResource(R.drawable.overweight)
                color = R.color.orangeBMICharacter
            }

            bmi >= 30 -> {
                binding.ivStatusObesitas.setImageResource(R.drawable.obesity)
                color = R.color.merahBMICharacter
            }
        }
        binding.tvStatusObesitas.setTextColor(ContextCompat.getColor(this, color))
    }
}
