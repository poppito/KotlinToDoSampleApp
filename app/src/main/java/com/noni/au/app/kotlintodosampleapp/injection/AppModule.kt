package com.noni.au.app.kotlintodosampleapp.injection

import android.app.Application
import android.arch.persistence.room.Room
import com.noni.au.app.kotlintodosampleapp.data.ToDoDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val app: Application) {

    @Singleton
    @Provides
    fun getDb() : ToDoDb {
        return Room.databaseBuilder(app.applicationContext, ToDoDb::class.java, "database-name").build()
    }
}