package com.example.weatherapp.api


import android.graphics.drawable.Icon
import coil3.compose.AsyncImagePainter
import com.google.gson.annotations.SerializedName


    data class Condition(
        @SerializedName("code")
        val code: Int,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("text")
        val text: String
    )
