package com.example.light_bulb_app.data.repository

import com.example.light_bulb_app.data.model.Resp

interface MainRepository {
    suspend fun getJokesCategories(): Result<Resp?>
}