package com.noni.au.app.kotlintodosampleapp.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.noni.au.app.kotlintodosampleapp.domain.repositories.ReminderRepository
import javax.inject.Inject

class CreateReminderManager @Inject constructor(val context: Context?) : SQLiteOpenHelper(context,"ToDoListDb.db", null, 1), ReminderRepository {

    val mContext = context


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createDb())
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(dropDb())
    }


    override fun getReminderById(id: String) {
    }

    override fun createReminder(title: String, content: String?) {
        val dB = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(getTitleColumnName(), title)
        if (content != null) {
            contentValues.put(getContentColumnName(), content)
        }
        dB.insert(getToDoListTableName(), null, contentValues)
    }

    override fun removeReminder(id: String) {
    }

    override fun createReminderDb() {
    }

    companion object ToDoDbOps {

        fun createDb(): String {
            return "CREATE TABLE " + ToDoEntryContract.ToDoList.TABLE_NAME + " (" +
                    ToDoEntryContract.ToDoList.COLUMN_NAME_TITLE + " TEXT," +
                    ToDoEntryContract.ToDoList.COLUMN_NAME_CONTENT + " TEXT)";
        }

        fun dropDb(): String {
            return "DROP TABLE IF EXISTS " + ToDoEntryContract.ToDoList.TABLE_NAME
        }

        fun getTitleColumnName(): String {
            return ToDoEntryContract.COLUMN_NAME_TITLE
        }

        fun getContentColumnName(): String {
            return ToDoEntryContract.COLUMN_NAME_CONTENT
        }

        fun getToDoListTableName(): String {
            return ToDoEntryContract.TABLE_NAME
        }
    }

}