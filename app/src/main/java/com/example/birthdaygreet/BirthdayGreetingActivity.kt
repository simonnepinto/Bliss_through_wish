package com.example.birthdaygreet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_birthday_greeting.*

class BirthdayGreetingActivity : AppCompatActivity() {

    companion object { //similar to static variables
        const val NAME_EXTRA = "name_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_greeting)

        //val name = intent.getStringExtra("name") //tell the string to be taken; here its the value with key as "name"
        val name = intent.getStringExtra(NAME_EXTRA) // to prevent confusion with the val - name

        birthdayGreeting.text = "Happy birthday\n $name!" //display the text
    }

    fun shareCard(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"  //indicate we are sharing plain text
        intent.putExtra(Intent.EXTRA_TEXT, "Happy Birthday")
        val chooser = Intent.createChooser(intent, "Share this card using...")  //choose what app to share with
        startActivity(chooser)
    }
}
