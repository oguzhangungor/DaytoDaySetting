package com.ogungor.daytodaysetting.exchangedaydetails

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.ogungor.daytodaysetting.R
import com.ogungor.daytodaysetting.activity.BaseActivity
import com.ogungor.daytodaysetting.personEnter.PersonEnterActivity

class ExchangeDayDetailsActivity : BaseActivity(), ExchangeDayDetailsContract.View {

    private lateinit var exchangeDayDetailsPresenter: ExchangeDayDetailsContract.Presenter
    private lateinit var dayListSpinner: Array<String>
    private lateinit var exchangeListSpinner: Array<String>
    private lateinit var personSpinner: Spinner
    private lateinit var exchangeSpinner: Spinner
    private lateinit var personEnterButton: Button
    var personSpinnerCount: Int = 0


    override fun getLayout(): Int = R.layout.exchange_day_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exchangeDayDetailsPresenter = ExchangeDayDetailsPresenter().apply {
            setView(this@ExchangeDayDetailsActivity)
            create()
        }
    }

    override fun initUi() {

        dayListSpinner = resources.getStringArray(R.array.PersonCount)
        exchangeListSpinner = resources.getStringArray(R.array.ExchangeList)
        personSpinner = findViewById(R.id.person_spinner)
        exchangeSpinner = findViewById(R.id.exchange_spinner)
        personEnterButton = findViewById(R.id.person_enter_button)

        if (personSpinner != null) {
            val personAdapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_item, dayListSpinner)
            personSpinner.adapter = personAdapter
            val exchangeAdapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_item, exchangeListSpinner)
            exchangeSpinner.adapter = exchangeAdapter

            personSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    personSpinnerCount = p2
                    if (p2 != 0) {
                        Toast.makeText(
                            this@ExchangeDayDetailsActivity,
                            getString(R.string.selected_item) + " " + dayListSpinner[p2],
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }


        }

        personEnterButton.setOnClickListener {
            if (personSpinnerCount < 2) {
                Toast.makeText(
                    this,
                    "Seçilen Kişi Sayısı 2 den büyük olmalıdır",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                personEnterButtonClick()
            }
        }
    }

    override fun personEnterButtonClick() {
        var intent = Intent(this, PersonEnterActivity::class.java)
        intent.putExtra("PersonCount", personSpinnerCount)
        startActivity(intent)
    }

    override fun intentExchangeDayToPersonEnterFragment() {
        TODO("Not yet implemented")
    }

}