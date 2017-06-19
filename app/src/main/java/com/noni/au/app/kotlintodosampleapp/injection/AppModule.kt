package com.noni.au.app.kotlintodosampleapp.injection

import android.content.Context
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(app: KotlinSampleToDoApp) {

    private var mApp: KotlinSampleToDoApp = app

    @Singleton
    @Provides
    fun getAppContext(): Context {
        return mApp
    }

    @Singleton
    @Provides
    fun provideApp(): KotlinSampleToDoApp {
        return mApp
    }

    @Singleton
    @Provides
    fun provideActivityComponent(): ActivityComponent {
        return DaggerActivityComponent.builder()
                .activityModule(ActivityModule())
                .build()
    }

    @Singleton
    @Provides
    fun provideFragmentComponent(): FragmentComponent {
        return DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule())
                .build()
    }
}