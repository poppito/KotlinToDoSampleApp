package com.noni.au.app.kotlintodosampleapp.presentation.view.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.noni.au.app.kotlintodosampleapp.presentation.view.fragments.CreateReminderFragment

class FragPagerAdapter(fragmentManager : FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    val frag1 = CreateReminderFragment()

    override fun getItem(position: Int): Fragment {
        return frag1
    }

    override fun getCount(): Int {
        return 2
    }
}