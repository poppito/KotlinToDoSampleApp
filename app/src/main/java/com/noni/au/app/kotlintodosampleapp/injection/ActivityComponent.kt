package com.noni.au.app.kotlintodosampleapp.injection

import dagger.Component

@PerScreen
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
}