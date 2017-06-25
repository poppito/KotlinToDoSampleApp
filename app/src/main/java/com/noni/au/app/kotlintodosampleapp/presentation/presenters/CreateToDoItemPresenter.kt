package com.noni.au.app.kotlintodosampleapp.presentation.presenters

import com.noni.au.app.kotlintodosampleapp.base.BasePresenter
import com.noni.au.app.kotlintodosampleapp.domain.facades.CreateToDoItemFacade
import javax.inject.Inject

class CreateToDoItemPresenter @Inject constructor(private val facade: CreateToDoItemFacade) : BasePresenter<CreateToDoItemPresenter.ViewSurface>() {

    lateinit private var viewSurface: ViewSurface

    override fun onStart(view: ViewSurface) {
        viewSurface = view
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
