package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF81C784),
    onPrimary = Color(0xFF00390E),
    primaryContainer = Color(0xFF1B5E20),
    onPrimaryContainer = Color(0xFFA5D6A7),
    secondary = Color(0xFFFFD54F),
    onSecondary = Color(0xFF3F2E00),
    secondaryContainer = Color(0xFF5D4037),
    onSecondaryContainer = Color(0xFFFFE082),
    background = Color(0xFF121B14),
    onBackground = Color(0xFFE8F5E9),
    surface = Color(0xFF1A261D),
    onSurface = Color(0xFFE8F5E9),
    surfaceVariant = Color(0xFF26392B),
    onSurfaceVariant = Color(0xFFC2D9C6),
    outline = Color(0xFF4A6B51)
)

private val LightColorScheme = lightColorScheme(
    primary = AgriGreenPrimary,
    onPrimary = Color.White,
    primaryContainer = AgriGreenContainer,
    onPrimaryContainer = AgriGreenDark,
    secondary = AgriGoldHarvest,
    onSecondary = Color.White,
    secondaryContainer = AgriGoldContainer,
    onSecondaryContainer = AgriEarthBrown,
    background = AgriScaffoldBg,
    onBackground = AgriDarkText,
    surface = AgriCardBg,
    onSurface = AgriDarkText,
    surfaceVariant = AgriGreenSurface,
    onSurfaceVariant = AgriMutedText,
    outline = AgriCardBorder
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Use our handcrafted rich agri colors
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

