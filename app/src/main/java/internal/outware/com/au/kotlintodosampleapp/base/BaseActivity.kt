package internal.outware.com.au.kotlintodosampleapp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class BaseActivity<P : Presenter<V> , V> : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}