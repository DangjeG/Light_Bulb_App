package com.example.light_bulb_app.data.repository

import com.example.light_bulb_app.data.api.MainService
import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.model.Color
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val service: MainService
) : MainRepository {
    override suspend fun onLamp(): Result<Boolean?> {
        kotlin.runCatching {
            service.onLamp()
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

    override suspend fun offLamp(): Result<Boolean?> {
        kotlin.runCatching {
            service.offLamp()
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

    override suspend fun getState(): Result<Boolean?> {
        kotlin.runCatching {
            service.getState()
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

    override suspend fun getColors(): Result<List<Color>?> {
        kotlin.runCatching {
            service.getColors()
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

    override suspend fun setColor(color: String): Result<Boolean?> {
        kotlin.runCatching {
            service.setColor(color)
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

    override suspend fun getColor(): Result<Color?> {
        kotlin.runCatching {
            service.getColor()
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

    override suspend fun getBrightnessLevels(): Result<BrightnessLevels?> {
        kotlin.runCatching {
            service.getBrightnessLevels()
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

    override suspend fun setBrightness(level: Int): Result<Boolean?> {
        kotlin.runCatching {
            service.setBrightness(level)
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

    override suspend fun getBrightness(): Result<Int?> {
        kotlin.runCatching {
            service.getBrightness()
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
