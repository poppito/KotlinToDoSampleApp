package com.noni.au.app.kotlintodosampleapp.data

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * The data access object for
 * the ToDoList table.
 * @author harshoverseer on 25/6/17.
 */
interface ToDoDao {

    @Insert
    fun insertItem(item: ToDoItem)

    @Delete
    fun deleteItem(item: ToDoItem)

    @Query("SELECT * from ToDoDb where title LIKE :title")
    fun getItemByTitle(title: String): ToDoItem

    @Query("SELECT * from ToDoDb")
    fun getAllToDos(): List<ToDoItem>
}