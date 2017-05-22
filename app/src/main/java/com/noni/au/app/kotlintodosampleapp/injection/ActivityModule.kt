package com.noni.au.app.kotlintodosampleapp.injection

import android.support.v7.app.AppCompatActivity
import com.noni.au.app.kotlintodosampleapp.domain.ReminderRepository
import com.noni.au.app.kotlintodosampleapp.presentation.CreateReminderPresenter
import dagger.Module
import dagger.Provides

@PerScreen
@Module (includes = arrayOf(AppModule::class))
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    fun provideCreateReminderActivity() : AppCompatActivity = activity

    @Provides
    fun providePresenter(repo : ReminderRepository): CreateReminderPresenter<CreateReminderPresenter.ViewSurface> {
        return CreateReminderPresenter(repo)
    }
}