package com.ogungor.daytodaysetting.main

import android.os.Bundle
import android.widget.Button
import com.ogungor.daytodaysetting.R
import com.ogungor.daytodaysetting.activity.BaseActivity
import com.ogungor.daytodaysetting.util.extentions.launchMainToExchangeDayActivity
import com.ogungor.daytodaysetting.util.extentions.launchMainToGoldDayActivity

class MainActivity : BaseActivity(),MainActivityContract.View{
    private lateinit var goldDayButton:Button
    private lateinit var exchangeDayButton:Button
    private lateinit var mainActivityPresenter:MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityPresenter=MainActivityPresenter().apply {
            setView(this@MainActivity)
            create()

        }

    }
    override fun getLayout(): Int = R.layout.activity_main


    override fun initUi() {
        goldDayButton=findViewById(R.id.gold_day_button)
        exchangeDayButton=findViewById(R.id.exchange_day_button)
        initClickListener()
    }

    override fun initClickListener() {
       goldDayButton.setOnClickListener{
            intentMainToGoldDay()
       }

        exchangeDayButton.setOnClickListener{
            intentMainToExchangeDay()
        }
    }

    override fun intentMainToGoldDay() {
        launchMainToGoldDayActivity()
    }

    override fun intentMainToExchangeDay() {
        launchMainToExchangeDayActivity()
    }





}