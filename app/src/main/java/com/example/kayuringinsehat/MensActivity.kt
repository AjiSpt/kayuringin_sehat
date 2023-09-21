//package com.example.kayuringinsehat
//
//import android.app.DatePickerDialog
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.ArrayAdapter
//import android.widget.EditText
//import com.example.kayuringinsehat.databinding.ActivityMensBinding
//import java.time.LocalDate
//import java.util.Calendar
//
//class MensActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMensBinding
//    lateinit var dateEdt: EditText
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMensBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val number = (28..45).map { it.toString() }.toTypedArray()
//        val adapter = ArrayAdapter(this, R.layout.list_mens, number)
//        binding.atDropDown.setAdapter(adapter)
//
//        dateEdt = findViewById(R.id.hari_pertama)
//
//        dateEdt.setOnClickListener {
//            val c = Calendar.getInstance()
//            val year = c.get(Calendar.YEAR)
//            val month = c.get(Calendar.MONTH)
//            val day = c.get(Calendar.DAY_OF_MONTH)
//            val datePickerDialog = DatePickerDialog(
//                this,
//                { view, selectedYear, monthOfYear, dayOfMonth ->
//                    val dateStr = String.format("%02d-%02d-%d", dayOfMonth, monthOfYear + 1, selectedYear)
//                    dateEdt.setText(dateStr)
//                }, year, month, day
//            )
//            datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
//            datePickerDialog.show()
//        }
//    }
//    fun hitungHaid(siklusHaid: Int, tanggalHariPertamaHaid: LocalDate): String {
//        if (siklusHaid < 21 || siklusHaid > 35){
//
//        }
//
//        val lamaHaid = 5
//        val akhirHaid = tanggalHariPertamaHaid.plusDays((lamaHaid - 1).toLong())
//
//        val awalMasaSubur = tanggalHariPertamaHaid.plusDays(10)
//        val akhirMasaSubur = tanggalHariPertamaHaid.plusDays(17)
//
//        val hariOvulasi = tanggalHariPertamaHaid.plusDays((siklusHaid - 14).toLong())
//
//        val awalSiklusSelanjutnya = tanggalHariPertamaHaid.plusDays(siklusHaid.toLong())
//
//}