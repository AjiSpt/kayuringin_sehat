package com.example.kayuringinsehat

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ArrayAdapter
import com.example.kayuringinsehat.databinding.ActivityMensBinding
import java.time.LocalDate
import java.util.Calendar

class MensActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMensBinding

    @SuppressLint("ClickableViewAccessibility")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMensBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: untuk tombol back
        binding.cardviewKembaliMens.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Menampilkan efek sentuhan saat ditekan
                    binding.cardviewKembaliMens.animate().scaleX(0.9f).scaleY(0.9f).start()
                }

                MotionEvent.ACTION_UP -> {
                    // Mengembalikan ukuran cardview ke semula
                    binding.cardviewKembaliMens.animate().scaleX(1f).scaleY(1f).start()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
            true
        }

        val number = (28..45).map { it.toString() }.toTypedArray()
        val adapter = ArrayAdapter(this, R.layout.list_mens, number)
        binding.atDropDown.setAdapter(adapter)

        binding.hariPertama.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this, { view, selectedYear, monthOfYear, dayOfMonth ->
                    val dateStr =
                        String.format("%02d-%02d-%d", dayOfMonth, monthOfYear + 1, selectedYear)
                    binding.hariPertama.setText(dateStr)
                }, year, month, day
            )
            datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
            datePickerDialog.show()
        }
        binding.btnHitungMens.setOnClickListener {
            val tglHariAwalHaid = binding.hariPertama.text.toString()
            val siklusHaid = binding.atDropDown.text.toString()

            if (tglHariAwalHaid != null && siklusHaid.isNotEmpty()) {
                //val localDate = LocalDate.parse(tglHariAwalHaid)
                //val hasil = hitungHaid()
            }
        }
    }
}

//fun hitungHaid(siklusHaid: Int, tglHariAwalHaid: LocalDate): String {
//    if (siklusHaid < 21 || siklusHaid > 35) {
//
//    }
//}