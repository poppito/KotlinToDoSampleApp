package com.noni.au.app.kotlintodosampleapp.presentation.presenters

import android.util.Log
import com.noni.au.app.kotlintodosampleapp.base.BasePresenter
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
        getAllToDosDisposable = facade.getAllItems()
                .subscribe(
                        { items ->
                            items.forEach { item ->
                                Log.v("bleh", item.title)
                            }
                        },
                        {

                        }
                )
    }

    //endregion

    override fun onStop(v: ViewSurface) {
    }

    interface ViewSurface
}