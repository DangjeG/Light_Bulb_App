package com.example.light_bulb_app.data.api

import com.example.light_bulb_app.data.model.Resp
import retrofit2.Response
import retrofit2.http.GET

interface MainService {

    @GET("/latest")
    suspend fun getJokesCategories(): Response<Resp>

}