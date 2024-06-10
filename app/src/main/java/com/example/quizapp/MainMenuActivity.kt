package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizapp.data.Question
import com.example.quizapp.data.createQuestions
import com.example.quizapp.ui.theme.QuizAppTheme

class MainMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val username = GlobalVariables.userName
        setContent {
            QuizAppTheme {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally){
                        Text(
                            text = "QUESTIONADOS",
                            fontFamily = GlobalVariables.font_logo
                        )
                        Text(
                            text = "Bem vindo(a) $username!",
                            fontFamily = GlobalVariables.font_body)
                    }
                    Column (horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Selecione um tema para jogar!", fontFamily = GlobalVariables.font_body)
                        Button(
                            onClick = { /*TODO*/ }
                        ) {
                            Text("Aleatório")
                        }
                        Button(
                            onClick = {
                                val questions = createQuestions()
                                val randomQuestion = questions.random()
                                val navigate = Intent(this@MainMenuActivity, QuizActivity::class.java).apply {
                                    putExtra("question", randomQuestion)
                                    putExtra("correctAnswersCount", 0)
                                }
                                startActivity(navigate)
                                }
                        ) {
                            Text("Geografia")
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text("Ciências")
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text("História")
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text("Esportes")
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text("Artes")
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text("Entreterimento")
                        }
                    }
                }
            }
        }
    }
}