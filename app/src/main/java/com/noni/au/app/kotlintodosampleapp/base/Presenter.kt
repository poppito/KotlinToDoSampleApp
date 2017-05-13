package com.noni.au.app.kotlintodosampleapp.base

interface Presenter<V> {
    fun onViewAttached(view : V)
    fun onStart()
    fun onStop()
    fun onViewDetached(view : V)
}