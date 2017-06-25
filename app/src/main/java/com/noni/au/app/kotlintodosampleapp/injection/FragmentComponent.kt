package com.noni.au.app.kotlintodosampleapp.injection

import com.noni.au.app.kotlintodosampleapp.presentation.view.fragments.CreateToDoItemFragment
import com.noni.au.app.kotlintodosampleapp.presentation.view.fragments.PagerFragment
import com.noni.au.app.kotlintodosampleapp.presentation.view.fragments.RemindersListFragment
import dagger.Component

@PerScreen
@Component (dependencies = arrayOf(AppComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun inject(fragment: CreateToDoItemFragment)
    fun inject(fragment: PagerFragment)
    fun inject(fragment: RemindersListFragment)
}