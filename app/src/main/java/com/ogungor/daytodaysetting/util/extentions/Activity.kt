package com.ogungor.daytodaysetting.util.extentions

import android.app.Activity
import android.content.Intent
import com.ogungor.daytodaysetting.exchangedaydetails.ExchangeDayDetailsActivity
import com.ogungor.daytodaysetting.golddaydetails.GoldDayDetailsActivity

fun Activity.launchMainToGoldDayActivity(){
    this.startActivity(Intent(this,GoldDayDetailsActivity::class.java))
}

fun Activity.launchMainToExchangeDayActivity(){
    this.startActivity(Intent(this,ExchangeDayDetailsActivity::class.java))
}