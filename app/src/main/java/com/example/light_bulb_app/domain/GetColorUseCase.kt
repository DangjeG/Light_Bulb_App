package com.example.light_bulb_app.domain

import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.model.Color
import com.example.light_bulb_app.data.repository.MainRepository
import javax.inject.Inject

interface GetColorUseCase {
    suspend operator fun invoke(): Result<Color?>
}

class GetColorUseCaseImpl @Inject constructor(
    private val repository: MainRepository,
): GetColorUseCase {
    override suspend fun invoke(): Result<Color?> =
        repository.getColor()
}