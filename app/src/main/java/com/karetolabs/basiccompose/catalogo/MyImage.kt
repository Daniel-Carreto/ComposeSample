package com.karetolabs.basiccompose.catalogo

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.karetolabs.basiccompose.R

@Preview(showBackground = true)
@Composable
fun TestMyImage() {
    //MyImage()
    //MyImageAdvance()
    MyIcon()
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "launcher background",
        alpha = 0.5f
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "launcher background",
        //modifier = Modifier.clip(RoundedCornerShape(25.dp))
        modifier = Modifier
            .clip(androidx.compose.foundation.shape.CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Default.Add, "Add", tint = Color.Blue)
}