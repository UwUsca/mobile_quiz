package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import com.example.quizapp.data.Question
import com.example.quizapp.data.createQuestions
import com.example.quizapp.ui.theme.BackgroundColor
import com.example.quizapp.ui.theme.ColorCrown
import com.example.quizapp.ui.theme.MainBlue
import com.example.quizapp.ui.theme.MainGreen
import com.example.quizapp.ui.theme.MainOrange
import com.example.quizapp.ui.theme.MainPink
import com.example.quizapp.ui.theme.MainPurple
import com.example.quizapp.ui.theme.MainRed
import com.example.quizapp.ui.theme.MainYellow
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.ui.theme.SecondaryBlue
import com.example.quizapp.ui.theme.SecondaryGreen
import com.example.quizapp.ui.theme.SecondaryOrange
import com.example.quizapp.ui.theme.SecondaryPink
import com.example.quizapp.ui.theme.SecondaryRed
import com.example.quizapp.ui.theme.SecondaryYellow

class MainMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val username = GlobalVariables.userName
        setContent {
            QuizAppTheme {
                Box(modifier = Modifier
                    .background(color = BackgroundColor)
                    .fillMaxSize())
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
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
                            .background(color = BackgroundColor)
                        ){
                        Text(
                            text = "QUESTIONADOS",
                            fontFamily = GlobalVariables.font_logo,
                            fontSize = 35.sp,
                            color = Color.White,
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color(0x55a0a3a5),
                                    offset = Offset(5.0f, 10.0f),
                                    blurRadius = 7f
                                )
                            ),
                            modifier = Modifier
                                .padding(10.dp)
                        )
                    }
                    Column (horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(20.dp)) {
                        Text(
                            text = "Bem vindo(a) $username!",
                            fontFamily = GlobalVariables.font_body,
                            fontSize = 20.sp,
                            color = Color.White)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Selecione um tema para jogar!",
                            fontFamily = GlobalVariables.font_body,
                            color = Color.White)
                        Spacer(modifier = Modifier.height(5.dp))
                        CustomButton(
                            { navigateToQuiz() },
                            MainPurple,
                            R.drawable.crown,
                            ColorCrown,
                            "ALEATORIO"
                        )
                        CustomButton(
                            { navigateToQuiz("Geografia") },
                            MainBlue,
                            R.drawable.geography,
                            SecondaryBlue,
                            "GEOGRAFIA"
                        )
                        CustomButton(
                            { navigateToQuiz("Ciências") },
                            MainGreen,
                            R.drawable.science,
                            SecondaryGreen,
                            "CIENCIAS"
                        )
                        CustomButton(
                            { navigateToQuiz("História") },
                            MainYellow,
                            R.drawable.history,
                            SecondaryYellow,
                            "HISTORIA"
                        )
                        CustomButton(
                            { navigateToQuiz("Esportes") },
                            MainOrange,
                            R.drawable.sports,
                            SecondaryOrange,
                            "ESPORTES"
                        )
                        CustomButton(
                            { navigateToQuiz("Artes") },
                            MainRed,
                            R.drawable.arts,
                            SecondaryRed,
                            "ARTES"
                        )
                        CustomButton(
                            { navigateToQuiz("Entretenimento") },
                            MainPink,
                            R.drawable.culture,
                            SecondaryPink,
                            "ENTRETENIMENTO"
                        )
                    }
                }
                Column(verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp, 7.dp)) {
                    Button(onClick = {
                        val navigateToRanking = Intent(this@MainMenuActivity, Leaderboard::class.java)
                        startActivity(navigateToRanking)
                        finish()
                    },
                        modifier = Modifier
                            .width(150.dp)
                            .height(50.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
                    ){
                        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                            Canvas(
                                modifier = Modifier.fillMaxSize(),
                                onDraw = {
                                    val textPaint = android.graphics.Paint().apply {
                                        isAntiAlias = true
                                        style = android.graphics.Paint.Style.FILL
                                        textSize = 60f
                                        color = android.graphics.Color.BLACK
                                        typeface = GlobalVariables.getFontLogoAlt(this@MainMenuActivity)
                                    }
                                    val textWidth = textPaint.measureText("Ranking")
                                    val x = (size.width - textWidth) / 2
                                    val y = (size.height / 2) - ((textPaint.descent() + textPaint.ascent()) / 2)
                                    drawIntoCanvas {

                                        it.nativeCanvas.drawText(
                                            "Ranking",
                                            x,
                                            y,
                                            textPaint
                                        )
                                    }
                                }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }

    @Composable
    fun CustomButton(
        onClick: () -> Unit,
        colorBG: Color,
        icon: Int,
        iconTint: Color,
        text: String,
    ){
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(colorBG),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
            shape = RoundedCornerShape(35.dp)
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(iconTint)
                )
                Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    val font_logo_alt = ResourcesCompat.getFont(this@MainMenuActivity, R.font.mikadobold)
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
                    val shadowPaint = Paint().asFrameworkPaint().apply {
                        isAntiAlias = true
                        style = android.graphics.Paint.Style.FILL
                        textSize = 66f
                        color = android.graphics.Color.parseColor("#FF000000")
                        typeface = font_logo_alt
                    }
                    Canvas(
                        modifier = Modifier.fillMaxSize(),
                        onDraw = {
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
                    )
                }
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(iconTint)
                )
            }
        }
        Spacer(modifier = Modifier.height(7.dp))
    }

    private fun navigateToQuiz(theme: String? = null) {
        val questions = createQuestions(theme)
        val randomQuestion = questions.random()
        val navigate = Intent(this@MainMenuActivity, QuizActivity::class.java).apply {
            putExtra("question", randomQuestion)
            putExtra("correctAnswersCount", 0)
            putExtra("theme", theme)
        }
        startActivity(navigate)
    }
}