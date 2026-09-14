package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Landscape
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Crop
import com.example.data.model.District
import com.example.data.repository.AgriRepository
import com.example.ui.components.AppTopBar
import com.example.ui.theme.*

@Composable
fun DistrictDetailScreen(
    districtId: Int,
    onCropClick: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    val district = AgriRepository.getDistrictById(districtId)

    Scaffold(
        topBar = {
            AppTopBar(
                title = if (district != null) "${district.nameBn} জেলা" else "জেলা বৃত্তান্ত",
                subtitle = if (district != null) "${district.division} বিভাগ • ক্রমিক নং: ${district.serialNo}" else null,
                canNavigateBack = true,
                onNavigateBack = onNavigateBack
            )
        },
        containerColor = AgriScaffoldBg
    ) { innerPadding ->
        if (district == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "জেলা খুঁজে পাওয়া যায়নি", color = AgriMutedText)
            }
        } else {
            val crops = AgriRepository.getCropsForDistrict(district)

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                // District Info Card
                item {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .size(42.dp)
                                            .clip(CircleShape)
                                            .background(AgriGreenPrimary),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "${district.serialNo}",
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 16.sp
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Column {
                                        Text(
                                            text = district.nameBn,
                                            style = MaterialTheme.typography.titleLarge.copy(
                                                fontWeight = FontWeight.Bold,
                                                color = AgriDarkText
                                            )
                                        )
                                        Text(
                                            text = "${district.nameEn} District",
                                            style = MaterialTheme.typography.bodySmall.copy(
                                                color = AgriMutedText
                                            )
                                        )
                                    }
                                }

                                Surface(
                                    color = AgriGreenContainer,
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Text(
                                        text = "${district.division} বিভাগ",
                                        color = AgriGreenDark,
                                        style = MaterialTheme.typography.labelMedium.copy(
                                            fontWeight = FontWeight.Bold
                                        ),
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(14.dp))
                            HorizontalDivider(color = AgriCardBorder.copy(alpha = 0.5f))
                            Spacer(modifier = Modifier.height(12.dp))

                            // Soil Type
                            Row(verticalAlignment = Alignment.Top) {
                                Icon(
                                    imageVector = Icons.Default.Landscape,
                                    contentDescription = null,
                                    tint = AgriEarthBrown,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = "মাটির প্রকৃতি ও বৈশিষ্ট্য:",
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            fontWeight = FontWeight.Bold,
                                            color = AgriEarthBrown
                                        )
                                    )
                                    Text(
                                        text = district.soilType,
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            color = AgriDarkText,
                                            fontSize = 13.5.sp
                                        )
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            // Agri Features
                            Row(verticalAlignment = Alignment.Top) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = AgriGoldHarvest,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = "কৃষি বিশেষত্ব ও ঐতিহ্য:",
                                        style = MaterialTheme.typography.labelSmall.copy(
                                            fontWeight = FontWeight.Bold,
                                            color = AgriEarthBrown
                                        )
                                    )
                                    Text(
                                        text = district.features,
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            color = AgriDarkText,
                                            fontSize = 13.5.sp
                                        )
                                    )
                                }
                            }
                        }
                    }
                }

                // Header for crops in this district
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Eco,
                            contentDescription = null,
                            tint = AgriGreenPrimary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "${district.nameBn} জেলায় চাষকৃত প্রধান ফসলসমূহ (${crops.size}টি)",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = AgriGreenDark,
                                fontSize = 16.sp
                            )
                        )
                    }
                }

                // Crop Cards
                items(crops) { crop ->
                    DistrictCropCard(crop = crop, onClick = { onCropClick(crop.id) })
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Composable
fun DistrictCropCard(crop: Crop, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(AgriGreenContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Eco,
                    contentDescription = null,
                    tint = AgriGreenPrimary,
                    modifier = Modifier.size(26.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = crop.nameBn,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = AgriDarkText,
                            fontSize = 16.sp
                        )
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Surface(
                        color = AgriGoldContainer,
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = crop.category,
                            color = AgriEarthBrown,
                            style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "মৌসুম: ${crop.season.split('(').first().trim()}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = AgriMutedText,
                        fontSize = 12.sp
                    )
                )
                Text(
                    text = "গড় ফলন: ${crop.yieldPerBigha} • সময়কাল: ${crop.durationDays}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = AgriGreenDark,
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "বিস্তারিত দেখুন",
                tint = AgriGreenPrimary,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
