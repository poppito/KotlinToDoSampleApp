package com.noni.au.app.kotlintodosampleapp.injection

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides

@PerScreen
@Module(includes = arrayOf(AppModule::class))
class ActivityModule(private val activity: Activity) {

    @Provides
    fun getContext(): Context = activity

}