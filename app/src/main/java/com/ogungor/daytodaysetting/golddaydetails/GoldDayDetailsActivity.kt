package com.ogungor.daytodaysetting.golddaydetails

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.ogungor.daytodaysetting.R
import com.ogungor.daytodaysetting.activity.BaseActivity

class GoldDayDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dayListSpinner= resources.getStringArray(R.array.PersonCount)
        val goldListSpinner= resources.getStringArray(R.array.GoldList)
        val spinner=findViewById<Spinner>(R.id.person_spinner)
        val goldSpinner=findViewById<Spinner>(R.id.gold_spinner)
        if(spinner!=null)
        {
            val personAdapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,dayListSpinner)
            spinner.adapter=personAdapter
            val goldAdapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,goldListSpinner)
            goldSpinner.adapter=goldAdapter

            spinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    if(p2!=0){
                        Toast.makeText(this@GoldDayDetailsActivity,getString(R.string.selected_item)+" "+ dayListSpinner[p2],Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        }

    }

    override fun getLayout(): Int =R.layout.daydetails_layout

}