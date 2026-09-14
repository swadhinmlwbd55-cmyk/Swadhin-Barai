package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.FertilizerItem
import com.example.ui.theme.*

@Composable
fun FertilizerTableComponent(fertilizers: List<FertilizerItem>, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(
                text = "সার প্রয়োগের সুপারিশকৃত মাত্রা (বিঘাপ্রতি)",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = AgriDarkText,
                    fontSize = 15.sp
                )
            )
            Text(
                text = "*১ বিঘা = ৩৩ শতক হিসেবে হিসাবকৃত",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = AgriMutedText,
                    fontSize = 11.5.sp
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AgriGreenContainer, shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 10.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "সারের নাম",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = AgriGreenDark
                    ),
                    modifier = Modifier.weight(1.2f)
                )
                Text(
                    text = "পরিমাণ (বিঘা)",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = AgriGreenDark
                    ),
                    modifier = Modifier.weight(1.1f)
                )
                Text(
                    text = "প্রয়োগের সময়",
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = AgriGreenDark
                    ),
                    modifier = Modifier.weight(2f)
                )
            }

            // Rows
            fertilizers.forEachIndexed { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = AgriDarkText,
                            fontSize = 13.sp
                        ),
                        modifier = Modifier.weight(1.2f)
                    )
                    Text(
                        text = item.amountPerBigha,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = AgriGreenPrimary,
                            fontSize = 13.sp
                        ),
                        modifier = Modifier.weight(1.1f)
                    )
                    Text(
                        text = item.applicationTime,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = AgriDarkText,
                            fontSize = 12.sp,
                            lineHeight = 16.sp
                        ),
                        modifier = Modifier.weight(2f)
                    )
                }

                if (index < fertilizers.size - 1) {
                    HorizontalDivider(color = AgriCardBorder.copy(alpha = 0.5f), thickness = 0.6.dp)
                }
            }
        }
    }
}
