package com.karetolabs.basiccompose.catalogo

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.exp

@Preview
@Composable
fun MyDropDownMenuBoxPreview() {
    MyDropDownMenuBox()
}

@Preview()
@Composable
fun MyDropDownMenuBox() {
    var state by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("Tiramisu", "Chocolate", "Cafe", "Fruta")

    Row {
        Column(modifier = Modifier.padding(20.dp)) {
            OutlinedTextField(
                value = state,
                onValueChange = { state = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .fillMaxWidth()
            )
            DropdownMenu(
                modifier = Modifier.fillMaxWidth(),
                expanded = expanded,
                onDismissRequest = { expanded = false }) {
                desserts.forEach { dessert ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        state = dessert
                    }, content = {
                        Text(text = dessert)
                    })
                }
            }
        }
    }
}
