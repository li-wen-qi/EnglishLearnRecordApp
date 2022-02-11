package com.example.record

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.record.databinding.RecordHolderBinding

/**
 * 邮箱：328073180@qq.com
 * 描述：热门话题列表
 */
class RecordViewHolder(
    parent: ViewGroup,
    private val viewBinding: RecordHolderBinding = RecordHolderBinding.inflate(LayoutInflater.from(parent.context), parent,false)
) : RecyclerView.ViewHolder(viewBinding.root){
    fun bind(item: String) {
        viewBinding.tvDate.text = item
    }
}