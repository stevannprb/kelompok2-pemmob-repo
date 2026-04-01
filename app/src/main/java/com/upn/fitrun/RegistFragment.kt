package com.upn.fitrun

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.upn.fitrun.databinding.FragmentRegistBinding

// 1. Definisikan Data Class di sini (atau di file terpisah User.kt)


class RegistFragment : Fragment() {

    private var _binding: FragmentRegistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStart.setOnClickListener {
            // Mengambil input dan menghapus spasi di awal/akhir dengan .trim()
            val nama = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Misalkan ID di XML kamu untuk re-type password adalah etRePassword
            // Jika ID-nya beda, sesuaikan di bawah ini ya!
            val rePassword = binding.etRePassword.text.toString().trim()

            // 2. Validasi apakah ada field yang kosong
            if (nama.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                Toast.makeText(context, "Harap isi semua bidang!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 3. Validasi Kecocokan Password
            if (password != rePassword) {
                binding.etRePassword.error = "Password tidak cocok!"
                Toast.makeText(context, "Password tidak sama!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 4. TAMPUNG KE DATA CLASS (Hanya Nama, Email, Password)
            val userBaru = User(
                nama = nama,
                email = email,
                password = password
            )

            // Log untuk memastikan data sudah masuk ke objek
            Log.d("RegistFragment", "User baru: $userBaru")

            // Simpan atau proses data userBaru di sini jika diperlukan
            Toast.makeText(context, "Pendaftaran Berhasil, ${userBaru.nama}!", Toast.LENGTH_SHORT).show()

            // 5. Pindah ke Beranda
            findNavController().navigate(R.id.action_registFragment_to_berandaFragment2)
        }

        binding.tvLoginHere.setOnClickListener {
            findNavController().navigate(R.id.action_registFragment_to_masukFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}