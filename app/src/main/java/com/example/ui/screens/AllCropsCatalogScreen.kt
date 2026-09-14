package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Crop
import com.example.data.repository.AgriRepository
import com.example.ui.components.AppTopBar
import com.example.ui.theme.*

@Composable
fun AllCropsCatalogScreen(
    onCropClick: (String) -> Unit,
    onNavigateBack: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("সকল") }

    val allCrops = AgriRepository.getAllCrops()
    val categories = remember {
        listOf("সকল") + allCrops.map { it.category }.distinct()
    }

    val filteredCrops = remember(searchQuery, selectedCategory) {
        allCrops.filter { crop ->
            val matchesCategory = (selectedCategory == "সকল" || crop.category == selectedCategory)
            val matchesQuery = if (searchQuery.isBlank()) true else {
                crop.nameBn.contains(searchQuery.trim(), ignoreCase = true) ||
                crop.scientificName.contains(searchQuery.trim(), ignoreCase = true) ||
                crop.season.contains(searchQuery.trim(), ignoreCase = true)
            }
            matchesCategory && matchesQuery
        }
    }

    Scaffold(
        topBar = {
            AppTopBar(
                title = "ফসল সম্ভার",
                subtitle = "উন্নত জাতের সকল ফসলের চাষাবাদ নির্দেশিকা",
                canNavigateBack = true,
                onNavigateBack = onNavigateBack
            )
        },
        containerColor = AgriScaffoldBg
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Search Input
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                placeholder = { Text("ফসলের নাম লিখুন (যেমন: ধান, আলু, আম)...") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = AgriGreenPrimary)
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "মুছুন")
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

            // Category Chips
            val scrollState = rememberScrollState()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState)
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                categories.forEach { cat ->
                    val isSelected = selectedCategory == cat
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedCategory = cat },
                        label = {
                            Text(
                                text = cat,
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

            Spacer(modifier = Modifier.height(4.dp))

            // Crops List
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                item {
                    Text(
                        text = "মোট ফসল: ${filteredCrops.size}টি",
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = AgriMutedText,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(vertical = 6.dp)
                    )
                }

                items(filteredCrops, key = { it.id }) { crop ->
                    CropCatalogCard(crop = crop, onClick = { onCropClick(crop.id) })
                    Spacer(modifier = Modifier.height(8.dp))
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun CropCatalogCard(crop: Crop, onClick: () -> Unit) {
    Card(
        modifier = Modifier
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
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(AgriGreenContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Eco,
                    contentDescription = null,
                    tint = AgriGreenPrimary,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = crop.nameBn,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = AgriDarkText,
                            fontSize = 15.5.sp
                        )
                    )
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

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = crop.season,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = AgriMutedText,
                        fontSize = 11.5.sp
                    ),
                    maxLines = 1
                )
                Text(
                    text = "সময়কাল: ${crop.durationDays} • ফলন: ${crop.yieldPerBigha}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = AgriGreenDark,
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "বিস্তারিত দেখুন",
                tint = AgriGreenLight,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}
