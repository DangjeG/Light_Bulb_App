package com.example.light_bulb_app.data.repository

import com.example.light_bulb_app.data.api.MainService
import com.example.light_bulb_app.data.model.Resp
import retrofit2.HttpException
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val service: MainService
) : MainRepository {
    override suspend fun getJokesCategories(): Result<Resp?> {
        kotlin.runCatching {
            service.getJokesCategories()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }
}
