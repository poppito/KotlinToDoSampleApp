package com.noni.au.app.kotlintodosampleapp.injection

import com.noni.au.app.kotlintodosampleapp.presentation.view.fragments.CreateReminderFragment
import com.noni.au.app.kotlintodosampleapp.presentation.view.fragments.PagerFragment
import dagger.Component

@PerScreen
@Component (modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun inject(fragment: CreateReminderFragment)
    fun inject(fragment: PagerFragment)
}