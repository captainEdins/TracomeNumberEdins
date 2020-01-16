package com.example.tracomnumber

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.text.trim

class input : AppCompatActivity() {

    companion object {

        const val EXTRA_NAME = "edins"
        const val EXTRA_DOB = "1-8-2020"
        const val EXTRA_AREA = "ruai"
        const val EXTRA_ID = "356767687"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val save = findViewById<Button>(R.id.save)
        val name = findViewById<EditText>(R.id.ename)
        val dob = findViewById<EditText>(R.id.edob)
        val area = findViewById<EditText>(R.id.earea)
        val ID = findViewById<EditText>(R.id.eID)

        var getName: String
        var getDob: String
        var getArea: String
        var getId: String




        save.setOnClickListener {

            getName=name.text.toString().trim()
            getDob=dob.text.toString().trim()
            getArea=area.text.toString().trim()
            getId=ID.text.toString().trim()

            if(getName.isBlank() || getDob.isBlank() || getArea.isBlank() || getId.isBlank() ){
                Toast.makeText(this, "fill all fields!", Toast.LENGTH_SHORT).show()
            }else {
                val data = Intent().apply {putExtra(EXTRA_NAME, getName); putExtra(EXTRA_DOB, getDob); putExtra(EXTRA_AREA, getArea); putExtra(EXTRA_ID, getId) }

                setResult(Activity.RESULT_OK, data)
                finish()
            }

        }
    }

}
