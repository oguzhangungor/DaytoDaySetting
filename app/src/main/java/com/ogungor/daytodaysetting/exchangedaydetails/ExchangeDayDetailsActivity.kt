package com.ogungor.daytodaysetting.exchangedaydetails

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.ogungor.daytodaysetting.R
import com.ogungor.daytodaysetting.activity.BaseActivity

class ExchangeDayDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dayListSpinner= resources.getStringArray(R.array.PersonCount)
        val ExchangeListSpinner= resources.getStringArray(R.array.ExchangeList)
        val personSpinner=findViewById<Spinner>(R.id.person_spinner)
        val exchangeSpinner=findViewById<Spinner>(R.id.exchange_spinner)
        if(personSpinner!=null)
        {
            val personAdapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,dayListSpinner)
            personSpinner.adapter=personAdapter
            val exchangeAdapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,ExchangeListSpinner)
            exchangeSpinner.adapter=exchangeAdapter

            personSpinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    if(p2!=0){
                        Toast.makeText(this@ExchangeDayDetailsActivity,getString(R.string.selected_item)+" "+ dayListSpinner[p2],
                            Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        }

    }

    override fun getLayout(): Int= R.layout.exchange_day_detail

}