package com.noni.au.app.kotlintodosampleapp.presentation

import com.noni.au.app.kotlintodosampleapp.base.BasePresenter
import com.noni.au.app.kotlintodosampleapp.base.Presenter
import javax.inject.Inject

class CreateReminderPresenter<ViewSurface> @Inject constructor(): BasePresenter<ViewSurface>(), Presenter<ViewSurface> {

    var viewSurface : ViewSurface? = null

    override fun onStart(view: ViewSurface) {
        super.onStart(view)
        viewSurface = view
    }

    interface ViewSurface {
    }
}
