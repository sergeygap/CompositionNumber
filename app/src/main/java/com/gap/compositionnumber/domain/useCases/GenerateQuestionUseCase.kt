package com.gap.compositionnumber.domain.useCases

import com.gap.compositionnumber.domain.entities.Question
import com.gap.compositionnumber.domain.repository.GameRepository

class GenerateQuestionUseCase(private val repository: GameRepository) {
    operator fun invoke(valueMaxSum: Int) : Question {
       return repository.generateQuestion(valueMaxSum, COUNT_OF_ANSWERS)
    }
    private companion object {
        private const val COUNT_OF_ANSWERS = 6
    }
}