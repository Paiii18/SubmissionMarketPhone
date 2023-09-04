package com.example.submissionakhiraplikasipemula

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HP(
    val name: String,
    val description: String,
    val photo: Int,
    val price: String
): Parcelable
