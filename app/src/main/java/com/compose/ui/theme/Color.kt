package com.compose.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class RuColors(
    val primaryDark: Color = PaletteTokens.blue_800,
    val primaryDarker: Color = PaletteTokens.blue_700,
    val primaryBase: Color = PaletteTokens.blue_500,
    val primaryAlpha16: Color = PaletteTokens.black_alpha_16,
    val primaryAlpha10: Color = PaletteTokens.blue_alpha_10,
    val staticBlack: Color = PaletteTokens.neutral_950,
    val staticWhite: Color = PaletteTokens.neutral_0,

    val bgStrong: Color,
    val bgSurface: Color,
    val bgSub: Color,
    val bgSoft: Color,
    val bgWeak: Color,
    val bgWhite: Color,

    val textStrong: Color,
    val textSub: Color,
    val textSoft: Color,
    val textDisabled: Color,
    val textWhite: Color,

    val strokeStrong: Color,
    val strokeSub: Color,
    val strokeSoft: Color,
    val strokeWhite: Color,

    val iconStrong: Color,
    val iconSub: Color,
    val iconSoft: Color,
    val iconDisabled: Color,
    val iconWhite: Color,

    val fadedDark: Color,
    val fadedBase: Color,
    val fadedLight: Color,
    val fadedLighter: Color,

    val informationDark: Color,
    val informationBase: Color,
    val informationLight: Color,
    val informationLighter: Color,

    val warningDark: Color,
    val warningBase: Color,
    val warningLight: Color,
    val warningLighter: Color,

    val errorDark: Color,
    val errorBase: Color,
    val errorLight: Color,
    val errorLighter: Color,

    val successDark: Color,
    val successBase: Color,
    val successLight: Color,
    val successLighter: Color,

    val awayDark: Color,
    val awayBase: Color,
    val awayLight: Color,
    val awayLighter: Color,

    val featureDark: Color,
    val featureBase: Color,
    val featureLight: Color,
    val featureLighter: Color,

    val verifiedDark: Color,
    val verifiedBase: Color,
    val verifiedLight: Color,
    val verifiedLighter: Color,

    val highlightedDark: Color,
    val highlightedBase: Color,
    val highlightedLight: Color,
    val highlightedLighter: Color,

    val stableDark: Color,
    val stableBase: Color,
    val stableLight: Color,
    val stableLighter: Color,
)

fun lightRuColor(): RuColors {
    return RuColors(
        bgStrong = PaletteTokens.neutral_950,
        bgSurface = PaletteTokens.neutral_800,
        bgSub = PaletteTokens.neutral_300,
        bgSoft = PaletteTokens.neutral_200,
        bgWeak = PaletteTokens.neutral_50,
        bgWhite = PaletteTokens.neutral_0,

        textStrong = PaletteTokens.neutral_950,
        textSub = PaletteTokens.neutral_600,
        textSoft = PaletteTokens.neutral_400,
        textDisabled = PaletteTokens.neutral_300,
        textWhite = PaletteTokens.neutral_0,

        strokeStrong = PaletteTokens.neutral_950,
        strokeSub = PaletteTokens.neutral_300,
        strokeSoft = PaletteTokens.neutral_200,
        strokeWhite = PaletteTokens.neutral_0,

        iconStrong = PaletteTokens.neutral_950,
        iconSub = PaletteTokens.neutral_600,
        iconSoft = PaletteTokens.neutral_400,
        iconDisabled = PaletteTokens.neutral_300,
        iconWhite = PaletteTokens.neutral_0,

        fadedDark = PaletteTokens.neutral_800,
        fadedBase = PaletteTokens.neutral_500,
        fadedLight = PaletteTokens.neutral_200,
        fadedLighter = PaletteTokens.neutral_100,

        informationDark = PaletteTokens.blue_950,
        informationBase = PaletteTokens.blue_500,
        informationLight = PaletteTokens.blue_200,
        informationLighter = PaletteTokens.blue_50,

        warningDark = PaletteTokens.orange_950,
        warningBase = PaletteTokens.orange_500,
        warningLight = PaletteTokens.orange_200,
        warningLighter = PaletteTokens.orange_50,

        errorDark = PaletteTokens.red_950,
        errorBase = PaletteTokens.red_500,
        errorLight = PaletteTokens.red_200,
        errorLighter = PaletteTokens.red_50,

        successDark = PaletteTokens.green_950,
        successBase = PaletteTokens.green_500,
        successLight = PaletteTokens.green_200,
        successLighter = PaletteTokens.green_50,

        awayDark = PaletteTokens.yellow_950,
        awayBase = PaletteTokens.yellow_500,
        awayLight = PaletteTokens.yellow_200,
        awayLighter = PaletteTokens.yellow_50,

        featureDark = PaletteTokens.purple_950,
        featureBase = PaletteTokens.purple_500,
        featureLight = PaletteTokens.purple_200,
        featureLighter = PaletteTokens.purple_50,

        verifiedDark = PaletteTokens.sky_950,
        verifiedBase = PaletteTokens.sky_500,
        verifiedLight = PaletteTokens.sky_200,
        verifiedLighter = PaletteTokens.sky_50,

        highlightedDark = PaletteTokens.pink_950,
        highlightedBase = PaletteTokens.pink_500,
        highlightedLight = PaletteTokens.pink_200,
        highlightedLighter = PaletteTokens.pink_50,

        stableDark = PaletteTokens.teal_950,
        stableBase = PaletteTokens.teal_500,
        stableLight = PaletteTokens.teal_200,
        stableLighter = PaletteTokens.teal_50,
    )
}

fun darkRuColor(): RuColors {
    return RuColors(
        bgStrong = PaletteTokens.neutral_0,
        bgSurface = PaletteTokens.neutral_200,
        bgSub = PaletteTokens.neutral_600,
        bgSoft = PaletteTokens.neutral_700,
        bgWeak = PaletteTokens.neutral_900,
        bgWhite = PaletteTokens.neutral_950,

        textStrong = PaletteTokens.neutral_0,
        textSub = PaletteTokens.neutral_400,
        textSoft = PaletteTokens.neutral_500,
        textDisabled = PaletteTokens.neutral_600,
        textWhite = PaletteTokens.neutral_950,

        strokeStrong = PaletteTokens.neutral_0,
        strokeSub = PaletteTokens.neutral_600,
        strokeSoft = PaletteTokens.neutral_700,
        strokeWhite = PaletteTokens.neutral_950,

        iconStrong = PaletteTokens.neutral_0,
        iconSub = PaletteTokens.neutral_400,
        iconSoft = PaletteTokens.neutral_500,
        iconDisabled = PaletteTokens.neutral_600,
        iconWhite = PaletteTokens.neutral_950,

        fadedDark = PaletteTokens.neutral_300,
        fadedBase = PaletteTokens.neutral_500,
        fadedLight = PaletteTokens.blue_alpha_24,
        fadedLighter = PaletteTokens.blue_alpha_16,

        informationDark = PaletteTokens.blue_400,
        informationBase = PaletteTokens.blue_500,
        informationLight = PaletteTokens.blue_alpha_24,
        informationLighter = PaletteTokens.blue_alpha_16,

        warningDark = PaletteTokens.orange_400,
        warningBase = PaletteTokens.orange_600,
        warningLight = PaletteTokens.orange_alpha_24,
        warningLighter = PaletteTokens.orange_alpha_16,

        errorDark = PaletteTokens.red_400,
        errorBase = PaletteTokens.red_600,
        errorLight = PaletteTokens.red_alpha_24,
        errorLighter = PaletteTokens.red_alpha_16,

        successDark = PaletteTokens.green_400,
        successBase = PaletteTokens.green_600,
        successLight = PaletteTokens.green_alpha_24,
        successLighter = PaletteTokens.green_alpha_16,

        awayDark = PaletteTokens.yellow_400,
        awayBase = PaletteTokens.yellow_600,
        awayLight = PaletteTokens.yellow_alpha_24,
        awayLighter = PaletteTokens.yellow_alpha_16,

        featureDark = PaletteTokens.purple_400,
        featureBase = PaletteTokens.purple_500,
        featureLight = PaletteTokens.purple_alpha_24,
        featureLighter = PaletteTokens.purple_alpha_16,

        verifiedDark = PaletteTokens.sky_400,
        verifiedBase = PaletteTokens.sky_600,
        verifiedLight = PaletteTokens.sky_alpha_24,
        verifiedLighter = PaletteTokens.sky_alpha_16,

        highlightedDark = PaletteTokens.pink_400,
        highlightedBase = PaletteTokens.pink_600,
        highlightedLight = PaletteTokens.pink_alpha_24,
        highlightedLighter = PaletteTokens.pink_alpha_16,

        stableDark = PaletteTokens.teal_400,
        stableBase = PaletteTokens.teal_600,
        stableLight = PaletteTokens.teal_alpha_24,
        stableLighter = PaletteTokens.teal_alpha_16,
    )
}



