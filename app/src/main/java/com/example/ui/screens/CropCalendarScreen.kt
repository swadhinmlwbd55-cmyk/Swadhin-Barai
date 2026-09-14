package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.repository.AgriRepository
import com.example.ui.components.AppTopBar
import com.example.ui.theme.*

data class SeasonInfo(
    val titleBn: String,
    val banglaMonths: String,
    val englishMonths: String,
    val characteristics: String,
    val majorCrops: List<String>
)

@Composable
fun CropCalendarScreen(
    onCropSelected: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    val seasons = listOf(
        SeasonInfo(
            titleBn = "রবি মৌসুম (শীতকালীন ফসল)",
            banglaMonths = "কার্তিক - চৈত্র",
            englishMonths = "অক্টোবর - মার্চ",
            characteristics = "শীতল ও শুষ্ক আবহাওয়া, স্বল্প বৃষ্টিপাত, কুয়াশা ও কম আর্দ্রতা। সেচের ওপর নির্ভরশীল।",
            majorCrops = listOf("বোরো ধান", "গোল আলু", "গম", "ভুট্টা", "সরিষা", "পেঁয়াজ ও রসুন", "মসুর ও মুগ ডাল", "তরমুজ", "শাকসবজি (টমেটো, কপি)")
        ),
        SeasonInfo(
            titleBn = "খরিপ-১ মৌসুম (গ্রীষ্মকালীন ফসল)",
            banglaMonths = "ফাল্গুন - জ্যৈষ্ঠ",
            englishMonths = "মার্চ - জুন",
            characteristics = "উচ্চ তাপমাত্রা, মাঝে মাঝে কালবৈশাখী ঝড় ও শিলাবৃষ্টি, মাঝারি আর্দ্রতা।",
            majorCrops = listOf("পাট (তোষা ও দেশী)", "আউশ ধান", "গ্রীষ্মকালীন ভুট্টা", "গ্রীষ্মকালীন সবজি", "তিল ও চীনাবাদাম", "আম ও লিচু পরিপক্কতা")
        ),
        SeasonInfo(
            titleBn = "খরিপ-২ মৌসুম (বর্ষাকালীন ফসল)",
            banglaMonths = "আষাঢ় - কার্তিক",
            englishMonths = "জুলাই - অক্টোবর",
            characteristics = "প্রচুর বৃষ্টিপাত, উচ্চ আর্দ্রতা, মেঘলা আকাশ ও নদীর পানি বৃদ্ধি। মূলত বৃষ্টি নির্ভর।",
            majorCrops = listOf("রোপা আমন ধান", "তুলা", "বর্ষাকালীন শাকসবজি", "কলা ও পেঁপে", "আখ পরিচর্যা")
        )
    )

    Scaffold(
        topBar = {
            AppTopBar(
                title = "কৃষি ক্যালেন্ডার",
                subtitle = "মৌসুমভিত্তিক ফসল রোপণ ও তোলার সময়সূচি",
                canNavigateBack = true,
                onNavigateBack = onNavigateBack
            )
        },
        containerColor = AgriScaffoldBg
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = AgriGoldContainer),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = null,
                            tint = AgriEarthBrown,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "বাংলাদেশের তিনটি প্রধান কৃষি মৌসুম",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = AgriEarthBrown
                                )
                            )
                            Text(
                                text = "বাংলাদেশের কৃষি মূলত আবহাওয়া ও জলবায়ু ভিত্তিক তিনটি স্বতন্ত্র মৌসুমে আবর্তিত হয়।",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    color = AgriDarkText,
                                    fontSize = 12.sp
                                )
                            )
                        }
                    }
                }
            }

            items(seasons) { season ->
                SeasonCard(season = season)
                Spacer(modifier = Modifier.height(14.dp))
            }
        }
    }
}

@Composable
fun SeasonCard(season: SeasonInfo) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = season.titleBn,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = AgriGreenDark,
                        fontSize = 16.sp
                    )
                )
                Surface(
                    color = AgriGreenContainer,
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = season.banglaMonths,
                        color = AgriGreenDark,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "ইংরেজি মাস: ${season.englishMonths}",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = AgriMutedText,
                    fontWeight = FontWeight.Medium
                )
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = season.characteristics,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = AgriDarkText,
                    fontSize = 13.5.sp,
                    lineHeight = 19.sp
                )
            )

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(color = AgriCardBorder.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "এই মৌসুমের প্রধান ফসলসমূহ:",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = AgriDarkText
                )
            )
            Spacer(modifier = Modifier.height(6.dp))

            // Badges
            Row(modifier = Modifier.fillMaxWidth()) {
                Column {
                    season.majorCrops.chunked(3).forEach { rowCrops ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 2.dp),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            rowCrops.forEach { cropName ->
                                Surface(
                                    color = AgriGreenSurface,
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Text(
                                        text = cropName,
                                        style = MaterialTheme.typography.bodySmall.copy(
                                            color = AgriGreenDark,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Medium
                                        ),
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
