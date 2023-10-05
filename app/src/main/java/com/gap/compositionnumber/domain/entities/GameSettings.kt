package com.gap.compositionnumber.domain.entities

data class GameSettings(
    val valueMaxSum: Int,
    val minCountOfRightAnswers: Int,
    val minPercentOfRightAnswers: Int,
    val gameTimeInSecond: Int
)
