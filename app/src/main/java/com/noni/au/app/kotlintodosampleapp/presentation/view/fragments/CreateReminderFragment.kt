package com.noni.au.app.kotlintodosampleapp.presentation.view.fragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noni.au.app.kotlintodosampleapp.R
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import com.noni.au.app.kotlintodosampleapp.injection.AppModule
import com.noni.au.app.kotlintodosampleapp.injection.DaggerAppComponent
import com.noni.au.app.kotlintodosampleapp.presentation.presenters.CreateReminderPresenter
import kotlinx.android.synthetic.main.frag_create_reminder.*
import javax.inject.Inject

class CreateReminderFragment : Fragment(), CreateReminderPresenter.ViewSurface, TextWatcher {

    @Inject
    lateinit var presenter: CreateReminderPresenter
    private var titleTextEntered = false
    private var contentTextEntered = false

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.frag_create_reminder, container, false)
        inject()
        presenter.onStart(this)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWatchers()
        setListeners()
    }

    //region private

    private fun setListeners() {
        btn_submit.setOnClickListener { presenter.onSubmitButtonClick() }
    }

    private fun setWatchers() {
        et_title.addTextChangedListener(this)
        et_content.addTextChangedListener(this)
    }

    //endregion

    private fun inject() {
        DaggerAppComponent.builder()
                .appModule(AppModule(activity.application as KotlinSampleToDoApp))
                .build()
                .getFragmentComponent()
                .inject(this)
    }

    // region lifecycle

    override fun onStart() {
        super.onStart()
    }

    // endregion

    // region textwatcher

    override fun afterTextChanged(s: Editable?) {
        if (s?.hashCode() == et_title.text.hashCode()) {
            if (s.isNotEmpty()) titleTextEntered = true else titleTextEntered = false
        } else if (s?.hashCode() == et_content.text.hashCode()) {
            if (s.isNotEmpty()) contentTextEntered = true else contentTextEntered = false
        }
        presenter.driveButtonStateLogic(titleTextEntered && contentTextEntered)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //not required but added by the textwatcher interface
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //not required but added by the textwatcher inteface
    }

    //endregion

    //region viewsurface
    override fun createReminder() {
    }

    override fun validateInput() {
    }

    override fun enableButtonState(enable: Boolean) {
        btn_submit.isEnabled = enable
    }
}
