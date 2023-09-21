package com.example.kayuringinsehat

import android.R
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import com.example.kayuringinsehat.databinding.ActivityGiziBinding
import com.google.android.material.textfield.TextInputLayout
import com.google.android.play.integrity.internal.c
import kotlin.math.ceil

class GiziActivity : AppCompatActivity() {

    //TODO: Deklarasi Variabel Binding sebagai Instance ActivityMainBinding.
    private lateinit var binding: ActivityGiziBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO: Membuat Binding Instance dari Layout activity_gizi.xml
        binding = ActivityGiziBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,
            (1..18).map { it.toString() }.toList()
        )
        binding.autoCompleteText.setAdapter(adapter)
        binding.autoCompleteText.setOnClickListener {
            binding.autoCompleteText.showDropDown()
        }

        binding.buttonHitunggizi.setOnClickListener {
            hitung_giziBasal()
        }
    }

    private fun hitung_giziBasal() {

        //TODO: Ambil data yg diinput user ke Tinggi Badan
        val tinggiBadan = binding.tinggibadanGiziEdittext.text

        //TODO: Ambil data yang diinput user ke Berat Badan
        val beratBadan = binding.beratbadanGiziEdittext.text.toString()

        //TODO: Ambil data yang diinput user ke Usia Anak
        val usiaAnak = binding.autoCompleteText.text.toString()

        //val energiBasal = tinggiBadan * 1.2


//        var energi_basal = (50 + (2.2 * beratBadan!!) + (1.2 * tinggiBadan!!) - (0.2 * usiaAnak!!)) * 24
//        ceil(energi_basal).also { energi_basal = it }
//        binding.hasilgizi.text = getString(R.string.nilai_basal, energi_basal)
    }

//    private fun hitung_giziTotal(){
//
//        //TODO: Ambil data yang diinput user ke Aktivitas Harian
//        val aktivitasHarian = when (binding.radiogroupAktivitas.checkedRadioButtonId) {
//            R.id.istirahat -> 1.2
//            R.id.ringan -> 1.3
//            R.id.sedang -> 1.5
//            R.id.berat -> 1.7
//            else -> 1.9
//        }
//    }


}