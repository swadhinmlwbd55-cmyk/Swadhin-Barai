package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.ui.screens.*
import com.example.ui.theme.AgriScaffoldBg
import com.example.ui.theme.MyApplicationTheme

sealed interface Screen {
    data object Home : Screen
    data class DistrictDetail(val districtId: Int) : Screen
    data class CropDetail(val cropId: String) : Screen
    data object Calculator : Screen
    data object Calendar : Screen
    data object AllCrops : Screen
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AgriScaffoldBg
                ) {
                    AgriApp()
                }
            }
        }
    }
}

@Composable
fun AgriApp() {
    val backStack = remember { mutableStateListOf<Screen>(Screen.Home) }
    val currentScreen = backStack.last()

    fun navigateTo(screen: Screen) {
        backStack.add(screen)
    }

    fun navigateBack() {
        if (backStack.size > 1) {
            backStack.removeAt(backStack.lastIndex)
        }
    }

    BackHandler(enabled = backStack.size > 1) {
        navigateBack()
    }

    Crossfade(targetState = currentScreen, label = "ScreenTransition") { screen ->
        when (screen) {
            is Screen.Home -> {
                HomeScreen(
                    onDistrictClick = { districtId ->
                        navigateTo(Screen.DistrictDetail(districtId))
                    },
                    onNavigateToCalculator = {
                        navigateTo(Screen.Calculator)
                    },
                    onNavigateToCalendar = {
                        navigateTo(Screen.Calendar)
                    },
                    onNavigateToAllCrops = {
                        navigateTo(Screen.AllCrops)
                    }
                )
            }

            is Screen.DistrictDetail -> {
                DistrictDetailScreen(
                    districtId = screen.districtId,
                    onCropClick = { cropId ->
                        navigateTo(Screen.CropDetail(cropId))
                    },
                    onNavigateBack = { navigateBack() }
                )
            }

            is Screen.CropDetail -> {
                CropDetailScreen(
                    cropId = screen.cropId,
                    onNavigateBack = { navigateBack() }
                )
            }

            is Screen.Calculator -> {
                FertilizerCalculatorScreen(
                    onNavigateBack = { navigateBack() }
                )
            }

            is Screen.Calendar -> {
                CropCalendarScreen(
                    onCropSelected = { cropId ->
                        navigateTo(Screen.CropDetail(cropId))
                    },
                    onNavigateBack = { navigateBack() }
                )
            }

            is Screen.AllCrops -> {
                AllCropsCatalogScreen(
                    onCropClick = { cropId ->
                        navigateTo(Screen.CropDetail(cropId))
                    },
                    onNavigateBack = { navigateBack() }
                )
            }
        }
    }
}
