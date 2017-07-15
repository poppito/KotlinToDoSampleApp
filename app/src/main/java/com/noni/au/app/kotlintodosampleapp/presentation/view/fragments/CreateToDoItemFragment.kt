package com.noni.au.app.kotlintodosampleapp.presentation.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noni.au.app.kotlintodosampleapp.R
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import com.noni.au.app.kotlintodosampleapp.injection.DaggerFragmentComponent
import com.noni.au.app.kotlintodosampleapp.injection.FragmentModule
import com.noni.au.app.kotlintodosampleapp.presentation.presenters.CreateToDoItemPresenter
import kotlinx.android.synthetic.main.frag_create_reminder.*
import javax.inject.Inject

class CreateToDoItemFragment : Fragment(), CreateToDoItemPresenter.ViewSurface, TextWatcher, RefreshableFragment {

    @Inject
    lateinit var presenter: CreateToDoItemPresenter
    private var titleTextEntered = false
    private var contentTextEntered = false
    private var title = ""
    private var content = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        presenter.onStart(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.frag_create_reminder, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWatchers()
        setListeners()
    }

    //region private

    private fun setListeners() {
        btn_submit.setOnClickListener { presenter.onSubmitButtonClick(title, content) }
    }

    private fun setWatchers() {
        et_title.addTextChangedListener(this)
        et_content.addTextChangedListener(this)
    }

    //endregion

    private fun inject() {
        val app = activity.application as KotlinSampleToDoApp
        DaggerFragmentComponent.builder()
                .appComponent(app.mAppComponent)
                .fragmentModule(FragmentModule(this))
                .build()
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
            if (s.isNotEmpty()) {
                titleTextEntered = true
                title = et_title.text.toString()
            } else {
                titleTextEntered = false
                title = ""
            }
        } else if (s?.hashCode() == et_content.text.hashCode()) {
            if (s.isNotEmpty()) {
                contentTextEntered = true
                content = et_content.text.toString()
            } else {
                contentTextEntered = false
                content = ""
            }
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

    override fun validateInput() {
    }

    override fun enableButtonState(enable: Boolean) {
        btn_submit.isEnabled = enable
    }

    //endregion


    //region refreshablefragment

    override fun refresh() {

    }

    //endregion
}
