package com.compose.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

internal val TD = TextStyle.Default.copy(fontWeight = FontWeight.W500)

internal object TypographyTokens {
    val titleH1 = TD.copy(fontSize = 56.sp, lineHeight = 64.sp)
    val titleH2 = TD.copy(fontSize = 48.sp, lineHeight = 56.sp)
    val titleH3 = TD.copy(fontSize = 40.sp, lineHeight = 48.sp)
    val titleH4 = TD.copy(fontSize = 32.sp, lineHeight = 40.sp)
    val titleH5 = TD.copy(fontSize = 24.sp, lineHeight = 32.sp)
    val titleH6 = TD.copy(fontSize = 20.sp, lineHeight = 28.sp)

    val labelXL = TD.copy(fontSize = 24.sp, lineHeight = 32.sp)
    val labelL = TD.copy(fontSize = 18.sp, lineHeight = 24.sp)
    val labelM = TD.copy(fontSize = 16.sp, lineHeight = 24.sp)
    val labelS = TD.copy(fontSize = 14.sp, lineHeight = 20.sp)
    val labelXS = TD.copy(fontSize = 12.sp, lineHeight = 16.sp)

    val paragraphXL = TD.copy(fontSize = 24.sp, fontWeight = FontWeight.W400, lineHeight = 32.sp)
    val paragraphL = TD.copy(fontSize = 18.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp)
    val paragraphM = TD.copy(fontSize = 16.sp, fontWeight = FontWeight.W400, lineHeight = 24.sp)
    val paragraphS = TD.copy(fontSize = 14.sp, fontWeight = FontWeight.W400, lineHeight = 20.sp)
    val paragraphXS = TD.copy(fontSize = 12.sp, fontWeight = FontWeight.W400, lineHeight = 16.sp)

    val subheadingM = TD.copy(fontSize = 16.sp, lineHeight = 24.sp)
    val subheadingS = TD.copy(fontSize = 14.sp, lineHeight = 20.sp)
    val subheadingXS = TD.copy(fontSize = 12.sp, lineHeight = 16.sp)
    val subheading2XS = TD.copy(fontSize = 11.sp, lineHeight = 12.sp)

    val docsLabel = TD.copy(fontSize = 18.sp, lineHeight = 32.sp)
    val docsParagraph = TD.copy(fontSize = 18.sp, fontWeight = FontWeight.W400, lineHeight = 32.sp)
}

