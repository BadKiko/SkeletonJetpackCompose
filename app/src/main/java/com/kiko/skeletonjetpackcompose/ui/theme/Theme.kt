package com.kiko.skeletonjetpackcompose.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val mainTheme = darkColorScheme(
    primary = Primary,
    onPrimary = PrimaryHighlight,
    onPrimaryContainer = PrimaryHighlight,
    background = Background,
    secondary = Secondary
)

@Composable
fun SkeletonJetpackComposeTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = mainTheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }

    MaterialTheme(
        colorScheme = mainTheme,
        typography = Typography,
        content = content
    )
}