package com.noni.au.app.kotlintodosampleapp.injection

import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
    fun getAppContext()
    fun getApp() : KotlinSampleToDoApp
    fun getActivityComponent()
}
