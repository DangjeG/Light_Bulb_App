package com.example.light_bulb_app.domain

import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.repository.MainRepository
import javax.inject.Inject

interface SetBrightnessUseCase {
    suspend operator fun invoke(level: Int): Result<Boolean?>
}

class SetBrightnessUseCaseImpl @Inject constructor(
    private val repository: MainRepository,
): SetBrightnessUseCase {
    override suspend fun invoke(level: Int): Result<Boolean?> =
        repository.setBrightness(level)

}