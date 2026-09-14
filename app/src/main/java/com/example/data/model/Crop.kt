package com.example.data.model

data class FertilizerItem(
    val name: String,
    val amountPerBigha: String,
    val applicationTime: String
)

data class TimelinePhase(
    val phaseNumber: Int,
    val title: String,
    val daysRange: String,
    val operations: List<String>,
    val tips: String
)

data class CropDisease(
    val name: String,
    val type: String, // রোগ বা পোকা
    val symptoms: String,
    val prevention: String,
    val remedy: String
)

data class Crop(
    val id: String,
    val nameBn: String,
    val scientificName: String,
    val category: String,
    val season: String,
    val durationDays: String,
    val yieldPerBigha: String,
    val suitableSoil: String,
    val seedRate: String,
    val seedTreatment: String,
    val landPreparation: String,
    val sowingOrPlanting: String,
    val fertilizerList: List<FertilizerItem>,
    val irrigationPlan: String,
    val weedingCare: String,
    val timeline: List<TimelinePhase>,
    val diseases: List<CropDisease>,
    val harvestingAndStorage: String,
    val keyTips: List<String>
)
