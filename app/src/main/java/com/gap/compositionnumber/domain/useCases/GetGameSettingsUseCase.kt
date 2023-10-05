package com.gap.compositionnumber.domain.useCases

import com.gap.compositionnumber.domain.entities.GameSettings
import com.gap.compositionnumber.domain.entities.Level
import com.gap.compositionnumber.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}