package com.karetolabs.basiccompose.catalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun MyRadioButtonPreview() {
    MyRadioButton()
}

@Composable
fun MyRadioButton() {
    var state by rememberSaveable { mutableStateOf(true) }
    Row(modifier = Modifier.fillMaxWidth()) {
        RadioButton(
            selected = state,
            onClick = {

            },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledColor = Color.Green
            )
        )
        Text(text = "Ejemplo Button")
    }
}


@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row() {
            RadioButton(
                selected = name == "Dany",
                onClick = {
                    onItemSelected("Dany")
                },
                enabled = true,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Yellow,
                    disabledColor = Color.Green
                )
            )
            Text(text = "Dany")
        }
        Row() {
            RadioButton(
                selected = name == "Tony",
                onClick = {
                    onItemSelected("Tony")
                },
                enabled = true,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Yellow,
                    disabledColor = Color.Green
                )
            )
            Text(text = "Tony")
        }
        Row() {
            RadioButton(
                selected = name == "Michi",
                onClick = {
                    onItemSelected("Michi")
                },
                enabled = true,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Yellow,
                    disabledColor = Color.Green
                )
            )
            Text(text = "Michi")
        }
        Row() {
            RadioButton(
                selected = name == "Lucy",
                onClick = {
                    onItemSelected("Lucy")
                },
                enabled = true,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Yellow,
                    disabledColor = Color.Green
                )
            )
            Text(text = "Lucy")
        }
    }
}