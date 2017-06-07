package com.noni.au.app.kotlintodosampleapp.presentation.presenters

import com.noni.au.app.kotlintodosampleapp.base.BasePresenter
import com.noni.au.app.kotlintodosampleapp.domain.facades.CreateReminderFacade
import javax.inject.Inject

class CreateReminderPresenter @Inject constructor(facade: CreateReminderFacade) : BasePresenter<CreateReminderPresenter.ViewSurface>() {

    lateinit private var viewSurface: ViewSurface
    lateinit private var facade: CreateReminderFacade

    override fun onStart(view: ViewSurface) {
        viewSurface = view
        this.facade = facade
    }

    override fun onStop(v: ViewSurface) {
    }

    //region ui interaction

    fun onSubmitButtonClick(title:String, content:String) {
        facade.createAReminder(title, content)
    }

    fun driveButtonStateLogic(enable: Boolean) {
        viewSurface.enableButtonState(enable)
    }

    //endregion

    interface ViewSurface {
        fun validateInput()
        fun enableButtonState(enable: Boolean)
    }
}
