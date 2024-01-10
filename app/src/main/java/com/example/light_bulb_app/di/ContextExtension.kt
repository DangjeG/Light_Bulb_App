package com.example.light_bulb_app.di

import android.content.Context
import com.example.light_bulb_app.MyApplication


val Context.appComponent: AppComponent
    get() = when(this) {
        is MyApplication -> appComponent
        else -> applicationContext.appComponent
    }
