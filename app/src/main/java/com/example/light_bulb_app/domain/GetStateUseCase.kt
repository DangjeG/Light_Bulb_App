package com.example.light_bulb_app.domain;

import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.repository.MainRepository
import javax.inject.Inject

interface GetStateUseCase {
    suspend operator fun invoke(): Result<Boolean?>
}

class GetStateUseCaseImpl @Inject constructor(
    private val repository: MainRepository,
): GetStateUseCase{
    override suspend fun invoke(): Result<Boolean?> =
        repository.getState()
}