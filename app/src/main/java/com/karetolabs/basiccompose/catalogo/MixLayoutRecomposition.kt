package com.karetolabs.basiccompose.catalogo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Preview(showBackground = true)
@Composable
fun TestMixLayoutRecompostion() {
    MixLayoutRecompostion()
}

@Composable
fun MixLayoutRecompostion() {
    var counter by rememberSaveable{ mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsa")
        }
        Text(text = "He sido pulsado $counter veces")
    }
}

@Composable
fun MixLayoutRecompostionSavable() {
    val counter = remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter.value += 1 }) {
            Text(text = "Pulsa")
        }
        Text(text = "He sido pulsado ${counter.value} veces")
    }
}
