package com.compose.todo.one

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.compose.ui.theme.RuTheme

class TodoActivity : ComponentActivity() {
    private val viewModel by viewModels<TodoViewModel>()
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = { Text("Todo List") }
                        )
                    }
                ) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        TodoActivityScreen()
                    }
                }
            }
        }
    }

    @Composable
    fun TodoActivityScreen() {
//        val items = viewModel.todoItems.value ?: emptyList()
        val items by viewModel.todoItems.observeAsState(emptyList())
        val editingItem by viewModel.editingItem.observeAsState()
        TodoScreen(
            items,
            editingItem,
            onAddItem =  viewModel::addTodoItem,
            onRemoveItem = viewModel::removeTodoItem,
            onUpdateItem = viewModel::updateCurrEditingItem,
            onSaveEditItem = viewModel::saveEditingItem
        )
    }
}

