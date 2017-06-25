package com.noni.au.app.kotlintodosampleapp.presentation.view.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.noni.au.app.kotlintodosampleapp.presentation.view.fragments.CreateToDoItemFragment
import com.noni.au.app.kotlintodosampleapp.presentation.view.fragments.ToDoItemListFragment

class FragPagerAdapter(fragmentManager : FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    val frag1 = CreateToDoItemFragment()
    val frag2 = ToDoItemListFragment()

    override fun getItem(position: Int): Fragment {
        if (position == 0) return frag1 else return frag2
    }

    override fun getCount(): Int {
        return 2
    }
}