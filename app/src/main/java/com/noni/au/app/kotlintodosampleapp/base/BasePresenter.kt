package com.noni.au.app.kotlintodosampleapp.base

open class BasePresenter<V> : Presenter<V> {

    override fun onViewDetached(view : V) {
    }
    override fun onViewAttached(view : V) {
    }
    override fun onStart() {
    }
    override fun onStop() {
    }
}