package com.compose.animate

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun HomeTabBar(
    backgroundColor: Color,
    tabPage: TabPage,
    onTabSelected: (tabPage: TabPage) -> Unit
) {
    TabRow(selectedTabIndex = tabPage.ordinal, containerColor = backgroundColor) {
        TabPage.entries.map {
            Tab(
                selected = it == tabPage,
                onClick = { onTabSelected(it) }
            ) {
                val color = Color.Black
                when (it) {
                    TabPage.Home -> {
                        Icon(Icons.Filled.Home, contentDescription = "Home", tint = color)
                        Text("Home", color = color)
                    }
                    TabPage.Work -> {
                        Icon(Icons.Filled.AccountBox, contentDescription = "Work",tint = color)
                        Text("Work", color = color)
                    }
                }
            }
        }
    }
}
