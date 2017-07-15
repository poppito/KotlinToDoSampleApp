package com.noni.au.app.kotlintodosampleapp.presentation.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noni.au.app.kotlintodosampleapp.R
import com.noni.au.app.kotlintodosampleapp.data.ToDoItem
import kotlinx.android.synthetic.main.list_todo_item.view.*


class ToDoListRecyclerAdapter(private val items: List<ToDoItem>) : RecyclerView.Adapter<ToDoListRecyclerAdapter.ToDoItemViewHolder>() {

    inner class ToDoItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: ToDoItem) {
            view.txt_title.text = item.title
            view.txt_content.text = item.content
        }
    }

    //region lifecycle

    override fun onBindViewHolder(holder: ToDoItemViewHolder?, position: Int) {
        (holder as ToDoItemViewHolder).bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ToDoItemViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_todo_item, parent, false)
        return ToDoItemViewHolder(view)
    }


    //end region
}