package com.ogungor.daytodaysetting.personEnter.personlist

class PersonListFragmentPresenter: PersonListFragmentContract.Presenter {
     private var view:PersonListFragmentContract.View?=null

    override fun create() {
        view?.run {
            initUi()
        }
    }

    override fun setView(view: PersonListFragmentContract.View) {
       this.view=view
    }

    override fun destroy() {
        view=null
    }
}