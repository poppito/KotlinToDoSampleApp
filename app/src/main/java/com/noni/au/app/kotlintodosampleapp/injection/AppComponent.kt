package com.noni.au.app.kotlintodosampleapp.injection

import android.content.Context
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = arrayOf(AppModule::class))
interface AppComponent {
    fun getAppContext() : Context
    fun getApp() : KotlinSampleToDoApp
    fun getActivityComponent(): ActivityComponent
}
