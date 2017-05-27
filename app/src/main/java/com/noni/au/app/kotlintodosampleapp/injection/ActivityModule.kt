package com.noni.au.app.kotlintodosampleapp.injection

import com.noni.au.app.kotlintodosampleapp.presentation.CreateReminderPresenter
import com.noni.au.app.kotlintodosampleapp.presentation.CreateReminderPresenter.ViewSurface
import dagger.Module
import dagger.Provides

@PerScreen
@Module (includes = arrayOf(AppModule::class))
class ActivityModule {

    @Provides
    fun getToDoPresenter() : CreateReminderPresenter<ViewSurface> {
        return CreateReminderPresenter()
    }
}