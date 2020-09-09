package com.ngangavictor.alc5project.utils

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Gads {

    @GET("/api/hours")
    fun getHours(): Call<List<HoursModel>>

    @GET("/api/skilliq")
    fun getSkill(): Call<List<SkillIqModel>>

    companion object {

        fun create(): Gads {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://gadsapi.herokuapp.com")
                .build()
            return retrofit.create(Gads::class.java)

        }
    }

}