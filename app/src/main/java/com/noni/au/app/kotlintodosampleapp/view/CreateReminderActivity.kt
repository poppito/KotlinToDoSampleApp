package com.noni.au.app.kotlintodosampleapp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.noni.au.app.kotlintodosampleapp.R
import com.noni.au.app.kotlintodosampleapp.presentation.CreateReminderPresenter

class CreateReminderActivity : AppCompatActivity(), CreateReminderPresenter.ViewSurface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_reminder)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun createReminder(title: String, content: String?) {
    }
}
