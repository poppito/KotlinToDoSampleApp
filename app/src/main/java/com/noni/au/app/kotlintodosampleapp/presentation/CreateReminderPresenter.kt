package com.noni.au.app.kotlintodosampleapp.presentation

import com.noni.au.app.kotlintodosampleapp.base.BasePresenter
import com.noni.au.app.kotlintodosampleapp.domain.facades.CreateReminderFacade
import javax.inject.Inject

class CreateReminderPresenter @Inject constructor(facade: CreateReminderFacade) : BasePresenter<CreateReminderPresenter.ViewSurface>() {

    lateinit private var viewSurface: CreateReminderPresenter.ViewSurface

    override fun onStart(view: CreateReminderPresenter.ViewSurface) {
        viewSurface = view
    }

    override fun onStop(v: ViewSurface) {
    }

    //region ui interaction

    fun onSubmitButtonClick() {
        viewSurface.createReminder()
    }

    fun driveButtonStateLogic(enable: Boolean) {
        viewSurface.enableButtonState(enable)
    }

    //endregion

    interface ViewSurface {
        fun createReminder()
        fun validateInput()
        fun enableButtonState(enable: Boolean)
    }
}
