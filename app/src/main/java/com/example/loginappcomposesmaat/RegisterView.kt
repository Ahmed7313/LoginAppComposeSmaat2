package com.example.loginappcomposesmaat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginappcomposesmaat.utils.Greeting
import com.example.loginappcomposesmaat.utils.mainText
import com.example.myapplication.ui.theme.*

class RegisterView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppComposeSmaatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun TextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(modifier = Modifier
        .background(color = Color.White)
        .fillMaxWidth(1f)
        .height(100.dp)
        .padding(16.dp),
        value = text,
        label = { Text(text = "Enter you name") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        shape = RoundedCornerShape(8.dp),
        onValueChange = { it ->
            text = it
        }
    )
}

@Preview(showBackground = true)
@Composable
fun registerView(){
    Surface() {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Red800),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Greeting( "Welcome to", "Platraw ...")
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
                        mainText(modifier = Modifier,
                            "Register",
                            "Start your journey with Platrow...")
                        TextField()
                        PasswordField()
                        LoginButton ()
                        OTPLogin()
                    }
                }
            }
        }
    }
}