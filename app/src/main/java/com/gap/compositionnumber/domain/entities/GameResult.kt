package com.gap.compositionnumber.domain.entities

import java.io.Serializable

data class GameResult(
    val winner: Boolean,
    val countOfRightAnswer: Int,
    val countOfQuestion: Int,
    val gameSettings: GameSettings
): Serializable
