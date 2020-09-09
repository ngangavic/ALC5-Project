package com.ngangavictor.alc5project.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ngangavictor.alc5project.R
import com.ngangavictor.alc5project.holders.HoursHolder
import com.ngangavictor.alc5project.utils.HoursModel

class HoursRecyclerViewAdapter(private val hours: List<HoursModel>) : RecyclerView.Adapter<HoursHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursHolder {
        val viewHolder: HoursHolder

        val layoutView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_learning_leaders, parent, false)
        viewHolder = HoursHolder(layoutView)
        return viewHolder
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HoursHolder, position: Int) {
        holder.textViewHours.text=hours[position].hours+" learning hours,"+hours[position].country
        holder.textViewName.text=hours[position].name
    }

    override fun getItemCount(): Int {
        return hours.size
    }


}