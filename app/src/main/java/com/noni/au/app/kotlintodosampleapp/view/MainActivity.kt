package com.noni.au.app.kotlintodosampleapp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.noni.au.app.kotlintodosampleapp.R

class MainActivity : AppCompatActivity() {

    val message = "Hello World!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mHelloWorldText = findViewById(R.id.txt_hello_world) as TextView
        mHelloWorldText.text = message
    }
}
