package com.example.birthdaygreet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //createBirthdayButton.setOnClickListener { } //whenever button gets clicked
    }
    fun createBirthdayCard(view: View) {
        //val name = nameInput.editableText.toString()
        //Toast.makeText(this, "name is $name", Toast.LENGTH_LONG).show() //displays a toast when button is clicked

        val name = nameInput.editableText.toString() //retrieve the name that user has given

        if(name == ""){
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
        }
        else{
            val intent = Intent(this, BirthdayGreetingActivity::class.java) //make an intent
            //intent.putExtra("name", name) //key-value pair ; we pass this to the new activity

            intent.putExtra(BirthdayGreetingActivity.NAME_EXTRA, name) //companion object can be directly accessible through classname
            //we do the above to ensure the same names are kept throughout in both activities

            startActivity(intent) //starts a new activity and the new activity is passed intent
        }

        //sp is used with text - scale independent pixel
        //dp is used for distances
    }
}
