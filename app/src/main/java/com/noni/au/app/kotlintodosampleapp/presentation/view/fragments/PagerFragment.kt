package com.noni.au.app.kotlintodosampleapp.presentation.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noni.au.app.kotlintodosampleapp.R
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import com.noni.au.app.kotlintodosampleapp.injection.AppModule
import com.noni.au.app.kotlintodosampleapp.injection.DaggerAppComponent
import com.noni.au.app.kotlintodosampleapp.presentation.presenters.PagerContainerPresenter
import com.noni.au.app.kotlintodosampleapp.presentation.view.adapters.FragPagerAdapter
import kotlinx.android.synthetic.main.frag_pager_container.*
import javax.inject.Inject

class PagerFragment : Fragment(), PagerContainerPresenter.ViewSurface {

    @Inject
    lateinit var presenter : PagerContainerPresenter

    private var adapter : FragPagerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.frag_pager_container, container, false)
        inject()
        presenter.onStart(this)
        return rootView
    }

    private fun inject() {
        DaggerAppComponent.builder()
                .appModule(AppModule(activity.application as KotlinSampleToDoApp))
                .build()
                .getFragmentComponent()
                .inject(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FragPagerAdapter(fragmentManager)
        pager_frags.adapter = adapter
        pager_dots.setupWithViewPager(pager_frags)
    }
}