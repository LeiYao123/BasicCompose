package com.compose.todo.one

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.compose.todo.TodoIcon
import com.compose.todo.TodoItem
import com.compose.ui.theme.RuTheme
import com.compose.util.generatorRandomTodoItem
import kotlin.random.Random

@Composable
fun TodoScreen(
    list: List<TodoItem>,
    editingItem: TodoItem?,
    onAddItem: (TodoItem) -> Unit,
    onUpdateItem: (TodoItem?) -> Unit,
    onSaveEditItem: (TodoItem) -> Unit,
    onRemoveItem: (TodoItem) -> Unit,
) {

    Column {
        TodoItemInputBackground(elevation = true) {
            TodoInputForAdd(onAddItem)
        }
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(top = 16.dp)
        ) {
            itemsIndexed(list) { index, item ->
                if (editingItem?.id == item.id) {
                    TodoItemInlineEdit(
                        item,
                        onRemoveItem = { onRemoveItem(it) },
                        onSaveItem = { onSaveEditItem(it) }
                    )
                } else {
                    ItemRows(index, item) { onUpdateItem(item) }
                }
            }
        }
        TodoRandomForAdd(onAddItem)
    }
}


@Composable
fun ItemRows(index: Int, item: TodoItem, onClick: () -> Unit) {
    // 相当于 react 的 useCallback useMemo
    val random = remember(item.id) { randomTint() }
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("${index + 1}. ${item.task}")
        Icon(
            imageVector = item.icon.imageVector,
            contentDescription = item.icon.desc,
            tint = LocalContentColor.current.copy(random, random, random),
            // 每次都会重组成不同颜色
            // tint = LocalContentColor.current.copy(randomTint(), randomTint(), randomTint())
        )
    }
}

@Composable
fun TodoRandomForAdd(onAddItem: (TodoItem) -> Unit) {
    Button(
        onClick = { onAddItem(generatorRandomTodoItem()) },
        colors = ButtonDefaults.buttonColors(
            containerColor = RuTheme.colors.bgWhite,
            contentColor = RuTheme.colors.primaryBase,
        ),
        border = BorderStroke(1.dp, RuTheme.colors.primaryBase),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) { Text("Add Random item", style = RuTheme.typography.labelS) }
}

private fun randomTint(): Float {
    return Random.nextFloat().coerceIn(0.3f, 0.9f)
}


// 顶部输入框，添加按钮
@Composable
fun TodoInputForAdd(onAddItem: (TodoItem) -> Unit) {
    TodoInput(
        onAddItem = onAddItem,
        buttonSlot = { item, callSubmit ->
            TextButton(
                onClick = { callSubmit() },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(),
                enabled = item.task.isNotBlank(),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text("Custom Add")
            }
        }
    )
}


// 行内输入框，编辑删除按钮
@Composable
fun TodoItemInlineEdit(
    item: TodoItem,
    onRemoveItem: (TodoItem) -> Unit,
    onSaveItem: (TodoItem) -> Unit
) {
    TodoInput(
        todoItem = item,
        buttonSlot = { todoItem, _ ->
            TextButton(
                onClick = { onSaveItem(todoItem) },
                enabled = todoItem.task.isNotBlank(),
            ) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Done",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            TextButton(onClick = { onRemoveItem(todoItem) }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Trash",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    )
}

@Composable
fun TodoInput(
    todoItem: TodoItem? = null,
    onAddItem: (TodoItem) -> Unit = {},
    buttonSlot: @Composable (item: TodoItem, callSubmit: () -> Unit) -> Unit,
) {
    val (text, setText) = remember { mutableStateOf(todoItem?.task ?: "") }
    val (selectedIcon, setSelectedIcon) = remember { mutableStateOf(TodoIcon.Default) }

    val keyboardController = LocalSoftwareKeyboardController.current

    fun submit() {
        onAddItem(TodoItem(text, selectedIcon))
        setText("")
        setSelectedIcon(TodoIcon.Default)
        keyboardController?.hide()
    }

    Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = text,
                onValueChange = setText,
                modifier = Modifier.weight(1f),
                singleLine = true,
                // 配置软键盘
                keyboardActions = KeyboardActions(onDone = { submit() }),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                ),
            )
            if (todoItem == null) {
                buttonSlot(TodoItem(text, selectedIcon)) { submit() }
            } else {
                buttonSlot(todoItem.copy(task = text, icon = selectedIcon)) {  submit() }
            }

        }
        // 选择图标按钮
        IconsRow(text.isNotBlank(), selectedIcon, setSelectedIcon)
    }
}

@Composable
fun IconsRow(visible: Boolean, selectedIcon: TodoIcon, onIconSelected: (TodoIcon) -> Unit) {
    val enter = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = 300,
                easing = FastOutLinearInEasing
            )
        )
    }
    val exit = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = 100,
                easing = FastOutSlowInEasing
            )
        )
    }
    AnimatedVisibility(
        visible = visible,
        enter = enter,
        exit = exit,
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            for (icon in TodoIcon.entries) {
                val isSelected = selectedIcon == icon
                val selectedColor = MaterialTheme.colorScheme.primary
                Column(modifier = Modifier.clickable { onIconSelected(icon) }) {
                    Icon(
                        imageVector = icon.imageVector,
                        contentDescription = icon.desc,
                        tint = if (isSelected) selectedColor else LocalContentColor.current.copy(
                            alpha = 0.5f
                        )
                    )
                    Box(
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .height(2.dp)
                            .width(icon.imageVector.defaultWidth)
                            .background(if (isSelected) selectedColor else Color.Transparent)
                    )
                }
            }
        }
    }
}


// 输入框背景
@Composable
fun TodoItemInputBackground(
    modifier: Modifier = Modifier,
    elevation: Boolean,
    content: @Composable () -> Unit,
) {
    val animateElevation by animateDpAsState(
        if (elevation) 1.dp else 0.dp,
        TweenSpec(durationMillis = 300),
        label = ""
    )
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f),
        shadowElevation = animateElevation,
    ) {
        Column(
            modifier = Modifier.animateContentSize(TweenSpec(300))
        ) {
            content()
        }
    }
}
