package com.example.record

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecordAdapter : RecyclerView.Adapter<RecordViewHolder>(){
    private var dataList = mutableListOf<String>()
    fun setRecordList(results:List<String>){
        dataList.clear()
        dataList.addAll(results)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder{
        return RecordViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}