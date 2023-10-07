package com.gap.compositionnumber.data

import com.gap.compositionnumber.domain.entities.GameSettings
import com.gap.compositionnumber.domain.entities.Level
import com.gap.compositionnumber.domain.entities.Question
import com.gap.compositionnumber.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object RepositoryImpl : GameRepository {

    private const val MIN_VALUE_SUM = 2
    private const val MIN_VISIBLE_NUMBER = 1

    override fun generateQuestion(maxValueSum: Int, countOfAnswers: Int): Question {
        val sum = Random.nextInt(MIN_VALUE_SUM, maxValueSum+1)
        val visibleNumber = Random.nextInt(MIN_VISIBLE_NUMBER, sum)
        val rightAnswer = sum - visibleNumber
        val answers = HashSet<Int>()
        answers.add(rightAnswer)
        val from = max(rightAnswer - countOfAnswers, MIN_VISIBLE_NUMBER)
        val until = min(rightAnswer + countOfAnswers, maxValueSum)
        while (answers.size < countOfAnswers) {
            answers.add(Random.nextInt(from, until))
        }
        return Question(sum, visibleNumber, answers.toList())
    }


    override fun getGameSettings(level: Level): GameSettings {
        return when(level) {
            Level.TEST -> {
                GameSettings(
                    10,
                    2,
                    20,
                    8
                )
            }
            Level.EASY -> {
                GameSettings(
                    10,
                    5,
                    50,
                    60
                )
            }
            Level.MIDDLE -> {
                GameSettings(
                    20,
                    10,
                    70,
                    40
                )
            }
            Level.HARD -> {
                GameSettings(
                    30,
                    13,
                    90,
                    30
                )
            }
        }
    }
}