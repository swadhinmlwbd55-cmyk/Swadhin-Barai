package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Crop
import com.example.data.repository.AgriRepository
import com.example.ui.components.AppTopBar
import com.example.ui.components.DiseaseCardComponent
import com.example.ui.components.FertilizerTableComponent
import com.example.ui.components.TimelineComponent
import com.example.ui.theme.*

@Composable
fun CropDetailScreen(
    cropId: String,
    onNavigateBack: () -> Unit
) {
    val crop = AgriRepository.getCropById(cropId)
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("সময়রেখা", "চাষ পদ্ধতি ও সার", "রোগবালাই দমন", "ফসল কর্তন")

    Scaffold(
        topBar = {
            AppTopBar(
                title = crop?.nameBn ?: "ফসল বৃত্তান্ত",
                subtitle = crop?.scientificName,
                canNavigateBack = true,
                onNavigateBack = onNavigateBack
            )
        },
        containerColor = AgriScaffoldBg
    ) { innerPadding ->
        if (crop == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "ফসলের তথ্য পাওয়া যায়নি", color = AgriMutedText)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            ) {
                // Header overview card
                item {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = crop.nameBn,
                                        style = MaterialTheme.typography.headlineSmall.copy(
                                            fontWeight = FontWeight.Bold,
                                            color = AgriDarkText
                                        )
                                    )
                                    Text(
                                        text = crop.scientificName,
                                        style = MaterialTheme.typography.bodySmall.copy(
                                            fontStyle = FontStyle.Italic,
                                            color = AgriMutedText
                                        )
                                    )
                                }

                                Surface(
                                    color = AgriGreenContainer,
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Text(
                                        text = crop.category,
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

                            // Grid of fast metrics
                            Row(modifier = Modifier.fillMaxWidth()) {
                                MetricItem(
                                    title = "সময়কাল",
                                    value = crop.durationDays,
                                    modifier = Modifier.weight(1f)
                                )
                                MetricItem(
                                    title = "গড় ফলন",
                                    value = crop.yieldPerBigha,
                                    modifier = Modifier.weight(1f)
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Row(modifier = Modifier.fillMaxWidth()) {
                                MetricItem(
                                    title = "মৌসুম",
                                    value = crop.season,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                }

                // Tab Row
                item {
                    TabRow(
                        selectedTabIndex = selectedTab,
                        containerColor = Color.White,
                        contentColor = AgriGreenPrimary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                    ) {
                        tabs.forEachIndexed { index, title ->
                            Tab(
                                selected = selectedTab == index,
                                onClick = { selectedTab = index },
                                text = {
                                    Text(
                                        text = title,
                                        fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Medium,
                                        fontSize = 13.sp
                                    )
                                }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(14.dp))
                }

                // Tab 0: সময়রেখা (Interactive Step-by-Step Timeline)
                if (selectedTab == 0) {
                    item {
                        Card(
                            colors = CardDefaults.cardColors(containerColor = AgriGoldContainer),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Schedule,
                                    contentDescription = null,
                                    tint = AgriEarthBrown,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "বীজ বপন থেকে ফসল সংগ্রহ পর্যন্ত সম্পূর্ণ পর্যায়ক্রমিক সময়রেখা",
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        fontWeight = FontWeight.SemiBold,
                                        color = AgriEarthBrown
                                    )
                                )
                            }
                        }
                    }

                    item {
                        TimelineComponent(timeline = crop.timeline)
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                        SectionCard(title = "বিশেষ কৃষিতাত্ত্বিক পরামর্শ (Golden Tips)") {
                            crop.keyTips.forEach { tip ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Lightbulb,
                                        contentDescription = null,
                                        tint = AgriGoldHarvest,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = tip,
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            color = AgriDarkText,
                                            fontSize = 13.5.sp,
                                            lineHeight = 19.sp
                                        )
                                    )
                                }
                            }
                        }
                    }
                }

                // Tab 1: চাষ পদ্ধতি ও সার (Cultivation & Fertilizer)
                if (selectedTab == 1) {
                    item {
                        SectionCard(title = "উপযুক্ত মাটি ও জমি নির্বাচন") {
                            Text(
                                text = crop.suitableSoil,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = AgriDarkText,
                                    lineHeight = 20.sp
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    item {
                        SectionCard(title = "বীজের হার ও বীজ শোধন পদ্ধতি") {
                            Text(
                                text = "বীজের হার: ${crop.seedRate}",
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = AgriGreenDark
                                )
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = crop.seedTreatment,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = AgriDarkText,
                                    lineHeight = 20.sp
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    item {
                        SectionCard(title = "জমি তৈরি ও রোপণ/বপন পদ্ধতি") {
                            Text(
                                text = crop.landPreparation,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = AgriDarkText,
                                    lineHeight = 20.sp
                                )
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "বপন/রোপণ দূরত্ব:",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = AgriGreenDark
                                )
                            )
                            Text(
                                text = crop.sowingOrPlanting,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = AgriDarkText,
                                    lineHeight = 20.sp
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    item {
                        FertilizerTableComponent(fertilizers = crop.fertilizerList)
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    item {
                        SectionCard(title = "সেচ, নিষ্কাশন ও আগাছা দমন") {
                            Text(
                                text = "সেচ ব্যবস্থাপনা:",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = AgriBlueWater
                                )
                            )
                            Text(
                                text = crop.irrigationPlan,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = AgriDarkText,
                                    lineHeight = 20.sp
                                )
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "আগাছা দমন ও আন্তঃপরিচর্যা:",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = AgriGreenDark
                                )
                            )
                            Text(
                                text = crop.weedingCare,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = AgriDarkText,
                                    lineHeight = 20.sp
                                )
                            )
                        }
                    }
                }

                // Tab 2: রোগবালাই দমন (Pests & Diseases)
                if (selectedTab == 2) {
                    item {
                        Card(
                            colors = CardDefaults.cardColors(containerColor = AgriRedLight),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.HealthAndSafety,
                                    contentDescription = null,
                                    tint = AgriRedWarning,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "সঠিক সময়ে রোগ ও পোকার আক্রমণ শনাক্ত করে উপযুক্ত বালাইনাশক বা জৈব প্রতিকার প্রয়োগ করুন।",
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        fontWeight = FontWeight.SemiBold,
                                        color = AgriRedWarning
                                    )
                                )
                            }
                        }
                    }

                    items(crop.diseases) { disease ->
                        DiseaseCardComponent(disease = disease)
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }

                // Tab 3: ফসল কর্তন ও সংরক্ষণ (Harvesting & Storage)
                if (selectedTab == 3) {
                    item {
                        SectionCard(title = "ফসল কর্তন, মাড়াই ও সংরক্ষণ পদ্ধতি") {
                            Text(
                                text = crop.harvestingAndStorage,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = AgriDarkText,
                                    lineHeight = 21.sp
                                )
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    item {
                        SectionCard(title = "উন্নত গুদামজাতকরণের ৫টি স্বর্ণসূত্র") {
                            val rules = listOf(
                                "দাঁত দিয়ে কাটলে 'কট' শব্দ না হওয়া পর্যন্ত এবং আর্দ্রতা ১০-১২% এ না নামা পর্যন্ত ফসল ভালোভাবে শুকান।",
                                "শুকনো নিমপাতা, নিশিন্দা বা বিষকাটালির শুকনো পাতা শস্যের পাত্রে মিশিয়ে রাখলে পোকার আক্রমণ হয় না।",
                                "বায়ুরোধী ড্রাম, প্লাস্টিক ড্রাম বা জিআই শিটের মোতায় শস্য সংরক্ষণ করুন।",
                                "পাত্র কখনো সরাসরি মাটির মেঝের ওপর রাখবেন না; কাঠের তক্তা বা মাচার ওপর রাখুন।",
                                "মাঝে মাঝে কড়া রোদের দিনে বীজ বা শস্য বের করে ১-২ ঘণ্টা রোদে শুকিয়ে পুনরায় ঠাণ্ডা করে রাখুন।"
                            )
                            rules.forEachIndexed { idx, rule ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Text(
                                        text = "${idx + 1}.",
                                        fontWeight = FontWeight.Bold,
                                        color = AgriGreenPrimary,
                                        modifier = Modifier.width(22.dp)
                                    )
                                    Text(
                                        text = rule,
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            color = AgriDarkText,
                                            fontSize = 13.5.sp,
                                            lineHeight = 19.sp
                                        )
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

@Composable
fun MetricItem(title: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(end = 8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall.copy(
                color = AgriMutedText,
                fontSize = 11.sp
            )
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                color = AgriDarkText,
                fontSize = 13.5.sp
            )
        )
    }
}

@Composable
fun SectionCard(title: String, content: @Composable ColumnScope.() -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = AgriGreenDark,
                    fontSize = 15.5.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(color = AgriCardBorder.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(10.dp))
            content()
        }
    }
}
