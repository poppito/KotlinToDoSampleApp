package com.noni.au.app.kotlintodosampleapp.injection

import com.noni.au.app.kotlintodosampleapp.presentation.view.CreateReminderActivity
import dagger.Component

@PerScreen
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(activity: CreateReminderActivity)
}