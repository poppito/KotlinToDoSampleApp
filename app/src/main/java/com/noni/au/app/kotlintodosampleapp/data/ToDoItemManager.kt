package com.noni.au.app.kotlintodosampleapp.data

import android.content.Context
import com.noni.au.app.kotlintodosampleapp.domain.repositories.ReminderRepository
import javax.inject.Inject

class ToDoItemManager @Inject constructor(val context: Context?) : ReminderRepository {
    override fun getReminderByTitle(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createReminder(title: String, content: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeReminder(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}