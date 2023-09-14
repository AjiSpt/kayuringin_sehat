package com.example.kayuringinsehat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kayuringinsehat.databinding.ActivityBmiBinding
import java.text.NumberFormat

class BmiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)
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




}