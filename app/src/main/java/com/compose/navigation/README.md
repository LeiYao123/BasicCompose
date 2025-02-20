## Compose 导航

1. `NavHost` 组件， 需要引入依赖 navigationCompose = "2.8.7"、implementation(libs.androidx.navigation.compose)

2. 具体路由承载
   ```
    @Composable
    fun RallyNavHost(navHostController: NavHostController) {
        NavHost(
            navController = navHostController,
            startDestination = TabPage.Home.title,
        ) {
        composable(route = tab.title) {
             Text("主界面")
        }
    }
   
    // 路由跳转
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currTab = TabPage.fromTitle(backStackEntry.value?.destination?.route)
    navController.navigate(it.title)
   ```
   
3. deepLink
   ```
    // 详情页 ==> 参数导航
    composable(
        route = "Detail/{id}",
        arguments = listOf(navArgument("id") { type = NavType.StringType }),
        deepLinks = listOf(navDeepLink { uriPattern = "rally://detail/{id}" })
    ) { entry ->
        val id = entry.arguments?.getString("id")
        Text("detail page $id")
    }
   ```
   ```xml
    <!--    清单文件配置 AndroidManifest.xml -->
    <!-- 配置 deep link -->
    <intent-filter>
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <data android:scheme="rally" android:host="detail" />
    </intent-filter>
   ```
   - adb 调用命令：`adb shell am start -d "rally://detail/4567" -a android.intent.action.VIEW`

### TopAppBar 用法