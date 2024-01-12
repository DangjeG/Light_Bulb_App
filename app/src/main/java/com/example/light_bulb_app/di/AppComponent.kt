package com.example.light_bulb_app.di

import com.example.light_bulb_app.presenter.main.MainFragment
import com.example.light_bulb_app.di.modules.AppModule
import dagger.Component

@Component(
    modules = [ AppModule::class ]
)

interface AppComponent {
    fun inject(fragment: MainFragment)
}

