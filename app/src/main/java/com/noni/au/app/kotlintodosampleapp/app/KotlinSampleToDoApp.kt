package com.noni.au.app.kotlintodosampleapp.app

import android.app.Application
import com.noni.au.app.kotlintodosampleapp.injection.AppComponent
import com.noni.au.app.kotlintodosampleapp.injection.AppModule

class KotlinSampleToDoApp : Application() {

    val mAppComponent : AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        mAppComponent.inject(this)
    }
}
