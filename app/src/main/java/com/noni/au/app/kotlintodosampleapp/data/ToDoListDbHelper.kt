package com.noni.au.app.kotlintodosampleapp.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ToDoListDbHelper(context: Context?) : SQLiteOpenHelper(context,"ToDoListDb.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(ToDoDbOps.createDb())
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(ToDoDbOps.dropDb())
    }


    companion object ToDoDbOps {

        fun createDb() : String {
            return "CREATE TABLE " + ToDoEntryContract.ToDoList.TABLE_NAME + " (" +
                            ToDoEntryContract.ToDoList.COLUMN_NAME_TITLE + " TEXT," +
                            ToDoEntryContract.ToDoList.COLUMN_NAME_CONTENT + " TEXT)";
        }

        fun dropDb() : String {
            return "DROP TABLE IF EXISTS " + ToDoEntryContract.ToDoList.TABLE_NAME
        }
    }
}
