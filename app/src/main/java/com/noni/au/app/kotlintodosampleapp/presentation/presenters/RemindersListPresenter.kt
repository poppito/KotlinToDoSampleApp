package com.noni.au.app.kotlintodosampleapp.presentation.presenters

import com.noni.au.app.kotlintodosampleapp.base.BasePresenter
import javax.inject.Inject


class RemindersListPresenter @Inject constructor() : BasePresenter<RemindersListPresenter.ViewSurface>() {
    override fun onStart(v: ViewSurface) {
    }

    override fun onStop(v: ViewSurface) {
    }

    interface ViewSurface
}