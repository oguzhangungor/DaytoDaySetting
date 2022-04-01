package com.ogungor.daytodaysetting.personEnter.personlist

interface PersonListFragmentContract {

    interface Presenter {

        fun create()

        fun setView(view: PersonListFragmentContract.View)

        fun destroy()
    }

    interface View {

        fun initUi()

        fun initViewModel()
    }

}