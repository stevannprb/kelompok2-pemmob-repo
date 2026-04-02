package com.upn.fitrun

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RunActivity(
    val tanggal: String,
    val jarak: Double,
    val durasi: Int
) : Parcelable