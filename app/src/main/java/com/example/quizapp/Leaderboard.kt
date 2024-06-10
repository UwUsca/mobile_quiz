package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.quizapp.database.AppDatabase
import com.example.quizapp.database.Score
import com.example.quizapp.ui.theme.QuizAppTheme
import kotlinx.coroutines.launch

class Leaderboard : ComponentActivity() {
    private lateinit var db: AppDatabase

    private val scores = mutableListOf<Pair<String, Int>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "quiz-database"
        ).build()
        val score = intent.getIntExtra("score", 0)
        val username = GlobalVariables.userName

        lifecycleScope.launch {
            db.scoreDao().insert(Score(username = username, score = score))
            val scores = db.scoreDao().getTopScores()
            setContent {
                QuizAppTheme {
                    Leaderboarding(score,scores)
                }
            }
        }
    }
}

@Composable
fun Leaderboarding(score:Int,scores: List<Score>) {
    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 10.dp)
        ) {
            Button(
                onClick = { showDialog.value = true },
                contentPadding = PaddingValues(),
                modifier = Modifier
                    .size(height = 50.dp, width = 50.dp)
                    .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
                shape = RoundedCornerShape(15)
            ) {
                Text(text = "?", fontSize = 30.sp)
            }
            Text(
                text = "RANKING",
                fontFamily = GlobalVariables.font_logo,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
            Button(onClick = {
                val navigateToMainMenu = Intent(context, MainMenuActivity::class.java)
                context.startActivity(navigateToMainMenu)
            },
                contentPadding = PaddingValues(),
                modifier = Modifier
                    .size(height = 50.dp, width = 50.dp)
                    .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
                shape = RoundedCornerShape(15)){
                Text(text = "X", fontSize = 30.sp)
            }
        }
        Column {
            Text(text = "Sua pontuação:")
            Text(text = "$score")
        }
        Column {
            Text(text = "Ranking:")
            scores.forEachIndexed { index, score ->
                Text(text = "${index + 1}. ${score.username} - ${score.score}")
            }
        }

        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = { showDialog.value = false },
                title = {
                    Text(text = "Como funciona a pontuação?")
                },
                text = {
                    Text("Os pontos são contabilizados pelo seguinte calculo:\nPontuação = PontuaçãoAnterior + (TempoRestante * 10)")
                },
                confirmButton = {
                    Button(
                        onClick = { showDialog.value = false }
                    ) {
                        Text("Entendi!")
                    }
                }
            )
        }
    }

}