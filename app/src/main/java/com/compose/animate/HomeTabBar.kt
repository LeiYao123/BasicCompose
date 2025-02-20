package com.compose.animate

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
            Tab(selected = it == tabPage, onClick = { onTabSelected(it) }) {
                val color = Color.Black
                Icon(it.icon, contentDescription = it.title, tint = color)
                Text(it.title, color = color)
            }
        }
    }
}
