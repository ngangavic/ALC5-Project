package com.ngangavictor.alc5project.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ngangavictor.alc5project.R
import com.ngangavictor.alc5project.holders.SkillHolder
import com.ngangavictor.alc5project.utils.SkillIqModel

class SkillsRecyclerViewAdapter(private val skills: List<SkillIqModel>) :
    RecyclerView.Adapter<SkillHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillHolder {
        val viewHolder: SkillHolder

        val layoutView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_skill_iq_leaders, parent, false)
        viewHolder = SkillHolder(layoutView)
        return viewHolder
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SkillHolder, position: Int) {
        holder.textViewHours.text =
            skills[position].score + " learning hours," + skills[position].country
        holder.textViewName.text = skills[position].name
    }

    override fun getItemCount(): Int {
        return skills.size
    }


}