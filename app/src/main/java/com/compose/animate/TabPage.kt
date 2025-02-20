package com.compose.animate

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

enum class TabPage(
    val title: String,
    val color: Color,
    val icon: ImageVector,
    val body: @Composable (@Composable (() -> Unit)?) -> Unit
) {
    Home(
        "Home",
        color = Color.Blue.copy(alpha = .4f),
        Icons.Filled.Home,
        body = {
            Text("Home")
            it?.invoke()
        }
    ),
    Work(
        "Work",
        color = Color.Yellow.copy(alpha = .4f),
        Icons.Filled.AccountBox,
        body = {
            Text("Work")
            it?.invoke()
        }
    ),
    Profile(
        "Profile",
        color = Color.Red.copy(alpha = .4f),
        Icons.Filled.AccountBox,
        body = {
            Text("Profile")
            it?.invoke()
        }
    );

    companion object {
        fun fromTitle(title: String?) =  entries.firstOrNull { it.title == title } ?: entries[0]
    }
}
