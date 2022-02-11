package com.example.record

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_record_list.*

/**
 * CreateTime:2022/2/11
 * Creator: liwenqi 328073180@qq.com
 * Description:
 */
class RecordListActivity: AppCompatActivity() {
    private val adapter by lazy { RecordAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_list)
        initView()
    }

    private fun initView(){
        SystemOperatorGlobalUtils.setStatusBarColor(this, R.color.white)
        SystemOperatorGlobalUtils.changStatusIconCollor(this, true)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.itemAnimator = null
        recyclerView.adapter = adapter
        adapter.setRecordList(RecordHelper.readRecord(this))
    }

    companion object{
        fun start(context: Context) {
            val intent = Intent(context, RecordListActivity::class.java)
            context.startActivity(intent)
        }
    }
}