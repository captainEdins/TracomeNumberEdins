package com.example.tracomnumber.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tracomnumber.R
import com.example.tracomnumber.model.people

class people_adapter : RecyclerView.Adapter<people_adapter.NoteHolder>() {

    private var peoples: List<people> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.display, parent, false)

        return NoteHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote = peoples[position]

        holder.name.text = currentNote.name
        holder.dob.text = currentNote.dob
        holder.area.text = currentNote.area
        holder.id.text = currentNote.N_ID
    }

    override fun getItemCount(): Int {
        return peoples.size
    }

    fun setNotes(people: List<people>) {

        this.peoples = people
        notifyDataSetChanged()
    }

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name)
        var dob: TextView = itemView.findViewById(R.id.dob)
        var area: TextView = itemView.findViewById(R.id.area)
        var id: TextView = itemView.findViewById(R.id.id)

    }
}