package com.ngangavictor.alc5project.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ngangavictor.alc5project.R

class SkillHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    val textViewName: TextView = itemView.findViewById(R.id.textViewName) as TextView
    val textViewHours: TextView = itemView.findViewById(R.id.textViewHours) as TextView

    val imageView: ImageView = itemView.findViewById(R.id.imageView) as ImageView

}