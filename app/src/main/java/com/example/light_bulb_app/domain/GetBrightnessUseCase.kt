package com.example.light_bulb_app.domain

import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.repository.MainRepository
import javax.inject.Inject

interface GetBrightnessUseCase {
    suspend operator fun invoke(): Result<Int?>
}

class GetBrightnessUseCaseImpl@Inject constructor(
    private val repository: MainRepository,
): GetBrightnessUseCase {
    override suspend fun invoke(): Result<Int?> =
        repository.getBrightness()
}
