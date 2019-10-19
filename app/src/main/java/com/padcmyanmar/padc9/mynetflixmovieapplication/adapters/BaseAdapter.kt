package com.padcmyanmar.padc9.mynetflixmovieapplication.adapters

import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padc9.mynetflixmovieapplication.viewholders.BaseViewHolder

abstract class BaseAdapter<VH: BaseViewHolder<T>, T>: RecyclerView.Adapter<VH>() {

    private var dataList: MutableList<T> = ArrayList()

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.data = dataList[position]
    }

    fun setNewData(newData: MutableList<T>){
        dataList = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: MutableList<T>){
        dataList.addAll(newData)
        notifyDataSetChanged()
    }
}