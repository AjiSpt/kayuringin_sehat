package com.example.kayuringinsehat

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import java.util.Calendar

class MensActivity : AppCompatActivity() {

    // on below line creating a variable
    lateinit var dateEdt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mens)

        // on beloew line we are initializing our variables.
        dateEdt = findViewById(R.id.hari_pertama)

        // on below line we are adding
        // click listener for our edit text
        dateEdt.setOnClickListener {

            // on below line we are getting
            // the instance of our calendar.
            val c = Calendar.getInstance()

            // on below line we are getting
            // our dar, month and year.
            val year = c.get(Calendar.YEAR)
            val mount = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            // on below line we are creating a
            // variable for date picker dialog.
            val datePickerDialog = DatePickerDialog(
                // on below line we are passing context.
                this,
                { view, year, monthOfYear, dayOfMount ->
                    // on below line we are setting
                    // date to our edit text.
                    val dat = (dayOfMount.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    dateEdt.setText(dat)
                },
                // on below line we are passing year, month
                // and for the selected date in our date picker.
                year,
                mount,
                day
            )
            // at last we are calling show
            // to display our date picker dioalog
            datePickerDialog.show()
        }

    }
}