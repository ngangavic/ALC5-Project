package com.ngangavictor.alc5project.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ngangavictor.alc5project.R
import com.ngangavictor.alc5project.adapters.HoursRecyclerViewAdapter
import com.ngangavictor.alc5project.adapters.SkillsRecyclerViewAdapter
import com.ngangavictor.alc5project.utils.Gads
import com.ngangavictor.alc5project.utils.HoursModel
import com.ngangavictor.alc5project.utils.SkillIqModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    lateinit var recyclerView:RecyclerView
    lateinit var hoursRecyclerViewAdapter: HoursRecyclerViewAdapter
    lateinit var skillsRecyclerViewAdapter: SkillsRecyclerViewAdapter

    val gadsHours = Gads.create().getHours()
    val gadsSkill = Gads.create().getSkill()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    if (sectionNumber==1){
                        gadsHours.enqueue( object : Callback<List<HoursModel>> {
                            override fun onResponse(call: Call<List<HoursModel>>?, response: Response<List<HoursModel>>?) {

                                if(response?.body() != null)
                                    Log.e("HOURS",response.body()!!.toString())
                    hoursRecyclerViewAdapter= HoursRecyclerViewAdapter(response!!.body()!!)
                                hoursRecyclerViewAdapter.notifyDataSetChanged()
                                recyclerView.adapter = hoursRecyclerViewAdapter
                            }

                            override fun onFailure(call: Call<List<HoursModel>>?, t: Throwable?) {

                            }
                        })
                    }else if (sectionNumber==2){
                        gadsSkill.enqueue( object : Callback<List<SkillIqModel>> {
                            override fun onResponse(call: Call<List<SkillIqModel>>?, response: Response<List<SkillIqModel>>?) {

                                if(response?.body() != null)
                                    Log.e("SKILL",response!!.body()!![0].toString())
                                skillsRecyclerViewAdapter= SkillsRecyclerViewAdapter(response!!.body()!!)
                                skillsRecyclerViewAdapter.notifyDataSetChanged()
                                recyclerView.adapter = skillsRecyclerViewAdapter
                            }

                            override fun onFailure(call: Call<List<SkillIqModel>>?, t: Throwable?) {

                            }
                        })
                    }
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}