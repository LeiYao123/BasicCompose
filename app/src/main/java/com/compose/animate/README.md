## 动画

#### 简单值动画， 
  - 可定义animateContentSize、animateContentSizeAsState、animateColorAsState、animateIntAsState、animateDpAsState、animateFloatAsState、animateFloat
  ```kotlin
      val backgroundColor by animateColorAsState(
        if (tabPage == TabPage.Home) Blue400 else Yellow400, label = "",
        animationSpec = tween(2000)
      )
  ```

#### 可见性动画
  ```kotlin
    var isVisibleBtn by remember { mutableStateOf(false) }
    
    ExtendedFloatingActionButton (
        onClick = { isVisibleBtn = !isVisibleBtn },
    ) {
        Row {
            Icon(Icons.Filled.Edit, contentDescription = "Edit")
            AnimatedVisibility(isVisibleBtn) {
                Text("Edit", style = RuTheme.typography.labelXL)
            }
        }
    }
  ```

#### 内容大小动画 animateContentSize
    - 通过animateContentSize()修饰符，根据 column 高度变化而实现动画
    ```kotlin
        Column(modifier = Modifier.animateContentSize()) {
            Text(
                text = "Title $title",
                style = RuTheme.typography.labelXL,
                modifier = Modifier.padding(16.dp).clickable { descExpand = !descExpand }
            )
            if (descExpand) Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet.")
        }
    ```