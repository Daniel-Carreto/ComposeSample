package com.karetolabs.basiccompose.catalogo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.util.toRange

@Preview
@Composable
fun MyBasicSliderPreview() {
    MyBasicSlider()
}

@Preview()
@Composable
fun MyBasicSlider() {
    var state by rememberSaveable { mutableStateOf(0f) }

    Row {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Slider(value = state, onValueChange = {
                state = it
            })
            Text(text = state.toString())
        }
    }
}

@Composable
fun MyAdvanceSlider() {
    var state by rememberSaveable { mutableStateOf(0f) }
    var completeValue by rememberSaveable { mutableStateOf("") }

    Row {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Slider(
                value = state,
                onValueChange = {
                    state = it
                },
                valueRange = 0f..100f,
                steps = 9,
                onValueChangeFinished = {
                    completeValue = state.toString()
                },
            )
            Text(text = completeValue)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider(){
    var currentRange by remember {
        mutableStateOf(0f..100f)
    }

    Column {
        RangeSlider(values = currentRange, onValueChange = {
            currentRange = it
        }, valueRange = 0f..40f, steps = 9)
        Text(text = "Valor inferior ${currentRange.start}")
        Text(text = "Valor Superior ${currentRange.endInclusive}")
    }
}

