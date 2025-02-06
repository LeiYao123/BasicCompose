
package com.compose

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.compose.ui.theme.BasicComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var view: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            BasicComposeTheme  { Conversations(SampleData.conversationSample) }
        }
    }
}

@Composable
fun MessageCard(msg: Message, index: Int) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.img),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            label = "surfaceColor",
        )
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text("$index - ${msg.author}", color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
                color = surfaceColor,
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 2.dp,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    msg.body,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                )
            }
        }
    }
}


@Composable
fun Conversations(messages: List<Message>) {
    val state = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    coroutineScope.launch {
                        state.animateScrollToItem(messages.size - 1)
                    }
                }
            ) {
                Text("Scroll Bottom")
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    coroutineScope.launch {
                        state.animateScrollToItem(0)
                    }
                }
            ) {
                Text("Scroll Top")
            }
            Icon(

                Icons.Rounded.ShoppingCart,
                contentDescription = "ShoppingCart",
                modifier = Modifier.size(40.dp).weight(1f),
                tint= MaterialTheme.colorScheme.primary
            )
        }
        LazyColumn(state = state) {
            items(messages.size) { index -> MessageCard(messages[index], index) }
        }
    }
    // 支持索引及项目
    // LazyColumn { itemsIndexed(messages) { _, m -> MessageCard(m) } }
}



// 数据类，相当于 flutter 里面的数据模型
data class Message(val author: String, val body: String)



@Composable
fun MyColumn(modifier: Modifier = Modifier, content: @Composable () -> Unit) {

}



// 用不着的函数，写着玩的
// =====================================================================================================
fun helloX(action: () -> Unit) {
    // 执行传入的 Lambda 表达式
    action()

    // 额外的东西。。。
    fun applyOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

    val result = applyOperation(5, 3) { x, y -> x * y }  // 传递 Lambda
    println(result)  // 输出：15
}

fun helloY(name: String, action: () -> Unit) {
    println("name")
    // 执行传入的 Lambda 表达式
    action()
    helloLambdaFun()
}

// 普通匿名函数
val helloLambdaFun: () -> Unit = {
    println("helloNormalFun")
}

val sum: (Int, Int) -> Int = { x, y ->
    x + y
}

