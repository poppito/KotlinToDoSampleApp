package com.noni.au.app.kotlintodosampleapp.domain.repositories

interface ReminderRepository  {
    fun getReminderByTitle(title: String)
    fun createReminder(title: String, content: String?)
    fun removeReminder(title : String)
}