package com.noni.au.app.kotlintodosampleapp.domain.facades

import com.noni.au.app.kotlintodosampleapp.domain.repositories.ReminderRepository
import javax.inject.Inject

class CreateToDoItemFacade @Inject constructor(val repository : ReminderRepository) {
    fun createAReminder(title: String, content: String) {
        repository.createReminder(title, content)
    }
}