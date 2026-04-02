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
            val nama = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val rePassword = binding.etRePassword.text.toString().trim()

            if (nama.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                Toast.makeText(context, "Harap isi semua bidang!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != rePassword) {
                binding.etRePassword.error = "Password tidak cocok!"
                Toast.makeText(context, "Password tidak sama!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val userBaru = User(
                nama = nama,
                email = email,
                password = password
            )

            Log.d("RegistFragment", "User baru: $userBaru")
            Toast.makeText(context, "Pendaftaran Berhasil, ${userBaru.nama}!", Toast.LENGTH_SHORT).show()

            // Perbaikan ID Action
            findNavController().navigate(R.id.action_registFragment_to_berandaFragment)
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