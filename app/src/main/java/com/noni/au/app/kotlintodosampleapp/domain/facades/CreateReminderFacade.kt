package com.noni.au.app.kotlintodosampleapp.domain.facades

import android.content.Context
import com.noni.au.app.kotlintodosampleapp.domain.repositories.ReminderRepository
import javax.inject.Inject

class CreateReminderFacade @Inject constructor(val repository : ReminderRepository, val context: Context) {
    fun createAReminder(title: String, content: String) {
        repository.createReminder(title, content)
    }
}