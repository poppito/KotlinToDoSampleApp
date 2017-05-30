package com.noni.au.app.kotlintodosampleapp.injection

import com.noni.au.app.kotlintodosampleapp.domain.facades.CreateReminderFacade
import com.noni.au.app.kotlintodosampleapp.presentation.CreateReminderPresenter
import com.noni.au.app.kotlintodosampleapp.presentation.CreateReminderPresenter.ViewSurface
import dagger.Module
import dagger.Provides

@PerScreen
@Module (includes = arrayOf(AppModule::class))
class ActivityModule {

    @Provides
    fun getToDoPresenter(facade: CreateReminderFacade) : CreateReminderPresenter<ViewSurface> {
        return CreateReminderPresenter(facade)
    }
}