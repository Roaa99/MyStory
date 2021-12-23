package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddStoryActivity : AppCompatActivity() {

    private var editTextTitle:EditText?=null
    private var editTextSubTitle:EditText?=null
    private var editeTextDesc:EditText?=null
    private var buttonAddStory:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)

        connectViews()
        fieldsValidation()
    }

    private fun fieldsValidation() {
        buttonAddStory?.setOnClickListener{
          val title=editTextTitle?.text.toString()
          val subtitle=editTextSubTitle?.text.toString()
          val desc=editeTextDesc?.text.toString()

            when {
                title.isEmpty() -> {
                    editTextTitle?.error = getString(R.string.enter_title)
                }
                subtitle.isEmpty() -> {
                    editTextSubTitle?.error=getString(R.string.enter_subtitle)
                }
                desc.isEmpty() -> {
                    editeTextDesc?.error=getString(R.string.enter_description)
                }
                else ->{//all fields have data
                    this.finish()
                    val i=Intent(this,MainActivity::class.java)
                    i.putExtra("title",title)
                    i.putExtra("subtitle",subtitle)
                    i.putExtra("desc",desc)
                    startActivity(i)
                }
                }
        }
    }

    private fun connectViews() {
        editTextTitle=findViewById(R.id.etTitle)
        editTextSubTitle=findViewById(R.id.etSubTitle)
        editeTextDesc=findViewById(R.id.etDescription)
        buttonAddStory=findViewById(R.id.btnAdd)
    }


}