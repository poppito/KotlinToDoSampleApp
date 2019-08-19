package com.noni.au.app.kotlintodosampleapp.data

import androidx.room.Database
import androidx.room.RoomDatabase


/**
 * An abstract representation
 * of the ToDoList Db.
 * @author harshoverseer
 */
@Database(entities = [ToDoItem::class], version = 1)
abstract class ToDoDb : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}