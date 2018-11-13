package com.noni.au.app.kotlintodosampleapp.injection

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import com.noni.au.app.kotlintodosampleapp.data.ToDoDb
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
    fun getReminderRepository(db: ToDoDb): ToDoItemRepository {
        return ToDoItemManager(db)
    }

    @Provides
    fun getReminderFacade(repository: ToDoItemRepository): CreateToDoItemFacade {
        return CreateToDoItemFacade(repository)
    }

    @Provides
    fun getContext(): FragmentActivity? = fragment.activity

    @Provides
    fun getDb() : ToDoDb {
        val app = fragment.activity?.application as KotlinSampleToDoApp
        return app.mDb
    }
}