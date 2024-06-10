package com.example.quizapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScoreDao {
    @Insert
    suspend fun insert(score: Score)

    @Query("SELECT * FROM scores ORDER BY score DESC LIMIT 5")
    suspend fun getTopScores(): List<Score>
}
