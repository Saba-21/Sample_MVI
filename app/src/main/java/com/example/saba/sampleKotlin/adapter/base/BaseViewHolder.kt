package com.example.saba.sampleKotlin.adapter.base

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun render(item: T, vararg listeners: ((T) -> Unit))

}