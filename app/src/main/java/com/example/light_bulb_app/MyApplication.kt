package com.example.light_bulb_app

import android.app.Application
import com.example.light_bulb_app.di.AppComponent
import com.example.light_bulb_app.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .create()
    }

}
