package com.karetolabs.basiccompose.catalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Preview
@Composable
fun MySwitchPreview() {
    MySwitch()
}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }
    Switch(checked = state,
        onCheckedChange = {
        state = !state
    },
    enabled = true,
    colors = SwitchDefaults.colors(
        uncheckedThumbColor = Color.Red,
        checkedThumbColor = Color.Green,
        uncheckedTrackColor = Color.Magenta,
        checkedTrackColor = Color.Cyan,
        checkedTrackAlpha = 0.1f,
        uncheckedTrackAlpha = 0.1f,
        disabledCheckedThumbColor = Color.Yellow,
        disabledCheckedTrackColor = Color.Yellow,
        disabledUncheckedThumbColor = Color.Yellow,
        disabledUncheckedTrackColor = Color.Yellow
    ))
}
