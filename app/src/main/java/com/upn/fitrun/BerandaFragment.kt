package com.upn.fitrun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upn.fitrun.databinding.FragmentMasukBinding

class BerandaFragment : Fragment() {

    private var _binding: FragmentMasukBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMasukBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener(
            "run_result",
            viewLifecycleOwner
        ) { _, bundle ->

            val aktivitas = bundle.getParcelable<RunActivity>("run_data")

            aktivitas?.let {
                binding.tvRiwayat.text =
                    "Tanggal: ${it.tanggal}\n" +
                            "Jarak: ${it.jarak} km\n" +
                            "Durasi: ${it.durasi} menit"
            }
        }

        binding.btnStartRun.setOnClickListener {
            findNavController().navigate(R.id.action_berandaFragment_to_add_run_Fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}