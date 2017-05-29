package com.noni.au.app.kotlintodosampleapp.data

import android.content.ContentValues
import android.content.Context
import com.noni.au.app.kotlintodosampleapp.domain.repositories.ReminderRepository

class ToDoListManager(val context: Context?) : ReminderRepository {

    val mContext = context

    val mDbHelper = ToDoListDbHelper(mContext)

    override fun getReminderById(id: String) {
    }

    override fun createReminder(title: String, content: String?) {
        val dB = mDbHelper.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ToDoListDbHelper.getTitleColumnName(), title)
        if (content != null) {
            contentValues.put(ToDoListDbHelper.getContentColumnName(), content)
        }
        dB.insert(ToDoListDbHelper.getToDoListTableName(), null, contentValues)
    }

    override fun removeReminder(id: String) {
    }

    override fun createReminderDb() {
    }

}