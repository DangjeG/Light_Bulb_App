package com.example.light_bulb_app.data.api

import com.example.light_bulb_app.data.model.BrightnessLevels
import com.example.light_bulb_app.data.model.Color
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MainService {
    suspend fun onLamp(): Response<Boolean>

    @POST("/state/off")
    suspend fun offLamp():  Response<Boolean>

    @GET("/state")
    suspend fun getState():  Response<Boolean>

    @GET("/color")
    suspend fun getColors(): Response<List<Color>>

    @POST("/color")
    suspend fun setColor(
        @Query("color") color: String
    ): Response<Boolean>

    @GET("/color/current")
    suspend fun getColor(): Response<Color>

    @GET("/brightness")
    suspend fun getBrightnessLevels(): Response<BrightnessLevels>

    @POST("/brightness")
    suspend fun setBrightness(
        @Query("level") level: Int
    ): Response<Boolean>

    @GET("/brightness/current")
    suspend fun getBrightness(): Response<Int>

}