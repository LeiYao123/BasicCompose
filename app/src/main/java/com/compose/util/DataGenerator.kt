package com.compose.util

import com.compose.todo.TodoIcon
import com.compose.todo.TodoItem


fun generatorRandomTodoItem(): TodoItem {
    val message = listOf(
        "Learn Compose",
        "Learn about state",
        "Build an Android app",
        "Learn about Compose for Web",
        "Learn about Compose for Desktop",
        "Try Compose for RenderScript",
        "Learn about Compose for Wasm",
        "Learn about Compose for TV",
        "Learn about Compose for Wear OS",
        "Learn about Compose for AR"
    ).random()
    val icon = TodoIcon.entries.random()
    return TodoItem(message, icon)
}