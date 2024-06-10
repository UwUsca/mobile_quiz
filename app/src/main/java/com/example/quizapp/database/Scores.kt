package com.example.quizapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scores")
data class Score(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val username: String,
    val score: Int
)
