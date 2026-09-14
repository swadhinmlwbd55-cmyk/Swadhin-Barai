package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Crop
import com.example.data.repository.AgriRepository
import com.example.ui.components.AppTopBar
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FertilizerCalculatorScreen(
    onNavigateBack: () -> Unit
) {
    val crops = AgriRepository.getAllCrops()
    var selectedCropIndex by remember { mutableIntStateOf(0) }
    var landAreaText by remember { mutableStateOf("৩৩") } // default 33 শতক (1 বিঘা)
    var isBighaUnit by remember { mutableStateOf(false) } // false = শতক, true = বিঘা

    val currentCrop = crops.getOrNull(selectedCropIndex) ?: crops.first()
    val scrollState = rememberScrollState()

    val landArea = landAreaText.toDoubleOrNull() ?: 0.0
    val bighaRatio = if (isBighaUnit) landArea else landArea / 33.0

    Scaffold(
        topBar = {
            AppTopBar(
                title = "সার ক্যালকুলেটর",
                subtitle = "জমির মাপ অনুযায়ী সারের সঠিক হিসাব",
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
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            // Intro Card
            Card(
                colors = CardDefaults.cardColors(containerColor = AgriGreenContainer),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Calculate,
                        contentDescription = null,
                        tint = AgriGreenPrimary,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "ডিজিটাল সার হিসাবকারক",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = AgriGreenDark
                            )
                        )
                        Text(
                            text = "আপনার জমির পরিমাণ লিখুন এবং ফসলের জন্য প্রয়োজনীয় সারের সঠিক পরিমাণ জেনে নিন।",
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = AgriDarkText,
                                fontSize = 12.5.sp
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Crop Selector
            Text(
                text = "ফসল নির্বাচন করুন:",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = AgriDarkText
                )
            )
            Spacer(modifier = Modifier.height(6.dp))

            var expandedDropdown by remember { mutableStateOf(false) }
            ExposedDropdownMenuBox(
                expanded = expandedDropdown,
                onExpandedChange = { expandedDropdown = !expandedDropdown },
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = "${currentCrop.nameBn} (${currentCrop.category})",
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedDropdown) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = AgriGreenPrimary,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                )

                ExposedDropdownMenu(
                    expanded = expandedDropdown,
                    onDismissRequest = { expandedDropdown = false }
                ) {
                    crops.forEachIndexed { index, crop ->
                        DropdownMenuItem(
                            text = { Text(crop.nameBn, fontWeight = FontWeight.Medium) },
                            onClick = {
                                selectedCropIndex = index
                                expandedDropdown = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Land unit toggle & input
            Text(
                text = "জমির পরিমাণ:",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = AgriDarkText
                )
            )
            Spacer(modifier = Modifier.height(6.dp))

            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    value = landAreaText,
                    onValueChange = { landAreaText = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("যেমন: ৩৩") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = AgriGreenPrimary,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Row(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(4.dp)
                ) {
                    FilterChip(
                        selected = !isBighaUnit,
                        onClick = { isBighaUnit = false },
                        label = { Text("শতক / ডেসিমাল") }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    FilterChip(
                        selected = isBighaUnit,
                        onClick = { isBighaUnit = true },
                        label = { Text("বিঘা") }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Result Display Card
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "প্রয়োজনীয় সারের তালিকা",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = AgriDarkText
                            )
                        )
                        Surface(
                            color = AgriGoldContainer,
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "জমি: $landAreaText ${if (isBighaUnit) "বিঘা" else "শতক"}",
                                color = AgriEarthBrown,
                                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider(color = AgriCardBorder)
                    Spacer(modifier = Modifier.height(8.dp))

                    if (bighaRatio <= 0.0) {
                        Text(
                            text = "অনুগ্রহ করে জমির সঠিক পরিমাণ প্রবেশ করান।",
                            color = AgriMutedText,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(vertical = 12.dp)
                        )
                    } else {
                        currentCrop.fertilizerList.forEach { item ->
                            val baseAmount = parseFertilizerBase(item.amountPerBigha)
                            val calculatedAmount = if (baseAmount > 0) {
                                String.format("%.2f", baseAmount * bighaRatio)
                            } else {
                                item.amountPerBigha
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.Default.Eco,
                                        contentDescription = null,
                                        tint = AgriGreenLight,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(
                                            text = item.name,
                                            style = MaterialTheme.typography.bodyMedium.copy(
                                                fontWeight = FontWeight.Bold,
                                                color = AgriDarkText
                                            )
                                        )
                                        Text(
                                            text = item.applicationTime,
                                            style = MaterialTheme.typography.bodySmall.copy(
                                                color = AgriMutedText,
                                                fontSize = 11.5.sp
                                            ),
                                            maxLines = 1
                                        )
                                    }
                                }

                                Text(
                                    text = if (baseAmount > 0) "$calculatedAmount কেজি" else item.amountPerBigha,
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = AgriGreenPrimary
                                    )
                                )
                            }
                            HorizontalDivider(color = AgriCardBorder.copy(alpha = 0.4f))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Advice note
            Surface(
                color = AgriGreenSurface,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "পরামর্শ ও সতর্কতা:",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = AgriGreenDark
                        )
                    )
                    Text(
                        text = "• মাটির গুণাগুণ ও স্থানীয় কৃষি কর্মকর্তার পরামর্শ অনুযায়ী মাত্রা কিছুটা পরিবর্তন হতে পারে।\n• নাইট্রোজেনযুক্ত ইউরিয়া সার সবসময় পরিমিত মাটির আর্দ্রতায় প্রয়োগ করুন।\n• জৈব বা কম্পোস্ট সার ব্যবহারে মাটির স্বাস্থ্য ও সারের কার্যকারিতা বৃদ্ধি পায়।",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = AgriDarkText,
                            lineHeight = 18.sp
                        )
                    )
                }
            }
        }
    }
}

private fun parseFertilizerBase(amountStr: String): Double {
    val regex = Regex("""([0-9]+(?:\.[0-9]+)?)""")
    val match = regex.find(amountStr)
    return match?.value?.toDoubleOrNull() ?: 0.0
}
