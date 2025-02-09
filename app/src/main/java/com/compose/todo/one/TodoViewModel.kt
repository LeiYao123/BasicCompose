package com.compose.todo.one

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.compose.todo.TodoIcon
import com.compose.todo.TodoItem

class TodoViewModel: ViewModel() {
    private val items = listOf(
        TodoItem("Learn Compose", TodoIcon.Event),
        TodoItem("Build something fun!", TodoIcon.Square),
    )

    private val _todoItems = MutableLiveData(items)

    val todoItems = _todoItems
//    val todoItems:LiveData<List<TodoItem>> = _todoItems

    fun addTodoItem(item: TodoItem) {
        _todoItems.value = _todoItems.value?.plus(item)
    }

    fun removeTodoItem(item: TodoItem) {
        _todoItems.value = _todoItems.value?.minus(item)
    }

    // 正在编辑的 item
    val editingItem = MutableLiveData<TodoItem?>(null)

    fun updateCurrEditingItem(todoItem: TodoItem? = null) {
        editingItem.value = todoItem
    }

    fun saveEditingItem(todoItem: TodoItem) {
        editingItem.value = null
        _todoItems.value = _todoItems.value?.map { item ->
            if (item.id == todoItem.id) {
                println("执行到此处了...")
                 todoItem
            } else {
                item
            }
        }
        println("saveEditingItem: ${_todoItems.value}")
        println("id-- ${todoItem.id}")
    }
}