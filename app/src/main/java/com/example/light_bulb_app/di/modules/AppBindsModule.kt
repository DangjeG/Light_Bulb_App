package com.example.light_bulb_app.di.modules


import com.example.light_bulb_app.data.repository.*
import com.example.light_bulb_app.domain.*
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {
    @Binds
    fun bindMainRepository(repository: MainRepositoryImpl): MainRepository

    @Binds
    fun binOnLampUseCase(useCase: OnLampUseCaseImpl): OnLampUseCase

    @Binds
    fun bindOffLampUseCase(useCase: OffLampUseCaseImpl): OffLampUseCase

    @Binds
    fun bindGetStateUseCase(useCase: GetStateUseCaseImpl): GetStateUseCase

    @Binds
    fun bindGetColorsUseCase(useCase: GetColorsUseCaseImpl): GetColorsUseCase

    @Binds
    fun bindSetColorUseCase(useCase: SetColorUseCaseImpl): SetColorUseCase

    @Binds
    fun bindGetColorUseCase(useCase: GetColorUseCaseImpl): GetColorUseCase

    @Binds
    fun bindGetBrightnessLevelsUseCase(useCase: GetBrightnessLevelsUseCaseImpl): GetBrightnessLevelsUseCase

    @Binds
    fun bindSetBrightnessUseCase(useCase: SetBrightnessUseCaseImpl): SetBrightnessUseCase

    @Binds
    fun bindGetBrightnessUseCase(useCase: GetBrightnessUseCaseImpl): GetBrightnessUseCase
}
