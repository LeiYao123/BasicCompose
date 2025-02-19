package com.compose.todo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CropSquare
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.RestoreFromTrash
import androidx.compose.ui.graphics.vector.ImageVector
import java.util.UUID
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

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


interface InterfaceTest {
    var count: Int

    fun plus(num: Int) {
        count += num;
    }
}

class Impl : InterfaceTest {
    override var count: Int = 0

    override fun plus(num: Int) {
        super.plus(num)
        println("invoke plus")
    }
}


// 委托对象
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you delegate '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
         println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class DelegateTest {
    var p: String by Delegate()

    val friends by lazy {
        loadFriends()
    }

    private fun loadFriends(): List<String> {
        return listOf("大桔子", "大香蕉")
    }
}

class ObserverTest(salary: Int = 0) {
    var salary: Int by Delegates.observable(salary) {
        property, oldValue, newValue ->
        println("---property-$property changed $oldValue -> $newValue")
    }
}
//val o = ObserverTest(100)
//o.salary = 1000


data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}



fun testLoopBreak () {
    loop@ for (i in 1..5) {
        for (j in 1..5) {
            if (j == 2) {
                break@loop // 此处会退出内层循环
            }
            println("i=$i, j=$j")
        }
    }
}

fun testLoopForEach() {
    val list = listOf("a", "b", "c")
    run loop@{
        list.forEach {
            if (it == "b") {
                // 此处和经典循环里的 break 一样，只会退出当前循环
                // 只 rerun 会退出整个函数
                return@loop
            }
            println(it)
        }
    }
    println("end")
}

fun main() {
    testLoopForEach()
}