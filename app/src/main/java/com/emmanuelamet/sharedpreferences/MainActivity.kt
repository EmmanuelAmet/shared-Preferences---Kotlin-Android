package com.emmanuelamet.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val PREFS_NAME = "myPrefs"
    var myPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener{
            myPref = getSharedPreferences(PREFS_NAME, 0)
            var editor: SharedPreferences.Editor = (myPref as SharedPreferences?)!!.edit()
            if(!TextUtils.isEmpty(txtMessage.text.toString())){
                var message = txtMessage.text.toString()
                var name = txtName.text.toString()
                editor.putString("name", name)
                editor.putString("message", message)
                editor.apply()
                Toast.makeText(this, "Message saved successful", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this, "Please enter something", Toast.LENGTH_SHORT).show()
            }

            //Get Data
            var getData: SharedPreferences = getSharedPreferences(PREFS_NAME, 0)
            if(getData.contains("message")){
                var myMessage = getData.getString("message", "Not found")
                var myName = getData.getString("name", "Not found")
                lblResult.text = myMessage + myName
            }else{
                lblResult.text = "Oops!"
            }
        }


    }
}
