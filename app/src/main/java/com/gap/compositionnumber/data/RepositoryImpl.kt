package com.gap.compositionnumber.data

import com.gap.compositionnumber.domain.entities.GameSettings
import com.gap.compositionnumber.domain.entities.Level
import com.gap.compositionnumber.domain.entities.Question
import com.gap.compositionnumber.domain.repository.GameRepository

object RepositoryImpl : GameRepository {
    override fun getGameSettings(level: Level): GameSettings {
        TODO("Not yet implemented")
    }

    override fun generateQuestion(maxValueSum: Int, countOfAnswers: Int): Question {
        TODO("Not yet implemented")
    }
}