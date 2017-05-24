package com.noni.au.app.kotlintodosampleapp.app

import android.app.Application
import android.content.Context
import com.noni.au.app.kotlintodosampleapp.injection.AppComponent

class KotlinSampleToDoApp : Application() {

    private lateinit var mAppComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        mAppComponent = DaggerAppComponent.builder()
                .appModule()
                .build()
    }

    fun getAppContext() : Context {
        return applicationContext
    }

    fun getAppComponent(): AppComponent {
        return mAppComponent
    }
}
