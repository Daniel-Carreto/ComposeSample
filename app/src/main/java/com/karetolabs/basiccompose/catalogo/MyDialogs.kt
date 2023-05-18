package com.karetolabs.basiccompose.catalogo

import android.icu.text.CaseMap.Title
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.karetolabs.basiccompose.R
import java.nio.file.WatchEvent

@Composable
fun DialogWidget(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() }, title = {
            Text(text = "Título")
        }, text = {
            Text(text = "Descripcion")
        }, confirmButton = {
            Button(onClick = { onConfirm() }) {
                Text(text = "Aceptar")
            }
        }, dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text(text = "Cancelar")
            }
        })
    }
}

@Composable
fun MyDialog() {
    var show by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar dialogo")
        }
        DialogWidget(
            show = show,
            onDismiss = { show = false },
            onConfirm = { Log.i("MyDialog", "click") })
    }
}

@Composable
fun DialogCustomWidget(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esta es un ejemplo")
            }
        }
    }
}


@Composable
fun MyCustomDialog() {
    var show by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar dialogo")
        }
        DialogCustomWidget(show = show, onDismiss = { show = false })
    }
}

@Composable
fun DialogAdvanceCustomWidget(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                TitleDialog(title = "Ejemplo avanzado")
                AccountItemDialog(email = "ejemplo@gmail.com", drawable = R.drawable.ic_avatar)
                AccountItemDialog(email = "ejemplo@gmail.com", drawable = R.drawable.ic_avatar)
                AccountItemDialog(email = "ejemplo@gmail.com", drawable = R.drawable.ic_avatar)
            }
        }
    }
}

@Composable
fun TitleDialog(title: String, modifier: Modifier = Modifier.padding(12.dp)) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun AccountItemDialog(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
                .background(color = Color.Red)
        )

        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MyCustomDialogAdvance() {
    var show by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar dialogo")
        }
        DialogAdvanceCustomWidget(show = show, onDismiss = { show = false })
    }
}

//Confirmation

@Composable
fun MyCustomRadioDialogAdvance() {
    var show by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar dialogo")
        }
        ConfirmationDialogAdvanceCustomWidget(show = show, onDismiss = { show = false })
    }
}

@Composable
fun ConfirmationDialogAdvanceCustomWidget(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                TitleDialog(title = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
                var status by remember {
                    mutableStateOf("")
                }
                MyRadioButtonList(name = status, onItemSelected = {
                    status = it
                })
                Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
                Row(Modifier.align(Alignment.End)) {
                    TextButton(onClick = {}) {
                        Text(text = "Cancelar")
                    }
                    TextButton(onClick = {}) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}




