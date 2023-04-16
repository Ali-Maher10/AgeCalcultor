package com.example.agecalcultor

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
   private var txtview:TextView?=null
    private var AgeInMin:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickpicker: Button = findViewById(R.id.alibutton)
        txtview= findViewById(R.id.txt1)
        AgeInMin= findViewById(R.id.ageinmin)
        clickpicker.setOnClickListener {
            clicked()
        }
    }

    fun clicked() {    val myCalender = Calendar.getInstance()
        val Year=myCalender.get(Calendar.YEAR)
        val Month =myCalender.get(Calendar.MONTH)
        val Day =myCalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view,year,Month,DayOfMonth-> Toast.makeText(this,"year was $year,month was ${Month+1},DayOfMonth was $DayOfMonth",Toast.LENGTH_LONG).show()
               val selecdDate="$DayOfMonth/${Month+1}/$year"
            txtview?.text =selecdDate
            val sdf = java.text.SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val TheDate=sdf.parse(selecdDate)
            val selecdedDateInMinute=TheDate.time/60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinute=currentDate.time/60000
            val differenceInMin=currentDateInMinute-selecdedDateInMinute
            AgeInMin?.text=differenceInMin.toString()   },
            Year,Month,Day).show()

    }
}