package com.example.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class StoryDetailsActivity : AppCompatActivity() {

    private var toolbarView:Toolbar?=null
    private var textViewStoryDesc:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details)


        connectViews()

        setSupportActionBar(toolbarView)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //استقبال المتغيرات من الواجهة السابقة

        val title=intent.getStringExtra("title")
        val description= intent.getStringExtra("desc")

        supportActionBar?.title=title

        //دالة خاصة بالرجوع للواجهة السابقة عند الضغط على toolbar
        toolbarView?.setNavigationOnClickListener {
            onBackPressed()
        }
        // لعرض القصة داخل textview
        textViewStoryDesc?.text=description

        //دالة خاصة بالانتقال لاسفل النص.. لازم اعدل في ملف xml اضيف خاصية scrollBar و احط high و اخليها 0dp
        textViewStoryDesc?.movementMethod=ScrollingMovementMethod()
    }

    private fun connectViews() {
        toolbarView=findViewById(R.id.toolbar)
        textViewStoryDesc=findViewById(R.id.tvDesc)
    }

}