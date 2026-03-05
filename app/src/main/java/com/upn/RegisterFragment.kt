package com.upn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.upn.fitrun.R

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menghubungkan file Kotlin ini dengan desain XML fragment_register
        return inflater.inflate(R.layout.fragment_register, container, false)
    }
}