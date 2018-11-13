package com.noni.au.app.kotlintodosampleapp.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.noni.au.app.kotlintodosampleapp.R
import com.noni.au.app.kotlintodosampleapp.app.KotlinSampleToDoApp
import com.noni.au.app.kotlintodosampleapp.injection.DaggerFragmentComponent
import com.noni.au.app.kotlintodosampleapp.injection.FragmentModule
import com.noni.au.app.kotlintodosampleapp.presentation.presenters.PagerContainerPresenter
import com.noni.au.app.kotlintodosampleapp.presentation.view.adapters.FragPagerAdapter
import kotlinx.android.synthetic.main.frag_pager_container.*
import javax.inject.Inject

class PagerFragment : Fragment(), PagerContainerPresenter.ViewSurface {

    @Inject
    lateinit var presenter : PagerContainerPresenter

    private var adapter : FragPagerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.frag_pager_container, container, false)
        inject()
        presenter.onStart(this)
        return rootView
    }

    private fun inject() {
        val app = activity?.application as KotlinSampleToDoApp
        DaggerFragmentComponent.builder()
                .appComponent(app.mAppComponent)
                .fragmentModule(FragmentModule(this))
                .build()
                .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FragPagerAdapter(fragmentManager!!)
        pager_frags.adapter = adapter
    }
}