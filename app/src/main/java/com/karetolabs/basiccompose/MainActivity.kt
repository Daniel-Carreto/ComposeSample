package com.karetolabs.basiccompose

import MyBadgeBox
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.karetolabs.basiccompose.catalogo.*
import com.karetolabs.basiccompose.ui.theme.BasicComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    //MixLayoutRecompostion()
                    //MyTextFieldComponent()
                    //MyTextFieldOutlined()
                    //MyButton()
                    //MyProgress()
                    //MySwitch()
                    //MyCheckbox()
                    //MyCheckBoxWithText()

                    /*val myOptions = getOptions(titles = listOf("Pikachu", "Arale", "Goku"))
                     Column {
                         myOptions.forEach {
                             MyCheckBoxDynamic(it)
                         }
                         MyCheckBoxWithText()
                     }
                    MyTriStatusCheckBox()*/
                    // MyRadioButton()

                    /*var selected by remember {
                        mutableStateOf("Dany")
                    }
                    MyRadioButtonList(selected) { selected = it }*/

                    //MyCard()
                    //MyBadgeBox()
                    //MyDivider()
                    //MyDropDownMenuBox()
                    //MyBasicSlider()
                    //MyAdvanceSlider()
                    //MyRangeSlider()
                    //MyDialog()
                    //MyCustomDialog()
                    //MyCustomDialogAdvance()
                    //MyCustomRadioDialogAdvance()
                    //SimpleRecyclerView()
                    //SuperHeroView()
                    //SuperHeroGridView()
                    //SuperHeroControlView()
                    //SuperHeroStickyView()
                    MyScaffoldExample()
                }
            }
        }
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { status = it }
        )
    }
}

@Preview(
    name = "Uno",
    heightDp = 50,
    widthDp = 230,
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_5X
)
@Composable
fun MyTestSuperText() {
    Greeting(name = "Dany")
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.apply {
        //height(50.dp)
        //width(300.dp)
        fillMaxHeight() //Todo altura fill_parent/match_parent
        fillMaxWidth() //Todo anchura fill_parent/match_parent
        fillMaxSize() //Todo Ancho y todo alto
        //Nos olvidaremos de los margenes

    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicComposeTheme {
        Greeting("Android")
    }
}
