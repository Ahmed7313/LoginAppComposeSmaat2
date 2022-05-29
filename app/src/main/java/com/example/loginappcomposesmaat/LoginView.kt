package com.example.loginappcomposesmaat

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.*

class LoginView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppComposeSmaatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    loginFullView(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LoginAppComposeSmaatTheme {
        loginFullView(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun Greeting2() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(
            top = 160.dp,
            start = 16.dp,
            end = 24.dp
        )) {
        Text(text = "Welcome",
            color = Color.White,
            fontSize = 48.sp,
            modifier = Modifier.padding(8.dp))
        Text(text = "Back...!",
            color = Color.White,
            fontSize = 48.sp,
            modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginText(
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Surface(
            modifier = modifier.semantics { heading() }
        ) {
            Text(
                text = stringResource(R.string.login_with_pass),
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                fontSize = 24.sp
            )
        }
        Surface(
            modifier = modifier.semantics { heading() }
        ) {
            Text(
                text = stringResource(R.string.enter_pass_text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                style = MaterialTheme.typography.body2,
                fontSize = 16.sp
            )
        }
    }
}



@Composable
fun PasswordField(
) {
    var password by  rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisiblity by remember {
        mutableStateOf(false)
    }

    val icon = if (passwordVisiblity)
        painterResource(id = R.drawable.design_icon_visibility)
    else
        painterResource(id = R.drawable.design_icon_visibility_off)
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(16.dp),
        value = password,
        onValueChange ={ password = it},
        placeholder = { Text(text = "Password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        shape = RoundedCornerShape(8.dp),
        label = { Text(text = "Password") },
        trailingIcon = {
            IconButton(onClick = { passwordVisiblity = !passwordVisiblity }) {
                Icon(
                    painter = icon ,
                    contentDescription = "Icon Visibility",
                    modifier = Modifier.size(24.dp))
            }
        },
        visualTransformation = if (passwordVisiblity) VisualTransformation.None
        else PasswordVisualTransformation(),
    )

}

@Composable
fun OTPLogin(){
        Text(text = "LOGIN WITH OTP",
            color = Red300,
            modifier = Modifier
                .padding(start = 8.dp)
        )
}

@Composable
fun LoginButton (){
    OutlinedButton(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(100.dp)
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Red700) ) {
        Text(text = "LOGIN",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )

    }
}

@Composable
fun loginFullView(modifier: Modifier){

    Column (modifier =
    Modifier
        .background(color = Red800)
        .fillMaxWidth()
        .fillMaxHeight()){
        Greeting2()
        Card(
            Modifier.fillMaxSize(),
            elevation = 4.dp,
            backgroundColor = Red700,
            shape = RoundedCornerShape(
                topStart = 24.dp,
                topEnd = 24.dp)
        ){
            Card(modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp)
            ) {
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    LoginText()
                    PasswordField()
                    LoginButton ()
                    OTPLogin()
                }
            }
        }
    }
}