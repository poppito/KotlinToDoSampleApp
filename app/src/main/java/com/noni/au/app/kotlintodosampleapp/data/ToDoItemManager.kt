package com.noni.au.app.kotlintodosampleapp.data

import android.content.Context
import com.noni.au.app.kotlintodosampleapp.domain.repositories.ToDoItemRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ToDoItemManager @Inject constructor(val context: Context?, private val db: ToDoDb) : ToDoItemRepository {
    override fun getAllReminders(): Single<List<ToDoItem>> {
        return Single.fromCallable {
            db.toDoDao().getAllToDos()
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun removeReminder(title: String) {
    }

    override fun getReminderByTitle(title: String) {

    }

    override fun createReminder(title: String, content: String?) {
        var insertContent = ""
        if (content != null) {
            insertContent = content
        }
        val item = ToDoItem(0, title, insertContent, false)
        Single.fromCallable {
            db.toDoDao().insertItem(item)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

}