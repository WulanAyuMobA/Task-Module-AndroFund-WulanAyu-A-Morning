package com.example.latihan.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val id:Int,
    val name:String,
    val gambar:String,
    val harga:String
):Parcelable
