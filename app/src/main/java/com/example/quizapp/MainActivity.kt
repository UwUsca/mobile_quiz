package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Paint.Style
import android.graphics.Typeface
import android.os.Bundle
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
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import com.example.quizapp.GlobalVariables.main_colors
import com.example.quizapp.ui.theme.BackgroundColor
import com.example.quizapp.ui.theme.MainBlue
import com.example.quizapp.ui.theme.MainGreen
import com.example.quizapp.ui.theme.MainOrange
import com.example.quizapp.ui.theme.MainPink
import com.example.quizapp.ui.theme.MainPurple
import com.example.quizapp.ui.theme.MainRed
import com.example.quizapp.ui.theme.MainYellow
import com.example.quizapp.ui.theme.QuizAppTheme

object GlobalVariables {
    var userName by mutableStateOf("")
    val font_body = FontFamily(Font(R.font.font_body, FontWeight.Normal))
    val font_logo = FontFamily(Font(R.font.font_logo, FontWeight.Normal))
    val main_colors = listOf(
        MainBlue,
        MainGreen,
        MainYellow,
        MainOrange,
        MainRed,
        MainPink,
        MainPurple,
        MainBlue
    )
    fun getFontLogoAlt(context: Context): Typeface? {
        return ResourcesCompat.getFont(context, R.font.mikadobold)
    }
    fun createTextPaintStroke(context: Context): android.graphics.Paint {
        val fontLogoAlt = getFontLogoAlt(context)
        return android.graphics.Paint().apply {
            isAntiAlias = true
            style = android.graphics.Paint.Style.STROKE
            textSize = 60f
            color = android.graphics.Color.BLACK
            strokeWidth = 5f
            strokeMiter = 5f
            strokeJoin = android.graphics.Paint.Join.ROUND
            typeface = fontLogoAlt
        }
    }
    fun createTextPaint(context: Context): android.graphics.Paint {
        val fontLogoAlt = getFontLogoAlt(context)
        return android.graphics.Paint().apply {
            isAntiAlias = true
            style = android.graphics.Paint.Style.FILL
            textSize = 60f
            color = android.graphics.Color.WHITE
            typeface = fontLogoAlt
        }
    }
    fun createShadowPaint(context: Context): android.graphics.Paint {
        val fontLogoAlt = getFontLogoAlt(context)
        return android.graphics.Paint().apply {
            isAntiAlias = true
            style = android.graphics.Paint.Style.FILL
            textSize = 60f
            color = android.graphics.Color.parseColor("#FF000000")
            typeface = fontLogoAlt
        }
    }
}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val setUserName = { newUserName: String -> GlobalVariables.userName = newUserName }
            var textFieldValue by remember { mutableStateOf("") }

            // --- BORDER ANIMATION
            val brush = Brush.sweepGradient(main_colors)
            val infiniteTransition = rememberInfiniteTransition()
            val rotation by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(5000, easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                )
            )

            // --- SCALE ANIMATION
            val scale by infiniteTransition.animateFloat(
                initialValue = 1f,
                targetValue = 1.05f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 1500),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "Scale"
            )



            QuizAppTheme {
                Box(modifier = Modifier
                    .background(color = BackgroundColor)
                    .fillMaxSize())
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
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
                        modifier = Modifier.graphicsLayer {
                            scaleX= scale
                            scaleY= scale
                            transformOrigin = TransformOrigin.Center
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .background(color = Color(0x55000000))
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "Insira seu nome para continuar!",
                            fontFamily = GlobalVariables.font_body,
                            color = Color.White
                        )
                        TextField(
                            value = textFieldValue,
                            onValueChange = {textFieldValue = it},
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .clip(RoundedCornerShape(15.dp)),
                            singleLine = true,
                        )
                        Box(modifier = Modifier
                            .padding(16.dp)
                            .size(width = 100.dp, height = 45.dp)
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
                                    topLeft = Offset(2.dp.toPx(), 2.dp.toPx()),
                                    size = Size(
                                        width = size.width - 4.dp.toPx(),
                                        height = size.height - 4.dp.toPx()
                                    ),
                                    cornerRadius = CornerRadius(
                                        x = 25.dp.toPx(),
                                        y = 25.dp.toPx()
                                    )
                                )
                            }
                            Button(
                                onClick = {
                                    setUserName(textFieldValue)
                                    val navigate = Intent(
                                        this@MainActivity,
                                        MainMenuActivity::class.java
                                    )
                                    startActivity(navigate)
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(4.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = BackgroundColor,
                                    contentColor = Color.White
                                ),
                                shape = RoundedCornerShape(25.dp)
                            ) {
                                Text(text = "Jogar", fontFamily = GlobalVariables.font_logo)
                            }
                        }

                    }

                }
            }
        }
    }
}