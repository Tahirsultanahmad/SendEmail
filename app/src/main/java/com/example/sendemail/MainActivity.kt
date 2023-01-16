package com.example.sendemail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sendemail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnsend.setOnClickListener {
            val editEmail = binding.editto.text.toString()
            val editSubject = binding.editsubject.text.toString()
            val editMessage = binding.editmessage.text.toString()
            sendEmail(editEmail,editSubject,editMessage)
        }
    }

    fun sendEmail(editto:String, editsubject:String, editmessage: String) {
        val emailAddress = arrayOf(editto)

        val mIntent = Intent(Intent.ACTION_SEND)
      //  mIntent.data= Uri.parse("mailto:")//
        mIntent.type = "*/*"
        mIntent.putExtra(Intent.EXTRA_EMAIL, emailAddress)
        mIntent.putExtra(Intent.EXTRA_SUBJECT, editsubject)
        mIntent.putExtra(Intent.EXTRA_TEXT, editmessage)
        if (mIntent.resolveActivity(packageManager)!= null){
            startActivity(Intent.createChooser(mIntent,"choose an app"))
        }
        //try {
         //   startActivity(Intent.createChooser(mIntent, "Send email using..."))

       // } catch (e: Exception) {
       //     Toast.makeText(this, "e,message", Toast.LENGTH_SHORT).show()
       // }
    }
}



