package com.noni.au.app.kotlintodosampleapp.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "todoitems")
data class ToDoItem(@PrimaryKey(autoGenerate = true) var id: Int,
                    @ColumnInfo(name = "title") var title: String,
                    @ColumnInfo(name = "content") var content: String,
                    @ColumnInfo(name = "isComplete")
                    var isComplete: Boolean = false)
