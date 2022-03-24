package com.ogungor.daytodaysetting.personEnter

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.ogungor.daytodaysetting.R
import com.ogungor.daytodaysetting.activity.BaseActivity

class PersonEnterActivity : BaseActivity() {

    override fun getLayout(): Int = R.layout.person_enter_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.person_enter_layout)
        var editTextList: ArrayList<EditText>?=ArrayList()
        var editTextNameList: ArrayList<String>? =ArrayList()
        val outLinearLayout = findViewById<LinearLayout>(R.id.outLinearLayout)
        val personCount = intent.getIntExtra("PersonCount", 2)
        val editTextName = 0

        for (i in 1..personCount) {
            val editLinearLayout = LinearLayout(this)
            val textView = TextView(this)
            val editText = EditText(this)

            editText.id = editTextName + i

            editText.setHint(" " + editText.id.toString())

            editLinearLayout.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            editText.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            textView.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            textView.setText("$i")
            editText.setPadding(5, 5, 5, 5)
            textView.setPadding(4, 4, 4, 4)

            editLinearLayout.addView(textView)
            editLinearLayout.addView(editText)

            outLinearLayout.addView(editLinearLayout)
            editTextList?.add(editText)

        }
        val button = findViewById<Button>(R.id.remix)
        button.setOnClickListener {
            for (i in 1..personCount) {
                editTextNameList?.add(editTextList?.get(i-1)?.text.toString())
            }

            for (i in 1..personCount) {

                val textViewNameList = TextView(this)
                textViewNameList.text=(editTextNameList?.get(i-1).toString())
                textViewNameList.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                outLinearLayout.addView(textViewNameList)
            }



        }
    }

}