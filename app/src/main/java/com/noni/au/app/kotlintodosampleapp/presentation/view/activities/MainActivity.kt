package com.noni.au.app.kotlintodosampleapp.presentation.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.noni.au.app.kotlintodosampleapp.R
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import com.noni.au.app.kotlintodosampleapp.injection.ActivityModule
import com.noni.au.app.kotlintodosampleapp.injection.DaggerActivityComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inject()
    }

    private fun inject() {
        val app = application as KotlinSampleToDoApp
        DaggerActivityComponent.builder()
                .appComponent(app.mAppComponent)
                .activityModule(ActivityModule(this))
                .build()
                .inject(this)
    }
}
