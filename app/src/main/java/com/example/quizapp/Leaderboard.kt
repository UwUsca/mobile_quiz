package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.quizapp.database.AppDatabase
import com.example.quizapp.database.Score
import com.example.quizapp.ui.theme.BackgroundColor
import com.example.quizapp.ui.theme.ColorCrown
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.ui.theme.RankingRed
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
    val brush = Brush.sweepGradient(GlobalVariables.main_colors)
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
    ){}
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 10.dp)
        ) {
            Button(onClick = {
                val navigateToMainMenu = Intent(context, MainMenuActivity::class.java)
                context.startActivity(navigateToMainMenu)
            },
                colors = ButtonDefaults.buttonColors(RankingRed),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                contentPadding = PaddingValues(),
                modifier = Modifier
                    .size(height = 50.dp, width = 50.dp)
                    .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
                    ,
                shape = RoundedCornerShape(15)){
                Image(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier.size(30.dp)
                )
            }
            Text(
                text = "RANKING",
                fontFamily = GlobalVariables.font_logo,
                color = Color.White,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color(0x55a0a3a5),
                        offset = Offset(5.0f, 10.0f),
                        blurRadius = 7f
                    )
                ),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 35.sp
            )
            Button(
                onClick = { showDialog.value = true },
                colors = ButtonDefaults.buttonColors(Color(0xFFe59311)),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                contentPadding = PaddingValues(),
                modifier = Modifier
                    .size(height = 50.dp, width = 50.dp)
                    .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
                shape = RoundedCornerShape(15)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.question),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
        }

        Box(modifier = Modifier
            .padding(16.dp)
            .size(width = 300.dp, height = 150.dp)
            .clip(RoundedCornerShape(25.dp))){
            Canvas(modifier = Modifier
                .matchParentSize()
                .background(
                    BackgroundColor
                )) {
                rotate(degrees = rotation) {
                    drawCircle(
                        brush = brush,
                        radius = size.width,
                        blendMode = BlendMode.SrcIn,
                    )
                }
                drawRoundRect(
                    color = BackgroundColor,
                    topLeft = Offset(5.dp.toPx(), 5.dp.toPx()),
                    size = Size(
                        width = size.width - 10.dp.toPx(),
                        height = size.height - 10.dp.toPx()
                    ),
                    cornerRadius = CornerRadius(
                        x = 20.dp.toPx(),
                        y = 20.dp.toPx()
                    )
                )
            }
            Column(modifier = Modifier.matchParentSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                TextScore(text = "SUA PONTUACAO", 66f)
                TextScore(text = "$score", 200f)
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(ScrollState(0))
        ) {
            scores.forEachIndexed { index, score ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        color = if (index == 0) Color(0xFFf9f0c7) else Color(0xFFeff3f6)
                    )
                    .drawBehind {
                        val strokeWidth = 1 * density
                        val y = size.height - strokeWidth / 2
                        drawLine(
                            Color.LightGray,
                            Offset(0f, y),
                            Offset(size.width, y),
                            strokeWidth
                        )
                    }
                    .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Image(painter = painterResource(id = R.drawable.medal),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(
                                if (index == 0) Color(0xFFe5c436) else Color(0xFFccd7e5)
                            ),
                            modifier = Modifier.size(40.dp)
                        )
                        Text(
                            text = score.username,
                            modifier = Modifier.padding(start = 10.dp),
                            fontFamily = GlobalVariables.font_logo,
                            fontSize = 19.sp,
                            color = if (index == 0) Color(0xFFbda143) else Color(0xFFa9b1ba)
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.drawable.crown),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(
                                if (index == 0) Color(0xFFe5c436) else Color(0xFFccd7e5)
                            ),
                            modifier = Modifier.size(20.dp)
                        )
                        Text(text = "${score.score}",
                            color = if (index == 0) Color(0xFFbc9633) else Color(0xFF9b9faf),
                            fontFamily = GlobalVariables.font_logo,
                            fontSize = 18.sp,
                        )
                    }

                }

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

@Composable
fun TextScore(text: String, txtSize: Float){
    val font_logo_alt = ResourcesCompat.getFont(LocalContext.current, R.font.mikadobold)
    Box(modifier = Modifier
        .height(60.dp)
        .padding(bottom = 10.dp)){
        Canvas(modifier = Modifier.matchParentSize()) {
            val textPaintStroke = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.STROKE
                textSize = txtSize
                color = android.graphics.Color.BLACK
                strokeWidth = 5f
                strokeMiter= 5f
                strokeJoin = android.graphics.Paint.Join.ROUND
                typeface = font_logo_alt
            }
            val textPaint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.FILL
                textSize = txtSize
                color = android.graphics.Color.WHITE
                typeface = font_logo_alt
            }
            val shadowPaint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.FILL
                textSize = txtSize
                color = android.graphics.Color.parseColor("#FF000000")
                typeface = font_logo_alt
            }
            val textWidth = textPaint.measureText(text)
            val x = (size.width - textWidth) / 2
            val y = (size.height / 2) - ((textPaint.descent() + textPaint.ascent()) / 2)
            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    text,
                    x,
                    y + 5,
                    shadowPaint
                )
                it.nativeCanvas.drawText(
                    text,
                    x,
                    y,
                    textPaintStroke
                )

                it.nativeCanvas.drawText(
                    text,
                    x,
                    y,
                    textPaint
                )
            }
        }
    }
}