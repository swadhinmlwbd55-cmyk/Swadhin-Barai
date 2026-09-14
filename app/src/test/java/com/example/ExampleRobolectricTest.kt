package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.repository.AgriRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("কৃষি বৃত্তান্ত", appName)
  }

  @Test
  fun `verify all 64 districts exist with details`() {
    val districts = AgriRepository.getAllDistricts()
    assertEquals(64, districts.size)

    // Check first and last serial
    assertEquals(1, districts.first().serialNo)
    assertEquals(64, districts.last().serialNo)

    // Check divisions
    val divisions = AgriRepository.getDivisions()
    assertTrue(divisions.contains("ঢাকা"))
    assertTrue(divisions.contains("চট্টগ্রাম"))
    assertTrue(divisions.contains("রাজশাহী"))
    assertTrue(divisions.contains("রংপুর"))
  }

  @Test
  fun `verify major crops have complete timelines and disease controls`() {
    val crops = AgriRepository.getAllCrops()
    assertTrue(crops.size >= 10)

    val boroRice = AgriRepository.getCropById("dhan_boro")
    assertNotNull(boroRice)
    assertTrue(boroRice!!.timeline.isNotEmpty())
    assertTrue(boroRice.fertilizerList.isNotEmpty())
    assertTrue(boroRice.diseases.isNotEmpty())
  }
}
