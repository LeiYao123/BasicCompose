package com.compose.effect

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun DisposableEffectSample(onBack: () -> Unit) {
    var checked by remember { mutableStateOf(false) }
    Column {
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = checked,
                onCheckedChange = { checked = it },
            )
            Text("${if (checked) "Not" else ""} Add Back Callback")
        }
    }
    BackHandler(enabled = checked) {
        onBack()
        Log.d("DisposableEffectSample", "Back button pressed")
    }
}