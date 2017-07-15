package com.noni.au.app.kotlintodosampleapp.domain.facades

import com.noni.au.app.kotlintodosampleapp.data.ToDoItem
import com.noni.au.app.kotlintodosampleapp.domain.repositories.ToDoItemRepository
import io.reactivex.Single
import javax.inject.Inject

class CreateToDoItemFacade @Inject constructor(val repository: ToDoItemRepository) {
    fun createAReminder(title: String, content: String) {
        repository.createReminder(title, content)
    }

    fun getAllItems(): Single<List<ToDoItem>> {
        return repository.getAllReminders()
    }
}