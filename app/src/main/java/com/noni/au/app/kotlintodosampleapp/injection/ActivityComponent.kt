package com.noni.au.app.kotlintodosampleapp.injection

import com.noni.au.app.kotlintodosampleapp.presentation.view.activities.MainActivity
import dagger.Component

@PerScreen
@Component(dependencies=arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(activity: MainActivity)
}