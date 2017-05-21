package com.noni.au.app.kotlintodosampleapp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<P : Presenter<V> , V> : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    abstract fun inject()
 }