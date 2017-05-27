package com.noni.au.app.kotlintodosampleapp.base

import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<P : Presenter<V> , V> : AppCompatActivity() {
 }