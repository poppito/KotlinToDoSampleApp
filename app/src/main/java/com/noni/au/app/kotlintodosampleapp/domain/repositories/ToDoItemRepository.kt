package com.noni.au.app.kotlintodosampleapp.domain.repositories

import com.noni.au.app.kotlintodosampleapp.data.ToDoItem
import io.reactivex.Single

interface ToDoItemRepository {
    fun getReminderByTitle(title: String)
    fun createReminder(title: String, content: String?)
    fun removeReminder(title : String)
    fun getAllReminders() : Single<List<ToDoItem>>
}