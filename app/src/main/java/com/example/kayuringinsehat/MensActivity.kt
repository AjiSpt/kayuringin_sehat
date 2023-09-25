package com.example.kayuringinsehat

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.kayuringinsehat.databinding.ActivityMensBinding
import java.time.LocalDate
import java.util.Calendar

class MensActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMensBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMensBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val number = (28..45).map { it.toString() }.toTypedArray()
        val adapter = ArrayAdapter(this, R.layout.list_mens, number)
        binding.atDropDown.setAdapter(adapter)

        binding.hariPertama.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { view, selectedYear, monthOfYear, dayOfMonth ->
                    val dateStr =
                        String.format("%02d-%02d-%d", dayOfMonth, monthOfYear + 1, selectedYear)
                    binding.hariPertama.setText(dateStr)
                }, year, month, day
            )
            datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
            datePickerDialog.show()
        }
//        binding.btnHitungMens.setOnClickListener {
//            val tglHariAwalHaid = binding.hariPertama.text.toString()
//            val siklusHaid = binding.atDropDown.text.toString()
//
//            if (tglHariAwalHaid != null && siklusHaid.isNotEmpty()){
//                val localDate = LocalDate.parse(tglHariAwalHaid)
//                val hasil = hitungHaid()
//            }
//        }
    }
}
//
//fun hitungHaid(siklusHaid: Int, tglHariAwalHaid: LocalDate): String{
//    if (siklusHaid < 21 || siklusHaid > 35) {
//
//    }