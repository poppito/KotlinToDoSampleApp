package internal.outware.com.au.kotlintodosampleapp.base

interface Presenter<V> {
    fun onViewAttached(view : V)
    fun onStart()
    fun onStop()
    fun onViewDetached(view : V)
}