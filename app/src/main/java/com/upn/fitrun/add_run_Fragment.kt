package com.upn.fitrun

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.upn.fitrun.databinding.FragmentAddRunBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class add_run_Fragment : Fragment() {

    private var _binding: FragmentAddRunBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddRunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etTanggal.setOnClickListener {
            showDatePicker()
        }

        binding.btnSave.setOnClickListener {
            simpanAktivitas()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                calendar.set(year, month, dayOfMonth)

                val formatTanggal = SimpleDateFormat(
                    "dd MMMM yyyy",
                    Locale("id", "ID")
                )

                binding.etTanggal.setText(
                    formatTanggal.format(calendar.time)
                )
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.show()
    }

    private fun simpanAktivitas() {
        val tanggal = binding.etTanggal.text.toString().trim()
        val jarak = binding.etJarak.text.toString().trim()
        val durasi = binding.etDurasi.text.toString().trim()

        if (tanggal.isEmpty() || jarak.isEmpty() || durasi.isEmpty()) {
            if (tanggal.isEmpty()) binding.etTanggal.error = "Tanggal harus diisi"
            if (jarak.isEmpty()) binding.etJarak.error = "Jarak harus diisi"
            if (durasi.isEmpty()) binding.etDurasi.error = "Durasi harus diisi"
            return
        }

        val aktivitas = RunActivity(
            tanggal = tanggal,
            jarak = jarak.toDouble(),
            durasi = durasi.toInt()
        )

        parentFragmentManager.setFragmentResult(
            "run_result",
            Bundle().apply {
                putParcelable("run_data", aktivitas)
            }
        )

        parentFragmentManager.popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}