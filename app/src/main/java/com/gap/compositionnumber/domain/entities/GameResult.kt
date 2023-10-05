package com.gap.compositionnumber.domain.entities

data class GameResult(
    val winner: Boolean,
    val countOfRightAnswer: Int,
    val countOfQuestion: Int,
    val gameSettings: GameSettings
)
