package com.noni.au.app.kotlintodosampleapp.presentation.presenters

import com.noni.au.app.kotlintodosampleapp.base.BasePresenter
import com.noni.au.app.kotlintodosampleapp.data.ToDoItem
import com.noni.au.app.kotlintodosampleapp.domain.facades.CreateToDoItemFacade
import io.reactivex.disposables.Disposable
import javax.inject.Inject


class RemindersListPresenter @Inject constructor(private val facade: CreateToDoItemFacade) : BasePresenter<RemindersListPresenter.ViewSurface>() {

    lateinit var view: ViewSurface
    private var getAllToDosDisposable: Disposable? = null

    override fun onStart(v: ViewSurface) {
        view = v
        getAllReminders()
    }

    //region private

    private fun getAllReminders() {
        view.showLoader(true)
        getAllToDosDisposable = facade.getAllItems()
                .doFinally { view.showLoader(false) }
                .subscribe(
                        { items ->
                            if (items.isNotEmpty()) {
                                view.showReminders(true)
                                view.renderReminders(items)
                            }
                        },
                        {

                        }
                )
    }

    //endregion

    override fun onStop(v: ViewSurface) {
        getAllToDosDisposable?.dispose()
    }

    interface ViewSurface {
        fun showLoader(show: Boolean)
        fun showReminders(show: Boolean)
        fun renderReminders(items: List<ToDoItem>)
    }
}