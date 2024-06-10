package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import com.example.quizapp.data.Question
import com.example.quizapp.data.createQuestions
import com.example.quizapp.ui.theme.QuizAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.room.RoomDatabase

class QuizActivity : ComponentActivity() {
    private var correctAnswersCount by mutableStateOf(0)
    private var score by mutableStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        correctAnswersCount = intent.getIntExtra("correctAnswersCount", 0)
        score = intent.getIntExtra("score", 0)
        val question = intent.getSerializableExtra("question") as Question

        setContent {
            QuizAppTheme {
                QuizScreen(question) {result, timeLeft ->
                    if (result){
                        correctAnswersCount++
                        score += timeLeft * 10
                        if(correctAnswersCount >= 10){
                            navigateToLeaderboard(correctAnswersCount, score)
                        } else {
                            val questions = createQuestions()
                            val nextQuestion = questions.random()
                            navigateToNextQuestion(nextQuestion)
                        }
                    } else {
                        navigateToLeaderboard(correctAnswersCount, score)
                    }
                }
                Column {
                    Text(text = "$correctAnswersCount")
                    Text(text = "$score")
                }
            }
        }
    }

    private fun navigateToLeaderboard(correctAnswersCount: Int, score: Int) {
        val navigateToRanking = Intent(this, Leaderboard::class.java).apply {
            putExtra("correctAnswersCount", correctAnswersCount)
            putExtra("score", score)
        }
        startActivity(navigateToRanking)
        finish()
    }

    private fun navigateToNextQuestion(question: Question) {
        val navigate = Intent(this, QuizActivity::class.java).apply {
            putExtra("question", question)
            putExtra("correctAnswersCount", correctAnswersCount)
            putExtra("score", score)
        }
        startActivity(navigate)
        finish()
    }
}

@Composable
fun QuizScreen( question: Question, onAnswer: (Boolean, Int) -> Unit) {
    var secondsLeft by remember { mutableStateOf(16) }
    var showMessage by remember { mutableStateOf(false) }
    var messageText by remember { mutableStateOf("") }

    DisposableEffect(Unit) {
        val timer = object : CountDownTimer(16000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                secondsLeft = (millisUntilFinished / 1000).toInt()
            }
            override fun onFinish() {
                messageText = "Tempo esgotado"
                showMessage = true
            }
        }
        timer.start()
        onDispose {
            timer.cancel()
        }
    }

    if(showMessage){
        LaunchedEffect(Unit) {
            delay(2000) // Aguardar 2 segundos
            showMessage = false
            onAnswer(messageText == "Acertou!", secondsLeft)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f)),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = messageText, fontSize = 24.sp, color = Color.Black)
            }
        }
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(painter = painterResource(id = R.drawable.crown), contentDescription = "")
                Text(text = "$secondsLeft")
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(painter = painterResource(id = question.imageId), contentDescription = "", modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), contentScale = ContentScale.Crop)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 20.dp)
            ) {
                Text(
                    text = question.question,
                    textAlign = TextAlign.Center,
                    fontFamily = GlobalVariables.font_body
                )
            }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                question.options.forEach{ option ->
                    Button(onClick = {
                        val isCorrect = option == question.answer
                        messageText = if (isCorrect) "Acertou!" else "Errou!"
                        showMessage = true
                    }) {
                        Text(text = option)
                    }
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuizAppTheme {

    }
}