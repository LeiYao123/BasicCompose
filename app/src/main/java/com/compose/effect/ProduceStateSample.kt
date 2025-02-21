package com.compose.effect

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

val imgs = listOf(
    "https://img2.baidu.com/it/u=3097253230,865203483&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1449",
    "https://img0.baidu.com/it/u=3154286990,570329724&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=1422",
    "https://ww4.sinaimg.cn/mw690/8adbca3bly1huzy9wmqxhj20zk1kwajy.jpg"
)


@Composable
fun ProduceStateSample() {
    var index by remember { mutableIntStateOf(0) }

    val state by produceState(initialValue = "Loading...") {
        // 这里可以执行异步任务
        value = "Data Loaded"
    }


    Column {
        Button(onClick = {}) {
            index %= imgs.size
            if (++index >= imgs.size) index = 0
        }


    }
}
