package com.compose.animate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.compose.ui.theme.RuTheme

class AnimateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuTheme {
                PageContent()
            }
        }
    }
}

@Composable
fun PageContent() {
    var tabPage by remember { mutableStateOf(TabPage.Home) }
    // 简单值动画
    val backgroundColor by animateColorAsState(
        tabPage.color, label = "",
        animationSpec = tween(2000)
    )

    val textColor by animateColorAsState(
        if (tabPage == TabPage.Home) Color.White else Color.Black, label = "",
        animationSpec = tween(2000)
    )
    var isVisibleBtn by remember { mutableStateOf(false) }

    var showEdit by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = backgroundColor,
        contentColor = Color.White,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    isVisibleBtn = !isVisibleBtn
                    showEdit = !showEdit
                },
            ) {
                Row {
                    Icon(Icons.Filled.Edit, contentDescription = "Edit")
                    AnimatedVisibility(isVisibleBtn) {
                        Text(
                            "Edit",
                            style = RuTheme.typography.labelXL,
                            modifier = Modifier.padding(start = 8.dp, end = 3.dp)
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding),
            color = Color.Transparent
        ) {
            Column {
                HomeTabBar(
                    backgroundColor = backgroundColor,
                    tabPage = tabPage,
                    onTabSelected = { tabPage = it }
                )
                AnimatedVisibility(showEdit) {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = RuTheme.colors.successBase,
                        shadowElevation = 4.dp
                    ) {
                        Text(
                            "Edit Future is not sub",
                            style = RuTheme.typography.labelXL,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
                LazyColumn {
                    items(10) { TopicsItem(it, textColor) }
                }
            }
        }
    }
}
