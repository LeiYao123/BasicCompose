### 组合函数的生命周期

- 组合函数中没有自带的生命周期函数，要想监听其生命周期，需要使用 Effect API (附带效应)。

创建协程
1. `LaunchedEffect`：在组合函数启动时执行一次。
2. `DisposableEffect`：内部有一个 onDispose 函数，当组合函数结束时执行清理操作。
3. `SideEffect`: compose 函数重组时执行。一般用来，非 compose 管理的数据与 compose 状态共享时使用。





### produceState
- produceState 可以将非 Compose 状态转换为 Compose 状态。它接受一个 lambda 表达式作为函数体，能将这些入参经过一些操作后生成一个 State 类型变量并返回
- produceState 创建了一个协程，但他也可以用于 观察非挂起函数的数据源

- 主要用于 管理异步数据流，例如 网络请求、数据库查询、传感器数据等。
- 让 State 可以 响应式地更新，从而驱动 UI 自动重组（Recompose）。

  ```kotlin
    @Composable
    fun Example() {
        val state by produceState(initialValue = "Loading...") {
            // 这里可以执行异步任务
            delay(2000)
            value = "Data Loaded"
        }
        Text(text = state)
    }
  ```
### derivedStateOf
- derivedStateOf 是 Jetpack Compose 提供的 性能优化工具，用于基于其他 State 计算新的 State，并且 只有当依赖的 State 发生变化时才会重新计算。
##### 为什么需要 derivedStateOf
- 在 Compose 中，如果 State 变化会触发整个组合树的重组，但有时候我们只希望在某些状态变化时触发计算，而不是每次重组都重新计算值。这时候 derivedStateOf 就派上用场了。

- 核心作用：1. 避免不必要的计算
  ```kotlin
    @Composable
    fun Example() {
        // 可变状态
        var count by remember { mutableStateOf(0) }
        // 通过 derivedStateOf 计算新的 State
        // 只有 count 变化，isEven 才会重新计算
        val isEven by derivedStateOf {
            count % 2 == 0
        }
        Button(onClick = { count++ }) {
            Text(text = "Count: $count, isEven: $isEven")
        }
    }
  ```
  
### snapshotFlow
- snapshotFlow 是 Jetpack Compose 提供的 State → Flow 的桥梁，它可以 将 Compose 的 State 转换为 Flow，并在 State 变化时触发新的数据流。
#### 何时使用？
1. 监听 LazyListState 滚动状态并触发事件
2. 监听 state 变化并执行异步操作
3. 防抖、节流等优化操作
   ```kotlin
        // 监听 TextField 输入并防抖
        val textState = remember { mutableStateOf("") }
        val textFlow = textState.snapshotFlow { textState.value }
            .debounce(300)
            .collectLatest { 
                println("用户输入：$it")
            }
   ```