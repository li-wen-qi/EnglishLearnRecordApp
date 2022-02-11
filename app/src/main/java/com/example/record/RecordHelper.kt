package com.example.record

import android.content.Context
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

/**
 * CreateTime:2022/2/11
 * Creator: liwenqi 328073180@qq.com
 * Description: 读写记录
 */
object RecordHelper {
    fun currentDate():String{
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val date = Date(System.currentTimeMillis())
        return dateFormat.format(date)
    }

    fun saveRecord(context: Context) {
        val pref = context.getSharedPreferences("record", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putLong(currentDate(), System.currentTimeMillis())
        editor.commit()
    }

    fun readRecord(context: Context):MutableList<String>{
        val resultList = mutableListOf<String>()
        val pref = context.getSharedPreferences("record", Context.MODE_PRIVATE)
        pref.all.entries.forEachIndexed { index, entry ->
            Log.d("vvv", "${entry.key}")
            resultList.add(entry.key)
        }
        Log.d("vvv", "${resultList}")
        return resultList
    }

    fun readRecord(context: Context, key:String):Long{
        val pref = context.getSharedPreferences("record", Context.MODE_PRIVATE)

        return pref.getLong(key, 0)
    }

    //今天是否已经签过
    fun isAlreadCheckedToday(context: Context):Boolean{
        if(readRecord(context, currentDate()) > 0) return true
        return false
    }
}