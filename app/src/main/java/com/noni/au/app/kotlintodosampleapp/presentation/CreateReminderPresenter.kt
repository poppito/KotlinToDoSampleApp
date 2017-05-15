package com.noni.au.app.kotlintodosampleapp.presentation

import com.noni.au.app.kotlintodosampleapp.base.BasePresenter
import com.noni.au.app.kotlintodosampleapp.base.Presenter

class CreateReminderPresenter<ViewSurface>: BasePresenter<ViewSurface>(), Presenter<ViewSurface> {

    var viewSurface : ViewSurface? = null

    override fun onViewAttached(view: ViewSurface) {
        super.onViewAttached(view)
        viewSurface = view
    }


    interface ViewSurface {
        fun createReminder(title: String, content: String?)
    }
}
