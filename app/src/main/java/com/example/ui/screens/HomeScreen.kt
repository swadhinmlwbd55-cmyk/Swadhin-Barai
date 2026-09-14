package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.model.District
import com.example.data.repository.AgriRepository
import com.example.ui.components.AppTopBar
import com.example.ui.theme.*

@Composable
fun HomeScreen(
    onDistrictClick: (Int) -> Unit,
    onNavigateToCalculator: () -> Unit,
    onNavigateToCalendar: () -> Unit,
    onNavigateToAllCrops: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedDivision by remember { mutableStateOf("সকল") }

    val divisions = AgriRepository.getDivisions()
    val filteredDistricts = remember(selectedDivision, searchQuery) {
        AgriRepository.filterDistricts(selectedDivision, searchQuery)
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "কৃষি বৃত্তান্ত",
                subtitle = "৬৪ জেলার ফসলভিত্তিক চাষাবাদ সহায়িকা",
                actions = {
                    IconButton(onClick = onNavigateToCalculator) {
                        Icon(
                            imageVector = Icons.Default.Calculate,
                            contentDescription = "সার ক্যালকুলেটর",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = onNavigateToCalendar) {
                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = "কৃষি ক্যালেন্ডার",
                            tint = Color.White
                        )
                    }
                }
            )
        },
        containerColor = AgriScaffoldBg
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Hero Visual Banner
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_agri_hero),
                        contentDescription = "বাংলাদেশের কৃষি ঐতিহ্য",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    // Gradient overlay
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        AgriGreenDark.copy(alpha = 0.85f)
                                    )
                                )
                            )
                    )

                    // Overlay text & quick badge
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Surface(
                            color = AgriGoldHarvest,
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "৬৪ জেলা • ৮ বিভাগ • পূর্ণাঙ্গ তথ্যকোষ",
                                color = AgriDarkText,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.sp
                                ),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "বাংলাদেশের জেলাভিত্তিক ফসল ও চাষাবাদ",
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 17.sp
                            )
                        )
                    }
                }
            }

            // Quick Shortcut Buttons Row
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    QuickActionButton(
                        icon = Icons.Default.Calculate,
                        title = "সার হিসাব",
                        onClick = onNavigateToCalculator,
                        modifier = Modifier.weight(1f)
                    )
                    QuickActionButton(
                        icon = Icons.Default.CalendarMonth,
                        title = "মৌসুম সূচি",
                        onClick = onNavigateToCalendar,
                        modifier = Modifier.weight(1f)
                    )
                    QuickActionButton(
                        icon = Icons.Default.Eco,
                        title = "সকল ফসল",
                        onClick = onNavigateToAllCrops,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // Search Bar
            item {
                PaddingValues(horizontal = 16.dp).let {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        placeholder = { Text("জেলা বা ফসলের নাম লিখুন (যেমন: বগুড়া, আম, ধান)...") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = AgriGreenPrimary)
                        },
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                IconButton(onClick = { searchQuery = "" }) {
                                    Icon(imageVector = Icons.Default.Clear, contentDescription = "পরিষ্কার করুন")
                                }
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = AgriGreenPrimary,
                            unfocusedBorderColor = AgriCardBorder,
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        singleLine = true
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            // Division Filter Horizontal Scroll
            item {
                val scrollState = rememberScrollState()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(scrollState)
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    divisions.forEach { div ->
                        val isSelected = selectedDivision == div
                        FilterChip(
                            selected = isSelected,
                            onClick = { selectedDivision = div },
                            label = {
                                Text(
                                    text = div,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) Color.White else AgriDarkText
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = AgriGreenPrimary,
                                containerColor = Color.White
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = true,
                                selected = isSelected,
                                borderColor = if (isSelected) AgriGreenPrimary else AgriCardBorder
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
            }

            // Section count label
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "ক্রমিক অনুযায়ী জেলা তালিকা (${filteredDistricts.size}টি জেলা)",
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = AgriDarkText
                        )
                    )

                    if (selectedDivision != "সকল") {
                        Text(
                            text = "$selectedDivision বিভাগ",
                            style = MaterialTheme.typography.labelSmall.copy(
                                color = AgriGreenPrimary,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }

            // Empty state if no district found
            if (filteredDistricts.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.SearchOff,
                                contentDescription = null,
                                tint = AgriMutedText,
                                modifier = Modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "কোনো জেলা বা ফসল পাওয়া যায়নি",
                                style = MaterialTheme.typography.bodyMedium.copy(color = AgriMutedText)
                            )
                        }
                    }
                }
            } else {
                // District items in serial order
                items(filteredDistricts, key = { it.id }) { district ->
                    DistrictListItem(
                        district = district,
                        onClick = { onDistrictClick(district.id) },
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp)
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun QuickActionButton(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        color = Color.White,
        shape = RoundedCornerShape(10.dp),
        border = CardDefaults.outlinedCardBorder(),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = AgriGreenPrimary,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = AgriDarkText,
                    fontSize = 12.5.sp
                )
            )
        }
    }
}

@Composable
fun DistrictListItem(
    district: District,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Serial circle badge
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(AgriGreenContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = String.format("%02d", district.serialNo),
                    color = AgriGreenDark,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = district.nameBn,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = AgriDarkText,
                            fontSize = 16.sp
                        )
                    )
                    Surface(
                        color = AgriGreenSurface,
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = "${district.division} বিভাগ",
                            color = AgriGreenPrimary,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 10.5.sp
                            ),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = district.features,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = AgriMutedText,
                        fontSize = 12.sp
                    ),
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Crops badges for this district
                val crops = AgriRepository.getCropsForDistrict(district)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    crops.take(3).forEach { crop ->
                        Surface(
                            color = AgriGoldContainer,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = crop.nameBn,
                                color = AgriEarthBrown,
                                style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                            )
                        }
                    }
                    if (crops.size > 3) {
                        Surface(
                            color = AgriGreenSurface,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = "+${crops.size - 3}টি",
                                color = AgriGreenDark,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp
                                ),
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = AgriGreenLight,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}
