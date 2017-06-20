package com.noni.au.app.kotlintodosampleapp.presentation.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noni.au.app.kotlintodosampleapp.R
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import com.noni.au.app.kotlintodosampleapp.injection.DaggerFragmentComponent
import com.noni.au.app.kotlintodosampleapp.injection.FragmentModule
import com.noni.au.app.kotlintodosampleapp.presentation.presenters.RemindersListPresenter
import javax.inject.Inject


class RemindersListFragment : Fragment(), RemindersListPresenter.ViewSurface {

    @Inject
    lateinit var presenter: RemindersListPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.frag_reminders_list, container, false)
        inject()
        presenter.onStart(this)
        return rootView
    }

    private fun inject() {
        val app = activity.application as KotlinSampleToDoApp
        DaggerFragmentComponent.builder()
                .appComponent(app.mAppComponent)
                .fragmentModule(FragmentModule(this))
                .build()
                .inject(this)
    }
}