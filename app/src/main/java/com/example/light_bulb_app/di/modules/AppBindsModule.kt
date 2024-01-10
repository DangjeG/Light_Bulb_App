package com.example.light_bulb_app.di.modules

import com.example.light_bulb_app.data.repository.MainRepository
import com.example.light_bulb_app.data.repository.MainRepositoryImpl
import com.example.light_bulb_app.domain.GetJokesCategoriesUseCase
import com.example.light_bulb_app.domain.GetJokesCategoriesUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {
    @Binds
    fun bindMainRepository(repository: MainRepositoryImpl): MainRepository

    @Binds
    fun bindGetJokesCategoriesUseCase(useCase: GetJokesCategoriesUseCaseImpl): GetJokesCategoriesUseCase

}
