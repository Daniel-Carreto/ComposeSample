package com.karetolabs.basiccompose.catalogo

import android.widget.CheckBox
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyCheckboxPreview() {
    MyCheckbox()
}

@Composable
fun MyCheckbox() {
    var state by rememberSaveable { mutableStateOf(true) }
    Checkbox(
        checked = state,
        onCheckedChange = {
            state = !state
        },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )
}


@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(true) }
    Row {
        Checkbox(
            checked = state,
            onCheckedChange = {
                state = !state
            },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Yellow,
                checkmarkColor = Color.Blue
            )
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Ejemplo 1 ")

    }
}

@Composable
fun MyCheckBoxDynamic(checkInfo: CheckInfo) {
    Row {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Yellow,
                checkmarkColor = Color.Blue
            )
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = checkInfo.title)

    }
}

@Composable
fun MyTriStatusCheckBox(){
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when(status){
            ToggleableState.On -> {
                ToggleableState.Off
            }
            ToggleableState.Off ->  {
                ToggleableState.Indeterminate
            }
            ToggleableState.Indeterminate -> {
                ToggleableState.On
            }
        }
    })
}
