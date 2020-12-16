package com.bipin.labloginpage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class Lab03ShowData : AppCompatActivity() {

    private lateinit var tv1 : TextView
    private lateinit var tv2 : TextView
    private lateinit var tv3 : TextView
    private lateinit var tv4 : TextView
    private lateinit var tv5 : TextView
    private lateinit var tvresult : TextView
    private lateinit var et1 : EditText
    private lateinit var spinner : Spinner
    private lateinit var autoComplete: AutoCompleteTextView
    private lateinit var btn1 : Button
    var selectedItem = ""
    private val department = arrayOf("Fees","Reception","Academics","Registration","Classrooms")
    private val address = arrayListOf("Nepali","Nepali1","Chinese","Chinchung","Japanese","Jangang")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab03_show_data)
        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)
        tv3 = findViewById(R.id.tv3)
        tv4 = findViewById(R.id.tv4)
        tv5 = findViewById(R.id.tv5)
        tvresult = findViewById(R.id.tvresult)
        et1 = findViewById(R.id.et1)
        spinner = findViewById(R.id.spinner)
        autoComplete = findViewById(R.id.autoComplete)
        btn1 = findViewById(R.id.btn1)

        //Spinner Code
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            department
        )
        spinner.adapter = adapter

        //on item selected listener on spinner

        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?,
                                            view: View?,
                                            position: Int,
                                            id: Long
                ) {
                    val selectedItem = parent?.getItemAtPosition(position).toString()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        //Spinner code end

        //Autocomplete code start
        val autoCompleteAdapter =ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            address
        )
        autoComplete.setAdapter(autoCompleteAdapter)
        autoComplete.threshold = 2

        //Autocomplete code end

        tv5.setOnClickListener{
            LoadCalendar()
        }

        btn1.setOnClickListener{
            tvresult.text = "Name : ${et1.text} , Department : $selectedItem , Address :  ${autoComplete.text} , Join Date : ${tv5.text}"
        }

    }
    // Code for Date Picker

    private fun LoadCalendar(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener {

                    view , yearNew , monthOfYear , dayOfMonth ->
                tv5.setText("$dayOfMonth--${monthOfYear + 1}--$yearNew")


            },
            year,
            month,
            day
        ).show()
    }
    //Code for Date Picker ends
}

