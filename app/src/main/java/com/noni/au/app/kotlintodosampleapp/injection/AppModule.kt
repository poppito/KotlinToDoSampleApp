package com.noni.au.app.kotlintodosampleapp.injection

import android.content.Context
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(app: KotlinSampleToDoApp) {

    var mApp: KotlinSampleToDoApp = app

    @Singleton
    @Provides
    fun getAppContext(): Context {
        return mApp
    }

    @Singleton
    @Provides
    fun provideToDoApp(): KotlinSampleToDoApp {
        return mApp
    }
}