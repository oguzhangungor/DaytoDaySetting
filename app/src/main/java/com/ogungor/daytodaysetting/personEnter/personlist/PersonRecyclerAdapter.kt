package com.ogungor.daytodaysetting.personEnter.personlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.daytodaysetting.R

class PersonRecyclerAdapter(private var personList: ArrayList<String>) :RecyclerView.Adapter<PersonRecyclerAdapter.PersonHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.person_name_row,parent,false)
        return PersonHolder(view)
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        val personcount:Int=0
        val current=personList[position]
        holder.run {
            textViewPersonCount.text=(personcount+1).toString()
            textViewPersonName.text=current

        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }


    inner class PersonHolder(view: View): RecyclerView.ViewHolder(view
    ) {
        var textViewPersonCount:TextView=view.findViewById(R.id.person_count_textView_row)
        var textViewPersonName:TextView=view.findViewById(R.id.person_name_textView_row)

    }

}
