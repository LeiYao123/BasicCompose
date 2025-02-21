package com.compose.effect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.compose.ui.theme.RuTheme
import kotlinx.coroutines.launch

class EffectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuTheme {
                LaunchedEffectSample()
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldSample() {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val snackBar = remember { SnackbarHostState() }

    // mounted 情况
//    LaunchedEffect(Unit) {
//        snackBar.showSnackbar("Hello, World!")
//    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerState) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Drawer Content")
                }
            }
        },
    ) {
        Scaffold(
            snackbarHost = { SnackbarHost(hostState = snackBar) },
            topBar = {
                TopAppBar(
                    title = { Text("脚手架示例") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = null)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors().copy(
                        containerColor = RuTheme.colors.primaryBase,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    )
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    modifier = Modifier.width(100.dp),
                    onClick = {
                        scope.launch {
                            snackBar.showSnackbar(
                                "Hello, World!",
                                withDismissAction = true,
                                duration = SnackbarDuration.Short
                            )
                        }
                    }
                ) {
                    Text("Click Me")
                }
            }
            // 该值主要是影响 paddingValues 的值
            // contentWindowInsets = WindowInsets.statusBars
        ) {
            Surface(modifier = Modifier
                .fillMaxSize()
                .padding(it)) {
                Column {
                    DisposableEffectSample {
                        scope.launch {
                            snackBar.showSnackbar(
                                "do you want close app?",
                                withDismissAction = true,
                                duration = SnackbarDuration.Short
                            )
                        }
                    }
                    DerivedStateOfSample()
                    SnapshotFlowSample()
                }
            }
        }
    }
}

@Composable
fun LaunchedEffectSample() {
    ScaffoldSample()
}