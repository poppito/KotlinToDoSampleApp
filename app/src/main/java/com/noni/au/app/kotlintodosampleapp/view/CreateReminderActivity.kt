package com.noni.au.app.kotlintodosampleapp.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.noni.au.app.kotlintodosampleapp.R
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import com.noni.au.app.kotlintodosampleapp.base.BaseActivity
import com.noni.au.app.kotlintodosampleapp.injection.AppModule
import com.noni.au.app.kotlintodosampleapp.injection.DaggerAppComponent
import com.noni.au.app.kotlintodosampleapp.presentation.CreateReminderPresenter
import com.noni.au.app.kotlintodosampleapp.presentation.CreateReminderPresenter.ViewSurface
import kotlinx.android.synthetic.main.activity_create_reminder.*
import javax.inject.Inject

class CreateReminderActivity : BaseActivity<CreateReminderPresenter<ViewSurface>, ViewSurface>(), CreateReminderPresenter.ViewSurface, TextWatcher {
    private val TAG = "createreminders"

    @Inject
    lateinit var presenter: CreateReminderPresenter<ViewSurface>
    private var titleTextEntered = false
    private var contentTextEntered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_reminder)
        inject()
        setWatchers()
        presenter.onStart(this)
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

    private fun enableButton(enable : Boolean) {
        presenter.driveButtonStateLogic(enable)
    }

    //endregion

    private fun inject() {
        DaggerAppComponent.builder()
                .appModule(AppModule(application as KotlinSampleToDoApp))
                .build()
                .getActivityComponent()
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
            titleTextEntered = true
        } else if (s?.hashCode() == et_content.hashCode()) {
            contentTextEntered = true
        } else if (et_title.text.isEmpty()) {
            titleTextEntered = false
        } else if (et_content.text.isEmpty()) {
            contentTextEntered = false
        }
        enableButton(titleTextEntered && contentTextEntered)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //not required but added by the textwatcher inteface
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //not required but added by the textwatcher inteface
    }

    //endregion

    //region viewsurface
    override fun createReminder(title: String, content: String) {
    }

    override fun validateInput() {
    }
    override fun enableButtonState(enable: Boolean) {
        btn_submit.isEnabled = enable
    }
}
