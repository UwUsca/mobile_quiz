package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.EaseInOutBack
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.EaseOutElastic
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import androidx.room.Room
import com.example.quizapp.data.Question
import com.example.quizapp.data.createQuestions
import com.example.quizapp.ui.theme.QuizAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.room.RoomDatabase
import com.example.quizapp.ui.theme.BackgroundColor
import com.example.quizapp.ui.theme.ColorCrown
import com.example.quizapp.ui.theme.GreenCorrect
import com.example.quizapp.ui.theme.MainBlue
import com.example.quizapp.ui.theme.MainGreen
import com.example.quizapp.ui.theme.MainOrange
import com.example.quizapp.ui.theme.MainPink
import com.example.quizapp.ui.theme.MainPurple
import com.example.quizapp.ui.theme.MainRed
import com.example.quizapp.ui.theme.MainYellow
import com.example.quizapp.ui.theme.RedIncorret
import com.example.quizapp.ui.theme.SecondaryBlue
import com.example.quizapp.ui.theme.SecondaryGreen
import com.example.quizapp.ui.theme.SecondaryOrange
import com.example.quizapp.ui.theme.SecondaryPink
import com.example.quizapp.ui.theme.SecondaryRed
import com.example.quizapp.ui.theme.SecondaryYellow
import com.example.quizapp.ui.theme.YellowTime

class QuizActivity : ComponentActivity() {
    private var correctAnswersCount by mutableStateOf(0)
    private var score by mutableStateOf(0)
    private var theme: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        correctAnswersCount = intent.getIntExtra("correctAnswersCount", 0)
        score = intent.getIntExtra("score", 0)
        theme = intent.getStringExtra("theme")
        val question = intent.getSerializableExtra("question") as Question

        setContent {
            QuizAppTheme {
                QuizScreen(question, theme) {result, timeLeft ->
                    if (result){
                        correctAnswersCount++
                        score += timeLeft * 10
                        if(correctAnswersCount >= 10){
                            navigateToLeaderboard(correctAnswersCount, score)
                        } else {
                            val questions = createQuestions(theme)
                            val nextQuestion = questions.random()
                            navigateToNextQuestion(nextQuestion)
                        }
                    } else {
                        navigateToLeaderboard(correctAnswersCount, score)
                    }
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
            putExtra("theme", theme)
        }
        startActivity(navigate)
        finish()
    }
}

data class ThemeConfig(val backgroundColor: Color, val icon: Int, val tint: Color)
fun getThemeConfig(theme: String?): ThemeConfig {
    return when (theme) {
        "Geografia" -> ThemeConfig(MainBlue, R.drawable.geography, SecondaryBlue)
        "Ciências" -> ThemeConfig(MainGreen, R.drawable.science, SecondaryGreen)
        "História" -> ThemeConfig(MainYellow, R.drawable.history, SecondaryYellow)
        "Esportes" -> ThemeConfig(MainOrange, R.drawable.sports, SecondaryOrange)
        "Artes" -> ThemeConfig(MainRed, R.drawable.arts, SecondaryRed)
        "Entretenimento" -> ThemeConfig(MainPink, R.drawable.culture, SecondaryPink)
        else -> ThemeConfig(MainPurple, R.drawable.crown, ColorCrown)
    }
}

@Composable
fun QuizScreen( question: Question, theme: String?, onAnswer: (Boolean, Int) -> Unit) {
    var secondsLeft by remember { mutableStateOf(25) }
    var showMessage by remember { mutableStateOf(false) }
    var messageText by remember { mutableStateOf("") }
    var textColor by remember { mutableStateOf(0xff000000.toInt()) }
    val themeConfig = getThemeConfig(theme)

    DisposableEffect(Unit) {
        val timer = object : CountDownTimer(25000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                secondsLeft = (millisUntilFinished / 1000).toInt()
            }
            override fun onFinish() {
                messageText = "TEMPO ESGOTADO"
                showMessage = true
                textColor = 0xFFf7de48.toInt()
            }
        }
        timer.start()
        onDispose {
            timer.cancel()
        }
    }

    if(showMessage){
        LaunchedEffect(Unit) {
            delay(2000)
            showMessage = false
            onAnswer(messageText == "CORRETO", secondsLeft)
        }


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
            contentAlignment = Alignment.Center
        ) {
            val font_logo_alt = ResourcesCompat.getFont(LocalContext.current, R.font.mikadobold)
            val textPaintStroke = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.STROKE
                textSize = 100f
                color = 0xFFf4ffec.toInt()
                strokeWidth = 5f
                strokeMiter= 5f
                strokeJoin = android.graphics.Paint.Join.ROUND
                typeface = font_logo_alt
            }
            val textPaint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.FILL
                textSize = 100f
                color = textColor
                typeface = font_logo_alt
            }
            val shadowPaint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.FILL
                textSize = 100f
                color = android.graphics.Color.parseColor("#FF000000")
                typeface = font_logo_alt
            }
                val infiniteTransition = rememberInfiniteTransition()
                val scale by infiniteTransition.animateFloat(
                    initialValue = 0f,
                    targetValue = 1f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(durationMillis = 1000, easing = EaseOutElastic),
                                repeatMode = RepeatMode.Reverse
                    ),
                    label = "Scale"
                )
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(scaleX = scale, scaleY = scale),
                onDraw = {
                    val textWidth = textPaint.measureText(messageText)
                    val x = (size.width - textWidth) / 2
                    val y = (size.height / 2) - ((textPaint.descent() + textPaint.ascent()) / 2)
                    drawIntoCanvas {
                        it.nativeCanvas.drawText(
                            messageText,
                            x,
                            y + 5,
                            shadowPaint
                        )
                        it.nativeCanvas.drawText(
                            messageText,
                            x,
                            y,
                            textPaintStroke
                        )

                        it.nativeCanvas.drawText(
                            messageText,
                            x,
                            y,
                            textPaint
                        )
                    }
                }
            )
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor),
        ){}
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    shadowElevation = 3.dp.toPx()
                    shape = GenericShape { size, _ ->
                        moveTo(0f, 0f)
                        lineTo(size.width, 0f)
                        lineTo(size.width, size.height)
                        lineTo(0f, size.height)
                        close()
                    }
                    clip = true
                }
                .background(themeConfig.backgroundColor) //------------------------------------------------------------
                .padding(horizontal = 15.dp, vertical = 15.dp)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = themeConfig.icon),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(themeConfig.tint)
                )
                Timer("$secondsLeft")
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
                .shadow(5.dp, RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 16.dp,
                    bottomStart = 16.dp
                ), clip = true)
                .background(Color.White)
                .padding(horizontal = 25.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = question.question,
                    textAlign = TextAlign.Center,
                    fontFamily = GlobalVariables.font_body,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Column (
                modifier = Modifier.padding(10.dp).fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                question.options.forEach{ option ->
                    Button(onClick = {
                        val isCorrect = option == question.answer
                        messageText = if (isCorrect) "CORRETO" else "INCORRETO"
                        showMessage = true
                        textColor = if (isCorrect) GreenCorrect else RedIncorret
                    },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(Color.White),

                    ) {
                        Text(
                            text = option,
                            textAlign = TextAlign.Center,
                            fontFamily = GlobalVariables.font_body,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                }
            }
        }
    }

}

@Composable
fun Timer(secondsLeft: String){
    val font_logo_alt = ResourcesCompat.getFont(LocalContext.current, R.font.mikadobold)
    Box(modifier = Modifier.padding(end = 10.dp)){
        Canvas(modifier = Modifier.matchParentSize()) {
            val textPaintStroke = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.STROKE
                textSize = 66f
                color = android.graphics.Color.BLACK
                strokeWidth = 5f
                strokeMiter= 5f
                strokeJoin = android.graphics.Paint.Join.ROUND
                typeface = font_logo_alt
            }
            val textPaint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                style = android.graphics.Paint.Style.FILL
                textSize = 66f
                color = android.graphics.Color.WHITE
                typeface = font_logo_alt
            }
            val textWidth = textPaint.measureText(secondsLeft)
            val x = (size.width - textWidth) / 2
            val y = (size.height / 2) - ((textPaint.descent() + textPaint.ascent()) / 2)
            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    secondsLeft,
                    x,
                    y,
                    textPaintStroke
                )

                it.nativeCanvas.drawText(
                    secondsLeft,
                    x,
                    y,
                    textPaint
                )
            }
        }
    }
}