package com.example.kayuringinsehat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
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
        binding.cvKembaliBMI.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Menampilkan efek sentuhan saat ditekan
                    binding.cvKembaliBMI.animate().scaleX(0.9f).scaleY(0.9f).start()
                }
                MotionEvent.ACTION_UP -> {
                    // Mengembalikan ukuran cardview ke semula
                    binding.cvKembaliBMI.animate().scaleX(1f).scaleY(1f).start()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            true
        }
    }

    private fun validateInput(berat: String?, tinggi: String?): Boolean {
        when {
            berat.isNullOrEmpty() -> {
                Toast.makeText(this, "Berat Badan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
                return false
            }
            tinggi.isNullOrEmpty() -> {
                Toast.makeText(this, "Tinggi Badan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
                return false
            }
            else -> return true
        }
    }

    private fun hasilTampilan(bmi: Float ) {
        binding.tvStatusObesitas.text = bmi.toString()
        binding.tvImt.text = "Index Masa Tubuh Anda"
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
            bmi > 30 -> {
                binding.ivStatusObesitas.setImageResource(R.drawable.obesity)
                color = R.color.merahBMICharacter
            }
        }
        binding.tvStatusObesitas.setTextColor(ContextCompat.getColor(this, color))
    }
}
