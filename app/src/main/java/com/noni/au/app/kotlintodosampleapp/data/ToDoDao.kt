package com.noni.au.app.kotlintodosampleapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


/**
 * The data access object for
 * the ToDoList table.
 * @author harshoverseer on 25/6/17.
 */
@Dao
interface ToDoDao {

    @Insert
    fun insertItem(item: ToDoItem)

    @Delete
    fun deleteItem(item: ToDoItem)

    @Query("SELECT * from todoitems WHERE title LIKE :title and content LIKE :content")
    fun getItemByTitle(title: String, content: String = ""): List<ToDoItem>

    @Query("SELECT * from todoitems")
    fun getAllToDos(): List<ToDoItem>
}