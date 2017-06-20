package com.noni.au.app.kotlintodosampleapp.injection

import android.content.Context
import android.support.v4.app.Fragment
import com.noni.au.app.kotlintodosampleapp.data.ToDoListManager
import com.noni.au.app.kotlintodosampleapp.domain.facades.CreateReminderFacade
import com.noni.au.app.kotlintodosampleapp.domain.repositories.ReminderRepository
import com.noni.au.app.kotlintodosampleapp.presentation.presenters.CreateReminderPresenter
import dagger.Module
import dagger.Provides

@PerScreen
@Module(includes = arrayOf(AppModule::class))
class FragmentModule(private val fragment: Fragment) {
    @Provides
    fun getCreateReminderPresenter(facade: CreateReminderFacade): CreateReminderPresenter {
        return CreateReminderPresenter(facade)
    }

    @Provides
    fun getReminderRepository(context: Context): ReminderRepository {
        return ToDoListManager(context)
    }

    @Provides
    fun getReminderFacade(repository: ReminderRepository, context: Context): CreateReminderFacade {
        return CreateReminderFacade(repository, context)
    }

    @Provides
    fun getContext(): Context = fragment.activity
}