package com.upn.fitrun

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import java.util.Locale

class AddRunActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_run)

        val etTanggal = findViewById<EditText>(R.id.etTanggal)
        val etWaktu = findViewById<EditText>(R.id.etWaktu)
        val etDurasi = findViewById<EditText>(R.id.etDurasi)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val calendar = Calendar.getInstance()

        // DATE PICKER
        etTanggal.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->

                    val formattedMonth = selectedMonth + 1

                    etTanggal.setText(
                        getString(
                            R.string.formatted_date,
                            selectedDay,
                            formattedMonth,
                            selectedYear
                        )
                    )
                },
                year,
                month,
                day
            )

            datePicker.show()
        }

        // TIME PICKER
        etWaktu.setOnClickListener {
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(
                this,
                { _, selectedHour, selectedMinute ->

                    etWaktu.setText(
                        getString(
                            R.string.formatted_time,
                            selectedHour,
                            selectedMinute
                        )
                    )
                },
                hour,
                minute,
                true
            )

            timePicker.show()
        }

        // SAVE BUTTON
        btnSave.setOnClickListener {

            val tanggal = etTanggal.text.toString()
            val waktu = etWaktu.text.toString()
            val durasi = etDurasi.text.toString()

            if (tanggal.isBlank() || waktu.isBlank() || durasi.isBlank()) {
                Toast.makeText(
                    this,
                    getString(R.string.error_empty),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.success_save),
                    Toast.LENGTH_SHORT
                ).show()

                // TODO: simpan ke database / pindah activity
            }
        }
    }
}