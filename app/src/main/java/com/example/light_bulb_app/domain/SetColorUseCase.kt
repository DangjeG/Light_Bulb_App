package com.example.light_bulb_app.domain

import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.repository.MainRepository
import javax.inject.Inject

interface SetColorUseCase {
    suspend operator fun invoke(color: String): Result<Boolean?>
}

class SetColorUseCaseImpl @Inject constructor(
    private val repository: MainRepository,
): SetColorUseCase{

    override suspend fun invoke(color: String): Result<Boolean?> =
        repository.setColor(color)

}