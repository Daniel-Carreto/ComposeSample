import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Icon
import androidx.compose.material.Text
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

@Preview
@Composable
fun MyBadgeBoxPreview() {
    MyBadgeBox()
}

@Preview()
@Composable
fun MyBadgeBox() {
    var state by rememberSaveable { mutableStateOf(true) }
    Column(modifier = Modifier.height(200.dp).width(200.dp)) {
        BadgedBox(modifier = Modifier.padding(16.dp), badge = {
            Badge(content = {
                Text(text = "1")
            })
        }, content = {
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
        })
    }
}
