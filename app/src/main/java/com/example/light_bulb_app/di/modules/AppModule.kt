package com.example.light_bulb_app.di.modules

import dagger.Module


@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class,
        AppBindsModule::class,
    ]
)

class AppModule {
}