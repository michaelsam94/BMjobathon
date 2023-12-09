package com.example.bmjobathon.data.remote.dto

data class RatesResponse(
    val base: String,
    val date: String,
    val rates: Rate,
    val success: Boolean,
    val timestamp: Int
)