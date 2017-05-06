package internal.outware.com.au.kotlintodosampleapp.domain

interface ReminderRepository  {
    fun getReminderById(id : String)
    fun createReminder()
    fun removeReminder(id : String)
}
