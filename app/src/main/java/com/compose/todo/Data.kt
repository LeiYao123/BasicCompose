package com.compose.todo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CropSquare
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.RestoreFromTrash
import androidx.compose.ui.graphics.vector.ImageVector
import java.util.UUID

data class TodoItem(
    val task: String,
    val icon: TodoIcon = TodoIcon.Default,
    val id: UUID = UUID.randomUUID()
)


// 枚举初始化: 内部的每一个子项都要有 imageVector 和 desc 两个参数
enum class TodoIcon(val imageVector: ImageVector, val desc: String) {
    Square(Icons.Default.CropSquare, "Expand"),
    Done(Icons.Default.Done, "Done"),
    Event(Icons.Default.Event, "Event"),
    Privacy(Icons.Default.PrivacyTip, "Privacy"),
    Trash(Icons.Default.RestoreFromTrash, "Restore");
    companion object {
        val Default = Square
    }
}




// 枚举匿名类实现，枚举实现接口
enum class Pay {
    ABC {
        override fun pay() {
            println("农行支付")
        }
    },
    CBC {
        override fun pay() {
            println("建行支付")
        }
    },
    ICBC {
        override fun pay() {
            println("工行支付")
        }
    };

    abstract fun pay()
}
