package com.noni.au.app.kotlintodosampleapp.data

data class ToDoItem(var id: String, var title: String) {
    var isComplete : Boolean = false
    var reminderDetail: String? = null
}
