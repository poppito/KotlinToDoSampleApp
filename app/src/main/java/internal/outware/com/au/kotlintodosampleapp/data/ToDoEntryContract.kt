package internal.outware.com.au.kotlintodosampleapp.data

import android.provider.BaseColumns

class ToDoEntryContract {

    companion object Reminder : BaseColumns {
        val TABLE_NAME = "Reminders"
        val COLUMN_NAME_TITLE = "title"
        val COLUMN_NAME_CONTENT = "Content"
    }
}