package com.upn.fitrun

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cukup panggil ini saja
        setContentView(R.layout.activity_auth)

        // Sembunyikan ActionBar biar keren/full screen
        supportActionBar?.hide()
    }
}