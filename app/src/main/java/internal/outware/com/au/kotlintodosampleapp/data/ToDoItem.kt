package internal.outware.com.au.kotlintodosampleapp.data

data class ToDoItem(var id: String, var title: String) {
    var isComplete : Boolean = false
    var reminderDetail: String? = null
}
