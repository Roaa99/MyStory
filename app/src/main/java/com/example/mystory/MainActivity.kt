package com.example.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var textViewEmail:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val email=intent.getStringExtra("email")

        connectViews()
// لازم نستدعي دالة connectview قبل نحط لقيمية في textViewEmail
        textViewEmail?.text= email
    }

    private fun connectViews() {
        textViewEmail=findViewById(R.id.tvEmail)
    }
}