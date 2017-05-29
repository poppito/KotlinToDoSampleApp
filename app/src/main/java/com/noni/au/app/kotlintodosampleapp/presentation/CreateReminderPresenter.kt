package com.noni.au.app.kotlintodosampleapp.presentation

import com.noni.au.app.kotlintodosampleapp.base.BasePresenter
import com.noni.au.app.kotlintodosampleapp.domain.facades.CreateReminderFacade
import javax.inject.Inject

class CreateReminderPresenter<ViewSurface> @Inject constructor(facade: CreateReminderFacade): BasePresenter<ViewSurface>(){

    var viewSurface : ViewSurface? = null

    override fun onStart(view: ViewSurface) {
        viewSurface = view
    }

    override fun onStop(view: ViewSurface) {

    }

    //region ui interaction
    fun createReminder(title: String, content: String) {
    }

    fun onSubmitButtonClick() {
    }

    fun driveButtonStateLogic(enable: Boolean) {
    }

    //endregion

    interface ViewSurface {
        fun createReminder(title: String, content: String)
        fun validateInput()
        fun enableButtonState(enable: Boolean)
    }
}
