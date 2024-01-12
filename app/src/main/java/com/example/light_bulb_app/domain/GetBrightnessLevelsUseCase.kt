package com.example.light_bulb_app.domain;

import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.repository.MainRepository
import javax.inject.Inject

interface GetBrightnessLevelsUseCase {
    suspend operator fun invoke(): Result<BrightnessLevels?>
}
class GetBrightnessLevelsUseCaseImpl @Inject constructor(
    private val repository: MainRepository,
): GetBrightnessLevelsUseCase {
    override suspend fun invoke(): Result<BrightnessLevels?> =
        repository.getBrightnessLevels()

}

