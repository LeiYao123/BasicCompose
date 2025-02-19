package com.compose.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle


@Immutable
data class RuTypography(
    val titleH1: TextStyle = TypographyTokens.titleH1,
    val titleH2: TextStyle = TypographyTokens.titleH2,
    val titleH3: TextStyle = TypographyTokens.titleH3,
    val titleH4: TextStyle = TypographyTokens.titleH4,
    val titleH5: TextStyle = TypographyTokens.titleH5,
    val titleH6: TextStyle = TypographyTokens.titleH6,
    val labelXL: TextStyle = TypographyTokens.labelXL,
    val labelL: TextStyle = TypographyTokens.labelL,
    val labelM: TextStyle = TypographyTokens.labelM,
    val labelS: TextStyle = TypographyTokens.labelS,
    val labelXS: TextStyle = TypographyTokens.labelXS,
    val paragraphXL: TextStyle = TypographyTokens.paragraphXL,
    val paragraphL: TextStyle = TypographyTokens.paragraphL,
    val paragraphM: TextStyle = TypographyTokens.paragraphM,
    val paragraphS: TextStyle = TypographyTokens.paragraphS,
    val paragraphXS: TextStyle = TypographyTokens.paragraphXS,
    val subheadingM: TextStyle = TypographyTokens.subheadingM,
    val subheadingS: TextStyle = TypographyTokens.subheadingS,
    val subheadingXS: TextStyle = TypographyTokens.subheadingXS,
    val subheading2XS: TextStyle = TypographyTokens.subheading2XS,
    val docsLabel: TextStyle = TypographyTokens.docsLabel,
    val docsParagraph: TextStyle = TypographyTokens.docsParagraph,
)



//
//// Set of Material typography styles to start with
//val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    )
//    /* Other default text styles to override
//    titleLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 22.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
//    ),
//    labelSmall = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    )
//    */
//)