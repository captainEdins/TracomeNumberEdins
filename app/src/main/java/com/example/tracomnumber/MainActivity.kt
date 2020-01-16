package com.example.tracomnumber

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tracomnumber.adapter.people_adapter
import com.example.tracomnumber.model.people
import com.example.tracomnumber.viewModel.PeopleViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val ADD_NOTE_REQUEST = 1
    private lateinit var peopleViewModel: PeopleViewModel
    private val adapter = people_adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        buttonAddNote.setOnClickListener {

            startActivityForResult(Intent(this, input::class.java), ADD_NOTE_REQUEST)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

        peopleViewModel = ViewModelProviders.of(this).get(PeopleViewModel::class.java)

        peopleViewModel.getAllNotes().observe(this, Observer<List<people>> {
                e -> adapter.setNotes(e!!) })

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (!(requestCode != ADD_NOTE_REQUEST || resultCode != Activity.RESULT_OK)) {

            val newNote = people(
                data!!.getStringExtra(input.EXTRA_NAME),
                data!!.getStringExtra(input.EXTRA_DOB),
                data!!.getStringExtra(input.EXTRA_AREA),
                data!!.getStringExtra(input.EXTRA_ID)

            )

            peopleViewModel.insert(newNote)

            Toast.makeText(this, "person saved!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "person not saved!", Toast.LENGTH_SHORT).show()
        }


    }
}
