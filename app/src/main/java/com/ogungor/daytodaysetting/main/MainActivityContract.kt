package com.ogungor.daytodaysetting.main

interface MainActivityContract {

    interface Presenter {
        fun create()
        fun setView(view:MainActivityContract.View)

        fun destroy()
    }

    interface View {
        fun initUi()

        fun initClickListener()

        fun intentMainToGoldDay()

        fun intentMainToExchangeDay()
    }
}