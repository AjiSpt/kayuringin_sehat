package com.example.kayuringinsehat

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.kayuringinsehat.databinding.ActivityGiziBinding
import java.text.NumberFormat

class GiziActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGiziBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGiziBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,
            (1..18).map { it.toString() }.toList()
        )
        binding.usiaAnak.setAdapter(adapter)
        binding.usiaAnak.setOnClickListener {
            binding.usiaAnak.showDropDown()
        }

        binding.buttonHitunggizi.setOnClickListener {
            hitungGizi()
        }

        binding.cardviewKembaliGizi.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Menampilkan efek sentuhan saat ditekan
                    binding.cardviewKembaliGizi.animate().scaleX(0.9f).scaleY(0.9f).start()
                }
                MotionEvent.ACTION_UP -> {
                    // Mengembalikan ukuran cardview ke semula
                    binding.cardviewKembaliGizi.animate().scaleX(1f).scaleY(1f).start()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            true
        }

        binding.cardviewProfileGizi.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.cardviewProfileGizi.animate().scaleX(0.9f).scaleY(0.9f).start()
                }
                MotionEvent.ACTION_UP -> {
                    binding.cardviewProfileGizi.animate().scaleX(1f).scaleY(1f).start()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            true
                //val intent = Intent(this, MainActivity::class.java)
                //startActivity(intent)
        }
    }

    //TODO: blok kode untuk pindah ke fragment Atur_Akun tapi belum selesai
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val fragmentAkun = AturAkunFragment()
            val bundle = data?.extras
            fragmentAkun.arguments = bundle
            //fragmentAkun.arguments = data

            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragmentAkun)
                .commit()
        }
    }

    fun hitungGizi() {
        val inputTinggi = binding.tinggibadanGiziEdittext.text.toString()
        val tinggi = inputTinggi.toIntOrNull()
        if (tinggi == null || tinggi == 0) {
            displaygizi(0.0, 0.0)
            Toast.makeText(this, "Tinggi Badan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            return
        }

        val inputBerat = binding.beratbadanGiziEdittext.text.toString()
        val berat = inputBerat.toDoubleOrNull()
        if (berat == null || berat == 0.0) {
            displaygizi(0.0, 0.0)
            Toast.makeText(this, "Berat Badan Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            return
        }

        val inputUsia = binding.usiaAnak.text.toString()
        val usia = inputUsia.toIntOrNull()
        if (usia == null || usia == 0) {
            displaygizi(0.0, 0.0)
            Toast.makeText(this, "Usia Anak Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            return
        }

        val faktorAktivitas = when (binding.radioGroupAktivitas.checkedRadioButtonId) {
            R.id.option_istirahat -> 1.2
            R.id.option_ringan -> 1.3
            R.id.option_sedang -> 1.5
            R.id.option_berat -> 1.7
            else -> 1.9
        }

        val GiziBasal = (50 + (2.2 * berat) + (1.2 * tinggi) - (0.2 * usia)) * 24
        val nilaiGiziBasal = kotlin.math.ceil(GiziBasal)

        val GiziTotal = nilaiGiziBasal * faktorAktivitas
        val nilaiGiziTotal = kotlin.math.ceil(GiziTotal)

        displaygizi(nilaiGiziBasal, nilaiGiziTotal)
    }

    private fun displaygizi(nilaiGiziBasal: Double, nilaiGiziTotal: Double) {
        val formatBasal = NumberFormat.getInstance().format(nilaiGiziBasal)
        binding.hasilgizi.text = getString(R.string.nilai_basal, formatBasal)

        val formatTotal = NumberFormat.getInstance().format(nilaiGiziTotal)
        binding.totalgizi.text = getString(R.string.nilai_total, formatTotal)

    }
}


//binding.hasilgizi.text = nilaiGiziBasal.toString()
//binding.totalgizi.text = nilaiGiziTotal.toString()


//    private fun tampilanNilai(nilaiGiziBasal: Double, nilaiGiziTotal: Double) {
//        binding.hasilgizi.text.toString() = getString(R.string.nilai_basal)
//        binding.totalgizi.text.toString() = getString(R.string.nilai_total)
//    }
