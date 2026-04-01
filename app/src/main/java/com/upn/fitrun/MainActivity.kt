package com.upn.fitrun

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setupWithNavController(navController)

        // LOGIKA UNTUK MENGHILANGKAN BOTTOM NAV
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                // Menu bawah akan HILANG di halaman-halaman ini:
                R.id.splashFragment,
                R.id.registFragment -> {
                    bottomNav.visibility = View.GONE
                }
                // Menu bawah akan MUNCUL di halaman lainnya:
                else -> {
                    bottomNav.visibility = View.VISIBLE
                }
            }
        }
    }
}