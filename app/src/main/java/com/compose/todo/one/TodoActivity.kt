package com.compose.todo.one

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.compose.todo.TodoIcon
import com.compose.todo.TodoItem
import com.compose.ui.theme.BasicComposeTheme

class TodoActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicComposeTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = { Text("Todo List") }
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {  }) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
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
        val items = listOf(
            TodoItem("Learn Compose", TodoIcon.Event),
            TodoItem("Build something fun!", TodoIcon.Square),
            TodoItem("Wash dishes", TodoIcon.Done),
            TodoItem("Prepare breakfast", TodoIcon.Event),
            TodoItem("Take out the trash", TodoIcon.Trash),
            TodoItem("Finish report", TodoIcon.Privacy),
            TodoItem("Take a walk", TodoIcon.Event),
            TodoItem("Watch a movie", TodoIcon.Event),
        )
        TodoScreen(items)
    }
}

