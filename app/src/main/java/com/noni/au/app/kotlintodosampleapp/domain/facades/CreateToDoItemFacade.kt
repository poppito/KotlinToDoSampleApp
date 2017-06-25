package com.noni.au.app.kotlintodosampleapp.domain.facades

import com.noni.au.app.kotlintodosampleapp.domain.repositories.ToDoItemRepository
import javax.inject.Inject

class CreateToDoItemFacade @Inject constructor(val repository : ToDoItemRepository) {
    fun createAReminder(title: String, content: String) {
        repository.createReminder(title, content)
    }
}