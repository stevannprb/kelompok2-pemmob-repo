package com.upn.fitrun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
// Perhatikan baris import di bawah ini, sesuaikan dengan nama class binding yang muncul
import com.upn.fitrun.databinding.FragmentMasukBinding

private val FragmentMasukBinding.btnStart: Any

class BerandaFragment : Fragment() {

    // Jika layoutmu namanya fragment_masuk, maka ganti jadi FragmentMasukBinding
    private var _binding: FragmentMasukBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Ganti FragmentBerandaBinding menjadi FragmentMasukBinding
        _binding = FragmentMasukBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Pastikan di dalam fragment_masuk.xml ada view dengan android:id="@+id/btnStart"
        binding.btnStart.setOnClickListener {
            // Gunakan ID action yang tepat dari nav_menu.xml
            findNavController().navigate(R.id.action_registFragment_to_berandaFragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun Any.setOnClickListener(function: Any) {}
