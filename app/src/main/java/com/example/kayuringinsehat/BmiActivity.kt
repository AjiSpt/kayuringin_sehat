package com.example.kayuringinsehat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


class BmiActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
//        binding = ActivityBmiBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        val berBadanText = findViewById<EditText>(R.id.berat_badan)
        val tingBadanText = findViewById<EditText>(R.id.tinggi_badan)
        val tombolHitung = findViewById<Button>(R.id.btn_hitung_bmi)

        tombolHitung.setOnClickListener {
            val berat = berBadanText.text.toString()
            val tinggi = tingBadanText.text.toString()

            val bmi = berat.toFloat()/((tinggi.toFloat()/100)*(tinggi.toFloat()/100))
            // get result with two decimal place
            val bmi2digits = String.format("%.2f",bmi).toFloat()
            hasilTampilan(bmi2digits)
        }
    }

    private fun hasilTampilan(bmi:Float){
        val gambarBMI = findViewById<ImageView>(R.id.iv_status_obesitas)
        val hasilBMI = findViewById<TextView>(R.id.tv_status_obesitas)

        hasilBMI.text = bmi.toString()

        when {
            bmi < 18.5 -> gambarBMI.setImageResource(R.drawable.underweight)
            bmi in 18.5..24.9 -> gambarBMI.setImageResource(R.drawable.normal)
            bmi in 25.0..29.9 -> gambarBMI.setImageResource(R.drawable.overweight)
            bmi > 30 -> gambarBMI.setImageResource(R.drawable.obesity)
        }
    }
    }

//        binding.btnHitungBmi.setOnClickListener {
//            hitungBMI()
//        }
//    }

//    private fun hitungBMI() {
//
//        val stringInputBerat = binding.beratBadan.text.toString()
//        val beratBmi = stringInputBerat.toDoubleOrNull()
//        if (beratBmi == )
//
//    }

//        val stringInTextField = binding.costOfServiceEditText.text.toString()
//        val cost = stringInTextField.toDoubleOrNull()
//        if (cost == null || cost == 0.0) {
//            displayTip(0.0)
//            return
//        }
//        val tipPersentage = when (binding.tipOptions.checkedRadioButtonId) {
//            R.id.option_fifteen_percent -> 0.15
//            R.id.option_eighteen_percent -> 0.18
//            else -> 0.20
//        }
//        var tip = tipPersentage * cost
//        if (binding.roundUpSwitch.isChecked) {
//            tip = kotlin.math.ceil(tip)
//        }
//        NumberFormat.getCurrencyInstance()
//        displayTip(tip)
