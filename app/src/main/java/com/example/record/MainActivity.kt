package com.example.record

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.record.RecordHelper.isAlreadCheckedToday
import com.example.record.RecordHelper.readRecord
import com.example.record.RecordHelper.saveRecord
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val numRes = mutableListOf(R.mipmap.num0, R.mipmap.num1, R.mipmap.num2, R.mipmap.num3,R.mipmap.num4, R.mipmap.num5, R.mipmap.num6, R.mipmap.num7, R.mipmap.num8, R.mipmap.num9)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    private fun initView(){
        SystemOperatorGlobalUtils.setStatusBarColor(this, R.color.white)
        SystemOperatorGlobalUtils.changStatusIconCollor(this, true)
        if(isAlreadCheckedToday(this)){
            updateView()
        }
        btnCheckIn.setOnClickListener {
            updateView()
        }
        lottieAnimationView.setOnClickListener {
            updateView()
        }
        btnRecordList.setOnClickListener {
            RecordListActivity.start(this)
        }
    }

    private fun updateView(){
        if(btnCheckIn.visibility != View.INVISIBLE) btnCheckIn.visibility = View.INVISIBLE
        if(lottieAnimationView.visibility != View.VISIBLE) lottieAnimationView.visibility = View.VISIBLE
        lottieAnimationView.playAnimation()
        saveRecord(this)
        when(val count = readRecord(this).size){
            in 0 .. 9 ->{
                imgvCountGe.setImageResource(numRes[count])
            }
            in 10 .. 99 ->{
                imgvCountGe.setImageResource(numRes[count%10])
                imgvCountShi.setImageResource(numRes[count/10%10])
                imgvCountShi.visibility = View.VISIBLE
            }
            in 100 .. 999 ->{
                imgvCountGe.setImageResource(numRes[count%10])
                imgvCountShi.setImageResource(numRes[count/10%10])
                imgvCountBai.setImageResource(numRes[count/100])
                imgvCountShi.visibility = View.VISIBLE
                imgvCountBai.visibility = View.VISIBLE
            }
            in 1000 .. 9999 ->{
                imgvCountGe.setImageResource(numRes[count%10])
                imgvCountShi.setImageResource(numRes[count/10%10])
                imgvCountBai.setImageResource(numRes[count/100%10])
                imgvCountQian.setImageResource(numRes[count/1000])
                imgvCountShi.visibility = View.VISIBLE
                imgvCountBai.visibility = View.VISIBLE
                imgvCountQian.visibility = View.VISIBLE
            }
            else ->{
                imgvCountGe.setImageResource(numRes[count%10])
                imgvCountShi.setImageResource(numRes[count/10%10])
                imgvCountBai.setImageResource(numRes[count/100%10])
                imgvCountQian.setImageResource(numRes[count/1000%10])
                imgvCountWan.setImageResource(numRes[count/10000])
                imgvCountShi.visibility = View.VISIBLE
                imgvCountBai.visibility = View.VISIBLE
                imgvCountQian.visibility = View.VISIBLE
                imgvCountWan.visibility = View.VISIBLE
            }
        }
    }

}