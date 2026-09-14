package com.example.data.model

data class District(
    val id: Int,
    val serialNo: Int,
    val nameBn: String,
    val nameEn: String,
    val division: String,
    val soilType: String,
    val features: String,
    val cropIds: List<String>
)
