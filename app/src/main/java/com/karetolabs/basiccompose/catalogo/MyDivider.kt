package com.karetolabs.basiccompose.catalogo

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyDividerPreview() {
    MyDivider()
}

@Preview()
@Composable
fun MyDivider() {
    var state by rememberSaveable { mutableStateOf(true) }
    Column(modifier = Modifier
        .height(200.dp)
        .width(200.dp)) {
        Divider(modifier = Modifier.fillMaxWidth().padding(16.dp), color = Color.Red)
    }
}
