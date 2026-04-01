package com.upn.fitrun

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val nama: String,
    val email: String,
    val password: String
) : Parcelable