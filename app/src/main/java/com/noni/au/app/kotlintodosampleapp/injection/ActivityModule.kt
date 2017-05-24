package com.noni.au.app.kotlintodosampleapp.injection

import dagger.Module

@PerScreen
@Module (includes = arrayOf(AppModule::class))
class ActivityModule() {
}