package com.example.light_bulb_app.data.repository

import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.model.Color
import retrofit2.Response

interface MainRepository {

    suspend fun onLamp(): Result<Boolean?>

    suspend fun offLamp(): Result<Boolean?>

    suspend fun getState(): Result<Boolean?>

    suspend fun getColors(): Result<List<Color>?>

    suspend fun setColor(color: String): Result<Boolean?>

    suspend fun getColor(): Result<Color?>

    suspend fun getBrightnessLevels(): Result<BrightnessLevels?>

    suspend fun setBrightness(level: Int): Result<Boolean?>

    suspend fun getBrightness(): Result<Int?>
}