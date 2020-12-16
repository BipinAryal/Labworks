package com.bipin.labloginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView

class Lab02_IncreaseCounter : AppCompatActivity() {
    private lateinit var rd1 : RadioButton
    private lateinit var rd2 : RadioButton
    private lateinit var txt1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab02__increase_counter)

        rd1 = findViewById(R.id.rd1)
        rd2 = findViewById(R.id.rd2)
        txt1 = findViewById(R.id.txt1)

        rd1.setOnClickListener{
            rd1.text = txt1.text
        }

        rd2.setOnClickListener{
            rd2.text = txt1.text
        }

    }
}