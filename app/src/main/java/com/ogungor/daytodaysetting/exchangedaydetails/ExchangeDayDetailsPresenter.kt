package com.ogungor.daytodaysetting.exchangedaydetails

class ExchangeDayDetailsPresenter: ExchangeDayDetailsContract.Presenter{

   private var view: ExchangeDayDetailsContract.View?=null

    override fun create() {
        view?.apply {
            initUi()
        }
    }

    override fun setView(view: ExchangeDayDetailsContract.View) {
       this.view=view
    }

    override fun finish() {
       view=null
    }
}