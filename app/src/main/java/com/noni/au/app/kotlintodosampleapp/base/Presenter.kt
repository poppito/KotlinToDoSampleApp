package com.noni.au.app.kotlintodosampleapp.base

interface Presenter<V> {
    fun onStart(view : V)
    fun onStop(view : V)
}