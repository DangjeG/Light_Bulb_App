package com.example.light_bulb_app.domain


import com.example.light_bulb_app.data.model.Resp
import com.example.light_bulb_app.data.repository.MainRepository
import javax.inject.Inject

class GetJokesCategoriesUseCaseImpl @Inject constructor(

    private val repository: MainRepository,
): GetJokesCategoriesUseCase {
    override suspend fun invoke(): Result<Resp?> =
        repository.getJokesCategories()

}
