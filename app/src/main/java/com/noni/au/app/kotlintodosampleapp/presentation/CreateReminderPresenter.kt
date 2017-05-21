package com.noni.au.app.kotlintodosampleapp.presentation

import com.noni.au.app.kotlintodosampleapp.base.BasePresenter
import com.noni.au.app.kotlintodosampleapp.base.Presenter
import com.noni.au.app.kotlintodosampleapp.domain.ReminderRepository
import javax.inject.Inject

class CreateReminderPresenter<ViewSurface> @Inject constructor(repository: ReminderRepository): BasePresenter<ViewSurface>(), Presenter<ViewSurface> {

    var viewSurface : ViewSurface? = null
    lateinit var repository: ReminderRepository

    override fun onStart(view: ViewSurface) {
        super.onStart(view)
        viewSurface = view
        this.repository = repository
    }

    interface ViewSurface {
    }
}
