package com.example.quizapp.data

import java.io.Serializable


data class Question(
    val question: String,
    val options: List<String>,
    val answer: String,
    val imageId: Int,
    val theme: String
): Serializable