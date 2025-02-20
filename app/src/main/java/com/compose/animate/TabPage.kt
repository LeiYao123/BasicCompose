package com.compose.animate

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class TabPage(
    val title: String,
    val icon: ImageVector
) {
    Home(
        "Home",
        Icons.Filled.Home
    ),
    Work(
        "Work",
        Icons.Filled.AccountBox
    ),
    Profile(
        "Profile",
        Icons.Filled.AccountBox
    )
}
