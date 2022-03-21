package com.ogungor.daytodaysetting.exchangedaydetails

interface ExchangeDayDetailsContract {

    interface Presenter{

        fun create()

        fun setView(View:ExchangeDayDetailsContract.View)

        fun finish()

    }

    interface View {

        fun initUi()

        fun personEnterButtonClick()

        fun intentExchangeDayToPersonEnterFragment()
    }
}