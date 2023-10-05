package com.gap.compositionnumber.domain.entities

data class Question(
    val sum: Int,
    val visibleNumber: Int,
    val answers: List<Int>
)
