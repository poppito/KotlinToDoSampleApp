package com.noni.au.app.kotlintodosampleapp.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase



/**
 * An abstract representation
 * of the ToDoList Db.
 * @author harshoverseer
 */
@Database(entities = arrayOf(ToDoItem::class), version = 1 )
abstract class ToDoDb : RoomDatabase() {
    abstract fun toDoDao() : ToDoDao
}