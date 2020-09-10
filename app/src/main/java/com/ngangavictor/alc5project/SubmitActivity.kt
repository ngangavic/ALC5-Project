package com.ngangavictor.alc5project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import com.ngangavictor.alc5project.utils.Gads
import com.ngangavictor.alc5project.utils.Submit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmitActivity : AppCompatActivity() {

    private lateinit var imageViewBack: ImageView

    private lateinit var editTextFName:EditText
    private lateinit var editTextLName:EditText
    private lateinit var editTextEmail:EditText
    private lateinit var editTextGithubLink:EditText

    private lateinit var buttonSubmit:Button

    private lateinit var alertDialog: AlertDialog

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

        buttonSubmit.setOnClickListener {
            confirmAlert()
//            val  email=editTextEmail.text.toString()
//            val  fname=editTextFName.text.toString()
//            val  lname=editTextLName.text.toString()
//            val  github=editTextGithubLink.text.toString()
//            val submitProject = Submit.create().submitProject(email,fname,lname,github)
//            submitProject.enqueue(object :Callback<Void>{
//                override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                    if (response.isSuccessful){
//
//                    }else{
//
//                    }
//                }
//
//                override fun onFailure(call: Call<Void>, t: Throwable) {
//
//                }
//
//            })
//
        }

    }

    private fun confirmAlert(){
        val customLayout=layoutInflater.inflate(R.layout.confirm_alert,null)

        val alert=AlertDialog.Builder(this)
        alert.setCancelable(false)
        alert.setView(customLayout)
        val buttonYes=customLayout.findViewById<Button>(R.id.buttonYes)
        val imageViewCancel=customLayout.findViewById<ImageView>(R.id.imageViewCancel)

        imageViewCancel.setOnClickListener {
            alertDialog.cancel()
        }

        buttonYes.setOnClickListener {
successAlert()
        }

        alertDialog=alert.create()
        alertDialog.show()

    }

    private fun successAlert(){
        val customLayout=layoutInflater.inflate(R.layout.success_alert,null)

        val alert=AlertDialog.Builder(this)
        alert.setView(customLayout)

        alertDialog=alert.create()
        alertDialog.show()
    }

}
