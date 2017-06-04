package com.noni.au.app.kotlintodosampleapp.presentation.view.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.noni.au.app.kotlintodosampleapp.presentation.view.fragments.CreateReminderFragment
import com.noni.au.app.kotlintodosampleapp.presentation.view.fragments.RemindersListFragment

class FragPagerAdapter(fragmentManager : FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    val frag1 = CreateReminderFragment()
    val frag2 = RemindersListFragment()

    override fun getItem(position: Int): Fragment {
        if (position == 0) return frag1 else return frag2
    }

    override fun getCount(): Int {
        return 2
    }
}