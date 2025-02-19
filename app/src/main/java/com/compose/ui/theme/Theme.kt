package com.compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf


val LocalCustomColors = compositionLocalOf<RuColors> {
    error("No CustomColors provided")
}

val LocalCustomTypography = compositionLocalOf<RuTypography> {
    error("No CustomTypography provided")
}

@Composable
fun RuTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkRuColor() else lightRuColor()
    val typography = RuTypography()
    CompositionLocalProvider(
        LocalCustomColors.provides(colors), // 中缀调用
        LocalCustomTypography provides typography
    ) {
        MaterialTheme(content = content)
    }
}

object RuTheme {
    val colors: RuColors
        @Composable
        get() = LocalCustomColors.current
    val typography: RuTypography
        @Composable
        get() = LocalCustomTypography.current
}
