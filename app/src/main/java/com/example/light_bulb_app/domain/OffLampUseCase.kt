package com.example.light_bulb_app.domain;

import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.repository.MainRepository
import javax.inject.Inject

interface OffLampUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}

class OffLampUseCaseImpl @Inject constructor(
    private val repository: MainRepository,
): OffLampUseCase {

    override suspend fun invoke(): Result<Boolean?> =
        repository.offLamp()
}