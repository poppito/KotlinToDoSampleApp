package com.noni.au.app.kotlintodosampleapp.presentation.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noni.au.app.kotlintodosampleapp.R
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import com.noni.au.app.kotlintodosampleapp.data.ToDoItem
import com.noni.au.app.kotlintodosampleapp.injection.DaggerFragmentComponent
import com.noni.au.app.kotlintodosampleapp.injection.FragmentModule
import com.noni.au.app.kotlintodosampleapp.presentation.presenters.RemindersListPresenter
import com.noni.au.app.kotlintodosampleapp.presentation.view.adapters.ToDoListRecyclerAdapter
import kotlinx.android.synthetic.main.frag_reminders_list.*
import javax.inject.Inject


class ToDoItemListFragment : Fragment(), RemindersListPresenter.ViewSurface {

    @Inject
    lateinit var presenter: RemindersListPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.frag_reminders_list, container, false)
        inject()
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onStart(this)
        initialiseRecyclerView()
    }

    //region private

    private fun inject() {
        val app = activity.application as KotlinSampleToDoApp
        DaggerFragmentComponent.builder()
                .appComponent(app.mAppComponent)
                .fragmentModule(FragmentModule(this))
                .build()
                .inject(this)
    }

    private fun initialiseRecyclerView() {
        recycler_todo_items.layoutManager = LinearLayoutManager(activity.applicationContext)
    }

    //endregion


    //region viewsurface

    override fun showLoader(show: Boolean) {
        loader_reminder_list.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showReminders(show: Boolean) {
        recycler_todo_items.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun renderReminders(items: List<ToDoItem>) {
        val adapter = ToDoListRecyclerAdapter(items)
        recycler_todo_items.adapter = adapter
    }

    //endregion
}