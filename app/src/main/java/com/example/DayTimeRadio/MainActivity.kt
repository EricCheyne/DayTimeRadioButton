package com.example.DayTimeRadio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter = findViewById<Button>(R.id.btnEnter)
        val btnClear = findViewById<Button>(R.id.btnClear)

        val rgDay = findViewById<RadioGroup>(R.id.rgDay)
        val rgTime = findViewById<RadioGroup>(R.id.rgTime)

        // **************************************************************************************************
        // when user clickc Enter
        btnEnter.setOnClickListener{
            // determine which radio button is checked
            var rb_day_id = rgDay.checkedRadioButtonId
            var rb_time_id = rgTime.checkedRadioButtonId

            // make sure one from each radio button group was checked
            if(rb_day_id == -1 || rb_time_id == -1){
                Toast.makeText(this, "Please choose a day and time", Toast.LENGTH_LONG).show()
            }else {
                // get the actual radio buttons
                val rb_day = findViewById<RadioButton>(rb_day_id)
                val rb_time = findViewById<RadioButton>(rb_time_id)

                // Toasts with different contexts
                Toast.makeText(this, "Hi", Toast.LENGTH_LONG).show()
                Toast.makeText(applicationContext, rb_day.text, Toast.LENGTH_SHORT).show()
                Toast.makeText(baseContext, rb_time.text, Toast.LENGTH_SHORT).show()
            }
        }

        //***************************************************************************************************
        // when user clicks Clear
        btnClear.setOnClickListener{
            rgDay.clearCheck()
            rgTime.clearCheck()
        }

        // pre-selecting a Radio Button from the group
        val pre_checked_day = rgDay.getChildAt(1) as RadioButton
        // getChildAt returns a View but the "as" turns it into more specifically a Radio Button
        // needed to use the setChecked method
        pre_checked_day.setChecked(true)

        val pre_checked_time = rgTime.getChildAt(1) as RadioButton
        pre_checked_time.setChecked(true)
    } //end onCreate
} //end MainActivity class
