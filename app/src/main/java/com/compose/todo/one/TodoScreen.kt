package com.compose.todo.one

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.compose.todo.TodoItem

@Composable
fun TodoScreen(list: List<TodoItem>) {
    Column {
        LazyColumn(modifier = Modifier.weight(1f), contentPadding = PaddingValues(16.dp)) {
            itemsIndexed(list) { index, item ->
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("${index + 1}. ${item.task}")
                    Icon(imageVector = item.icon.imageVector, contentDescription = item.icon.desc)
                }
            }
        }
        Button(onClick = {},
            modifier = Modifier
                .padding(16.dp).fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            ) {
            Text("Add Random item")
        }
    }
}