package com.example.saba.sampleKotlin.custom.adapter.base

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saba.sampleKotlin.base.annotations.LayoutResourceId

abstract class BaseAdapter<D, T : BaseViewHolder<D>> : RecyclerView.Adapter<T>() {

    private var dataList = emptyList<D>()
    private var itemClickListener: ((D) -> Unit) = {}

    fun setClickListener(listener: (D) -> Unit) {
        itemClickListener = listener
    }

    fun updateData(dataList: List<D>) {
        val diffUtilCallback = BaseDiffUtilCallback(this.dataList, dataList)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtilCallback,true)
        this.dataList = dataList
        diffUtilResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        val layoutResourceId = javaClass.getAnnotation(LayoutResourceId::class.java)
        val view = LayoutInflater.from(parent.context).inflate(layoutResourceId.value, parent, false)
        return onViewInflated(view)
    }

    abstract fun onViewInflated(view: View): T

    override fun onBindViewHolder(viewHolder: T, position: Int) {
        viewHolder.bind(dataList[position], itemClickListener)
    }

    override fun getItemCount(): Int = dataList.size

}