package com.noni.au.app.kotlintodosampleapp.app

import android.app.Application
import com.noni.au.app.kotlintodosampleapp.injection.AppModule

class KotlinSampleToDoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()

        appComponent.inject(this)
    }
}
