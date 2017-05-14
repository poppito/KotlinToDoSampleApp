package com.noni.au.app.kotlintodosampleapp.data

import android.content.Context
import com.noni.au.app.kotlintodosampleapp.domain.ReminderRepository

class ToDoListManager(val context: Context?) : ReminderRepository {
    val mContext = context

    val mDbHelper = ToDoListDbHelper(mContext)

    override fun getReminderById(id: String) {
    }

    override fun createReminder() {
    }

    override fun removeReminder(id: String) {
    }

    override fun createReminderDb() {
    }

}