package com.noni.au.app.kotlintodosampleapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoitems")
data class ToDoItem(@PrimaryKey(autoGenerate = true) var id: Int,
                    @ColumnInfo(name = "title") var title: String,
                    @ColumnInfo(name = "content") var content: String,
                    @ColumnInfo(name = "isComplete")
                    var isComplete: Boolean = false)