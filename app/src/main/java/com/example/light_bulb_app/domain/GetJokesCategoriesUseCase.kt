package com.example.light_bulb_app.domain

import com.example.light_bulb_app.data.model.Resp

interface GetJokesCategoriesUseCase {
    suspend operator fun invoke(): Result<Resp?>
}
