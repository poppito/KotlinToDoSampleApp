package com.noni.au.app.kotlintodosampleapp.app

import android.app.Application
import com.noni.au.app.kotlintodosampleapp.injection.AppComponent
import com.noni.au.app.kotlintodosampleapp.injection.AppModule
import com.noni.au.app.kotlintodosampleapp.injection.DaggerAppComponent

class KotlinSampleToDoApp : Application() {

    lateinit var mAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        mAppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        mAppComponent.inject(this)
    }
}
