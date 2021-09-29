package com.example.taskmangement.views

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import com.example.taskmangement.R
import com.example.taskmangement.utils.CalendarHelper
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class TaskAddActivity : AppCompatActivity() {

    var et_startdate: EditText? = null;
    var et_enddate: EditText? = null;
    var mycalender=Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_add)


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar!!.title = "Task Add"
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeButtonEnabled(true)
        }

        initViews()
        initListeners()


//        showDatePicker()
        showDatePickerForStartDate()
        showDatePickerForEndDate()

    }

    private fun initViews() {
        et_startdate = findViewById(R.id.et_startdate)
         et_enddate = findViewById(R.id.et_enddate)
    }


    private fun initListeners() {

        et_startdate?.setOnClickListener {
            showDatePickerForStartDate()
        }

        et_enddate?.setOnClickListener {
            showDatePickerForEndDate()
        }
    }


    fun showDatePickerForStartDate() {
        // DatePicker

//        et_startdate?.setText(SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()))

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd-MM-yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            et_startdate?.setText(sdf.format(cal.time))
        }

        et_startdate?.setOnClickListener {

            Log.d("Clicked", "Interview Date Clicked")

            val dialog = DatePickerDialog(this, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH))
            dialog.datePicker.maxDate = CalendarHelper.getCurrentDateInMills()
            dialog.show()
        }
    }

    fun showDatePickerForEndDate() {
        // DatePicker

//        et_startdate?.setText(SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()))

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd-MM-yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            et_enddate?.setText(sdf.format(cal.time))
        }

        et_enddate?.setOnClickListener {

            Log.d("Clicked", "Interview Date Clicked")

            val dialog = DatePickerDialog(this, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH))
            dialog.datePicker.maxDate = CalendarHelper.getCurrentDateInMills()
            dialog.show()
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
        super.onBackPressed()
    }
}