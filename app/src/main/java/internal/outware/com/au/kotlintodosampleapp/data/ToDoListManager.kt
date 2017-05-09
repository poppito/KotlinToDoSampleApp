package internal.outware.com.au.kotlintodosampleapp.data

import android.content.Context
import internal.outware.com.au.kotlintodosampleapp.domain.ReminderRepository

class ToDoListManager(val context: Context?) : ReminderRepository {

    val mContext = context

    val dbHelper = ToDoListDbHelper(mContext)

    override fun getReminderById(id: String) {
    }

    override fun createReminder() {
    }

    override fun removeReminder(id: String) {
    }

}