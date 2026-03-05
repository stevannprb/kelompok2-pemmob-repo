package com.upn.catatlarii

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.upn.fitrun.R

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil) // sesuai nama file kamu

        val btnEdit = findViewById<Button>(R.id.btnEdit)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnEdit.setOnClickListener {
            Toast.makeText(this, "Edit Profile Clicked", Toast.LENGTH_SHORT).show()
        }

        btnLogout.setOnClickListener {
            Toast.makeText(this, "Logout Berhasil", Toast.LENGTH_SHORT).show()

            // Kalau belum ada LoginActivity, hapus Intent ini dulu
            // val intent = Intent(this, LoginActivity::class.java)
            // startActivity(intent)

            finish()
        }
    }
}