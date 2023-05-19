package com.karetolabs.basiccompose.instagram.login

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.karetolabs.basiccompose.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var isLoginEnable by rememberSaveable {
        mutableStateOf(false)
    }
    Column(modifier = modifier) {
        ImageLogoHeader(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        Email(email) {
            email = it
            isLoginEnable = enableLogin(email, password)
        }
        Spacer(modifier = Modifier.size(4.dp))
        Password(password) {
            password = it
            isLoginEnable = enableLogin(email, password)
        }
        ForgotPassword(Modifier.align(Alignment.End))
        LoginButton(isLoginEnable)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        SocialLogin()
    }
}

@Composable
fun ImageLogoHeader(modifier: Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(id = R.drawable.ic_avatar),
        contentDescription = "Logo"
    )
}

@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(text = "Email")
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0XFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        maxLines = 1,
        singleLine = true,
        placeholder = {
            Text(text = "Password")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = image, contentDescription = "toggle password icon")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0XFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9)
    )
}

@Composable
fun LoginButton(loginEnable: Boolean) {
    Button(
        onClick = {},
        enabled = loginEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF4EA8E9),
            disabledBackgroundColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Log In")
    }
}

fun enableLogin(email: String, password: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
            password.length > 6
}

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            modifier = Modifier
                .background(Color(0xFF9F9F9F))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            fontSize = 12.sp,
            modifier = Modifier.padding(18.dp),
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        Divider(
            modifier = Modifier
                .background(Color(0xFF9F9F9F))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun SocialLogin() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_avatar),
            contentDescription = "Social login facebook",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Continuer as Dany",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp),
            color = Color(0xFF4EA8E9)
        )
    }
}
