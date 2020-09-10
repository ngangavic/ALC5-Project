package com.ngangavictor.alc5project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.ActionBar

class SubmitActivity : AppCompatActivity() {

    private lateinit var imageViewBack: ImageView

    private lateinit var editTextFName:EditText
    private lateinit var editTextLName:EditText
    private lateinit var editTextEmail:EditText
    private lateinit var editTextGithubLink:EditText

    private lateinit var buttonSubmit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_submit_action_bar)
        supportActionBar?.elevation = 0F
        val view = supportActionBar?.customView
        imageViewBack = view!!.findViewById(R.id.imageViewBack)

        editTextFName=findViewById(R.id.editTextFName)
        editTextLName=findViewById(R.id.editTextLName)
        editTextEmail=findViewById(R.id.editTextEmail)
        editTextGithubLink=findViewById(R.id.editTextGithubLink)

        buttonSubmit=findViewById(R.id.buttonSubmit)

        imageViewBack.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}