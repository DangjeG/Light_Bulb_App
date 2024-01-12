package com.example.light_bulb_app.domain

import com.example.light_bulb_app.data.model.Color
import com.example.light_bulb_app.data.repository.MainRepository
import javax.inject.Inject

interface GetColorsUseCase {
    suspend operator fun invoke(): Result<List<Color>?>
}

class GetColorsUseCaseImpl @Inject constructor(
    private val repository: MainRepository,
): GetColorsUseCase {
    override suspend fun invoke(): Result<List<Color>?> =
        repository.getColors()

}