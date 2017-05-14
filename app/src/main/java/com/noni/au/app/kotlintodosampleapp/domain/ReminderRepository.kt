package com.noni.au.app.kotlintodosampleapp.domain

interface ReminderRepository  {
    fun getReminderById(id : String)
    fun createReminder()
    fun removeReminder(id : String)
    fun createReminderDb()
}
