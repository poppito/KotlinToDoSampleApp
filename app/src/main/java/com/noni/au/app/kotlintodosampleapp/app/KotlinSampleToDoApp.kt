package com.noni.au.app.kotlintodosampleapp.app

import android.app.Application
import androidx.room.Room
import com.noni.au.app.kotlintodosampleapp.data.ToDoDb
import com.noni.au.app.kotlintodosampleapp.injection.AppComponent
import com.noni.au.app.kotlintodosampleapp.injection.AppModule
import com.noni.au.app.kotlintodosampleapp.injection.DaggerAppComponent

class KotlinSampleToDoApp : Application() {

    lateinit var mAppComponent: AppComponent
    lateinit var mDb: ToDoDb

    override fun onCreate() {
        super.onCreate()
        mAppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        mAppComponent.inject(this)

        mDb = Room.databaseBuilder(applicationContext, ToDoDb::class.java, "ToDoDb")
                .build()
    }
}
