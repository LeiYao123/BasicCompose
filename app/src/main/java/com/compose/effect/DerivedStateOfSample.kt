package com.compose.effect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DerivedStateOfSample() {
    TodoList()
}


@Composable
fun TodoList() {
    val highPriorityWords = listOf("Review", "Compose", "Jetpack")

    val tasks = remember { mutableStateListOf<String>() }
    var field by remember { mutableStateOf("") }

    // 默认写法，如果内部比较函数比较耗时可能会带来性能问题
//    val highPriorityTasks = tasks.filter { task ->
//        highPriorityWords.any { task.contains(it, ignoreCase = true) }
//    }

    // 使用 derivedStateOf 优化性能，只有当 task 变化时才会重新计算，如果页面中有多个导致重绘的状态就会很有用
    val highPriorityTasks by remember(tasks) {
        derivedStateOf {
            tasks.filter { task ->
                highPriorityWords.any { task.contains(it, ignoreCase = true) }
            }
        }
    }

    Column {
        Row {
            TextField(value = field, onValueChange = { field = it })
            Button(onClick = {
                tasks.add(field)
                field = ""
            }) {
                Text("Add Task")
            }
        }
        LazyColumn {
            items(highPriorityTasks.size) {
                Text(
                    text = highPriorityTasks[it],
                    modifier = Modifier.background(Color.LightGray)
                )
            }
            items(tasks.size) {  Text(text = tasks[it]) }
        }
    }
}