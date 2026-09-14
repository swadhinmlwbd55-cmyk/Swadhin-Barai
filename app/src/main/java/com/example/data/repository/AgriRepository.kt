package com.example.data.repository

import com.example.data.model.Crop
import com.example.data.model.District

object AgriRepository {
    fun getAllDistricts(): List<District> = DistrictData.districts

    fun getDistrictById(id: Int): District? = DistrictData.districts.find { it.id == id }

    fun getDistrictBySerial(serialNo: Int): District? = DistrictData.districts.find { it.serialNo == serialNo }

    fun getDivisions(): List<String> = DistrictData.divisions

    fun filterDistricts(division: String, query: String = ""): List<District> {
        val trimmed = query.trim().lowercase()
        return DistrictData.districts.filter { district ->
            val matchesDivision = (division == "সকল" || district.division == division)
            val matchesQuery = if (trimmed.isEmpty()) {
                true
            } else {
                district.nameBn.lowercase().contains(trimmed) ||
                district.nameEn.lowercase().contains(trimmed) ||
                district.soilType.lowercase().contains(trimmed) ||
                district.features.lowercase().contains(trimmed) ||
                getCropsForDistrict(district).any { it.nameBn.lowercase().contains(trimmed) }
            }
            matchesDivision && matchesQuery
        }
    }

    fun getAllCrops(): List<Crop> = CropData.crops

    fun getCropById(id: String): Crop? = CropData.getCropById(id)

    fun getCropsForDistrict(district: District): List<Crop> {
        return CropData.getCropsForDistrict(district.cropIds)
    }

    fun searchCrops(query: String): List<Crop> {
        val trimmed = query.trim().lowercase()
        if (trimmed.isEmpty()) return CropData.crops
        return CropData.crops.filter {
            it.nameBn.lowercase().contains(trimmed) ||
            it.scientificName.lowercase().contains(trimmed) ||
            it.category.lowercase().contains(trimmed) ||
            it.season.lowercase().contains(trimmed)
        }
    }
}
