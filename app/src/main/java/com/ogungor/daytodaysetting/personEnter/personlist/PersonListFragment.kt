package com.ogungor.daytodaysetting.personEnter.personlist

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.ogungor.daytodaysetting.R

class PersonListFragment(val personList:ArrayList<String>) : DialogFragment(), PersonListFragmentContract.View{
         private lateinit var personListFragmentPresenter: PersonListFragmentContract.Presenter



    override fun onAttach(context: Context) {
        super.onAttach(context)
        personListFragmentPresenter=PersonListFragmentPresenter().apply {
            setView(this@PersonListFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.person_list_fragment,container,false)
        val outLinearLayout = view.findViewById<LinearLayout>(R.id.fragment_out_linearLayout)

        for (i in 1..personList.size) {
            val editLinearLayout = LinearLayout(context)
            val textViewCount = TextView(context)
            val textViewName= TextView(context)

            editLinearLayout.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            textViewName.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            textViewCount.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            textViewName.setPadding(5, 5, 5, 5)
            textViewCount.setPadding(4, 4, 4, 4)
            textViewCount.text=i.toString()
            textViewName.text=personList.get(i-1)
            editLinearLayout.addView(textViewCount)
            editLinearLayout.addView(textViewName)

            outLinearLayout.addView(editLinearLayout)
        }
        return view



    }

    override fun initUi() {

    }


}