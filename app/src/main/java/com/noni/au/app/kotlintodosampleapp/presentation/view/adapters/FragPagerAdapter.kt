package com.noni.au.app.kotlintodosampleapp.presentation.view.adapters


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
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