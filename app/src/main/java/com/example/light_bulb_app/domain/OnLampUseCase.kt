package com.example.light_bulb_app.domain;

import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.repository.MainRepository
import javax.inject.Inject

interface OnLampUseCase {
        suspend operator fun invoke(): Result<Boolean?>
}


class OnLampUseCaseImpl @Inject constructor(
    private val repository: MainRepository,
) : OnLampUseCase {
        override suspend fun invoke(): Result<Boolean?> =
                repository.onLamp()
}