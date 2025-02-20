package com.compose.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.compose.animate.HomeTabBar
import com.compose.animate.TabPage
import com.compose.ui.theme.RuTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuTheme { PageContent() }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageContent() {
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currTab = TabPage.fromTitle(backStackEntry.value?.destination?.route)

    val backgroundColor by animateColorAsState(
        currTab.color, label = "", animationSpec = tween(1200)
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = backgroundColor,
        topBar = {
//            TopAppBar(title = { Text(text = currTab.title) })
            HomeTabBar(
                modifier = Modifier.padding(top = 48.dp),
                backgroundColor = backgroundColor,
                tabPage = currTab,
                onTabSelected = { navController.navigate(it.title) }
            )
        },
    ) {
        Surface(modifier = Modifier.padding(it)) {
            RallyNavHost(navController)
        }
    }
}

@Composable
fun RallyNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = TabPage.Home.title,
    ) {
        TabPage.entries.forEach { tab ->
            composable(route = tab.title) {
                tab.body {
                    if (tab == TabPage.Home) {
                        ElevatedButton(onClick = {
                            navHostController.navigate("Detail/123")
                        }) {
                            Text("Click me GO TO DETAIL")
                        }
                    }
                }
            }
        }

        // 详情页 ==> 参数导航
        composable(
            route = "Detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType }),
            deepLinks = listOf(navDeepLink { uriPattern = "rally://detail/{id}" })
        ) { entry ->
            val id = entry.arguments?.getString("id")
            Text("detail page $id")
        }
    }
}