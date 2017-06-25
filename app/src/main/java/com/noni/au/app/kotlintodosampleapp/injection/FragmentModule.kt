package com.noni.au.app.kotlintodosampleapp.injection

import android.content.Context
import android.support.v4.app.Fragment
import com.noni.au.app.kotlintodosampleapp.data.ToDoItemManager
import com.noni.au.app.kotlintodosampleapp.domain.facades.CreateToDoItemFacade
import com.noni.au.app.kotlintodosampleapp.domain.repositories.ToDoItemRepository
import com.noni.au.app.kotlintodosampleapp.presentation.presenters.CreateToDoItemPresenter
import dagger.Module
import dagger.Provides

@PerScreen
@Module(includes = arrayOf(AppModule::class))
class FragmentModule(private val fragment: Fragment) {
    @Provides
    fun getCreateReminderPresenter(facade: CreateToDoItemFacade): CreateToDoItemPresenter {
        return CreateToDoItemPresenter(facade)
    }

    @Provides
    fun getReminderRepository(context: Context): ToDoItemRepository {
        return ToDoItemManager(context)
    }

    @Provides
    fun getReminderFacade(repository: ToDoItemRepository): CreateToDoItemFacade {
        return CreateToDoItemFacade(repository)
    }

    @Provides
    fun getContext(): Context = fragment.activity
}