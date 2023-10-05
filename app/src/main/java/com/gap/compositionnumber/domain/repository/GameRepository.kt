package com.gap.compositionnumber.domain.repository

import com.gap.compositionnumber.domain.entities.GameSettings
import com.gap.compositionnumber.domain.entities.Level
import com.gap.compositionnumber.domain.entities.Question

interface GameRepository {

    fun getGameSettings(level: Level): GameSettings

    fun generateQuestion(
        maxValueSum: Int,
        countOfAnswers: Int
    ): Question

}