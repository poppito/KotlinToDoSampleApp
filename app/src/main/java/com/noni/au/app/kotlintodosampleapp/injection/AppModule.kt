package com.noni.au.app.kotlintodosampleapp.injection

import android.content.Context
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import dagger.Module
import dagger.Provides

@Module
class AppModule(app : KotlinSampleToDoApp) {

    var mApp : KotlinSampleToDoApp = app

    @Provides
    fun getAppContext() : Context {
        return mApp
    }
}
