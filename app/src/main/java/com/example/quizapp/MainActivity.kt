package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizapp.ui.theme.QuizAppTheme

object GlobalVariables {
    var userName by mutableStateOf("")
    val font_body = FontFamily(Font(R.font.font_body, FontWeight.Normal))
    val font_logo = FontFamily(Font(R.font.font_logo, FontWeight.Normal))
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val setUserName = { newUserName: String -> GlobalVariables.userName = newUserName }
            var textFieldValue by remember { mutableStateOf("") }

            QuizAppTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "QUESTIONADOS", fontFamily = GlobalVariables.font_logo)
                    Text(text = "Insira seu nome para continuar!", fontFamily = GlobalVariables.font_body)
                    TextField(
                        value = textFieldValue,
                        onValueChange = {textFieldValue = it},
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Button(onClick = {
                        setUserName(textFieldValue)
                        val navigate = Intent(this@MainActivity, MainMenuActivity::class.java)
                        startActivity(navigate)
                    }) {
                        Text(text = "Continuar")
                    }
                }
            }
        }
    }
}