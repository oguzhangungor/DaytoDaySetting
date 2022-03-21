package com.ogungor.daytodaysetting.main

class MainActivityPresenter : MainActivityContract.Presenter {

    private var view: MainActivityContract.View? = null


    override fun setView(view: MainActivityContract.View) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }

    override fun create() {
        view?.apply {
            initUi()
        }
    }
}



