package com.example.mystory

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.security.AccessControlContext
import kotlin.random.Random

class CustomAdapter(val storiesLis:ArrayList<Story>,val context: Context)
    :RecyclerView.Adapter<CustomAdapter.DataHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {

        val dataHolder = DataHolder(LayoutInflater.from(parent.context).inflate
            (R.layout.custom_layout,parent,false))

        return dataHolder
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val story =storiesLis[position]
        holder.storyTitle.text=story.title
        holder.storySubTitle.text= story.subtitle
        holder.storyLetter.text=story.title.first().toString()   // or title[0]

        generateColors(holder,position)
        holder.itemView.setOnClickListener{
           val i=Intent(context,StoryDetailsActivity::class.java)
            i.putExtra("title",story.title)
            i.putExtra("desc",story.description)
            context.startActivity(i)
        }

    }

    private fun generateColors(holder:DataHolder, position:Int){
      val r = java.util.Random()
      val red = r.nextInt(255+position)
      val green=r.nextInt(255-position+1)
      val blue=r.nextInt(255+position+1)
        holder.cardViewLetter.setCardBackgroundColor(Color.rgb(red, green, blue))

    }

    override fun getItemCount(): Int {
        return storiesLis.size  // or  storiesLis.count()
    }


    class DataHolder (item: View):RecyclerView.ViewHolder(item){
        val storyTitle:TextView=item.findViewById(R.id.tvTitle)
        val storySubTitle:TextView=item.findViewById(R.id.tvSupTitle)
        val storyLetter:TextView=item.findViewById(R.id.tvStoryLetter)
        val cardViewLetter:CardView=item.findViewById(R.id.circle)

    }
}