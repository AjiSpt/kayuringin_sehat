package com.example.kayuringinsehat

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.kayuringinsehat.databinding.ActivityMensBinding
import java.io.Serializable
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.time.Year
import java.util.Calendar
import java.util.Date

class MensActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMensBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMensBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val number = (21..35).map { it.toString() }.toTypedArray()
        val adapter = ArrayAdapter(this, R.layout.list_mens, number)
        binding.siklus.setAdapter(adapter)

        binding.hariPertama.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { view,
                  selectedYear,
                  monthOfYear,
                  dayOfMonth ->
                    val dateStr =
                        String.format("%02d-%02d-%d", dayOfMonth, monthOfYear + 1, selectedYear)
                    binding.hariPertama.setText(dateStr)
                }, year, month, day
            )
            datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
            datePickerDialog.show()
        }

        binding.btnHitungMens.setOnClickListener {
            hitungMens()
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun hitungMens() {
        // Ambil data dari textInput hariPertama lalu konversi jadi string
        val inputHariPertama = binding.hariPertama.text.toString()
        // Ambil 2 karakter pertama dari data lalu konversi jadi integer
        val hariPertamaMens = inputHariPertama.take(2).toIntOrNull()
        if (hariPertamaMens == null || hariPertamaMens == 0) {
            Toast.makeText(this, "Hari Pertama Menstruasi Tidak Boleh Kosong", Toast.LENGTH_SHORT)
                .show()
            return
        }

        val siklusMens = binding.siklus.text.toString().toIntOrNull()
        if (siklusMens == null) {
            Toast.makeText(this, "Siklus Menstruasi Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            return
        }

        val kalender = Calendar.getInstance()
        kalender.set(Calendar.DAY_OF_MONTH, hariPertamaMens)
        val hariPertamaMensDate = kalender.time

        // Perkiraan Masa Subur (H+10 hingga H+17)
        kalender.time = hariPertamaMensDate
        kalender.add(Calendar.DAY_OF_MONTH, 10)
        val perkiraanMasaSuburAwal = kalender.time
        kalender.add(Calendar.DAY_OF_MONTH, 7)
        val perkiraanMasaSuburAkhir = kalender.time

        val masaSuburAwal = perkiraanMasaSuburAwal.toString().substring(9, 10).toIntOrNull()
        if (masaSuburAwal == null || masaSuburAwal == 0) {
            return
        }
        val masaSuburAkhir = perkiraanMasaSuburAkhir.toString().substring(9, 10).toIntOrNull()
        if (masaSuburAkhir == null || masaSuburAkhir == 0) {
            return
        }
        val selisih = (masaSuburAkhir - masaSuburAwal) / 2

        kalender.time = perkiraanMasaSuburAwal
        kalender.add(Calendar.DAY_OF_MONTH, selisih)
        val perkiraanOvulasi = kalender.time

        // Perkiraan Menstruasi Berikutnya (H+ Siklus)
        kalender.time = hariPertamaMensDate
        kalender.add(Calendar.DAY_OF_MONTH, siklusMens)
        val perkiraanMenstruasiBerikutnya = kalender.time

        // Format tanggal
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")

        binding.masaSubur.text =
            "Perkiraan Masa Subur:\n${dateFormat.format(perkiraanMasaSuburAwal)}  s/d  ${dateFormat.format(perkiraanMasaSuburAkhir)}"
        binding.masaOvulasi.text = "Perkiraan Ovulasi:\n${dateFormat.format(perkiraanOvulasi)}"
        binding.masaSiklus.text =
            "Perkiraan Menstruasi Berikutnya:\n${dateFormat.format(perkiraanMenstruasiBerikutnya)}"

    }
}


