package com.noni.au.app.kotlintodosampleapp.domain.repositories

interface ReminderRepository  {
    fun getReminderById(id : String)
    fun createReminder(title: String, content: String?)
    fun removeReminder(id : String)
    fun createReminderDb()
}