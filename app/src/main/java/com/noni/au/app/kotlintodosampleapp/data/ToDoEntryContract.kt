package com.noni.au.app.kotlintodosampleapp.data

import android.provider.BaseColumns

class ToDoEntryContract {

    companion object ToDoList : BaseColumns {
        val TABLE_NAME = "Reminders"
        val COLUMN_NAME_TITLE = "title"
        val COLUMN_NAME_CONTENT = "Content"
    }
}