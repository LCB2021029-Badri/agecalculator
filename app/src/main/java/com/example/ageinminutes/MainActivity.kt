package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: View? = findViewById(R.id.btnDatePicker)
        if (btnDatePicker != null) {
            btnDatePicker.setOnClickListener { clickDatePicker(
                   view = View()
            )}
        }
    }

    //setting view
    private fun View() {
        return
    }

    //function for selecting date in calender
    private fun clickDatePicker(view: Unit) {

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        //date picking dialog
        val dpd =DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedyear, selectedmonth, selecteddayofMonth ->

            Toast.makeText(this,"The Chosen Year Is $selectedyear,The Chosen Month Is $selectedmonth, "+"The Chosen Day Is $selecteddayofMonth"  ,Toast.LENGTH_SHORT).show()

            //for date
            val selectedDate = "$selecteddayofMonth/${selectedmonth+1}/$selectedyear"
            //setting date text in xml
            val tvselectedDate = findViewById<TextView>(R.id.tvSelectedDate)
            tvselectedDate.setText(selectedDate)
            //setting date format to text view
            val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)

            //for minutes
            val selectedDateInMinutes = theDate!!.time/ 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateToMinutes = currentDate!!.time /60000
            val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes
            val tvSelectedDateInMinutes = findViewById<TextView>(R.id.tvSelectedDateInMinutes)
            tvSelectedDateInMinutes.setText(differenceInMinutes.toString())

            //for hours
            val selectedDateInHours = theDate!!.time/ 3600000
            val currentDateToHours = currentDate!!.time /3600000
            val differenceInHours = currentDateToHours - selectedDateInHours
            val tvSelectedDateInHours = findViewById<TextView>(R.id.tvSelectedDateInHours)
            tvSelectedDateInHours.setText(differenceInHours.toString())

            //for days
            val selectedDateInDays = theDate!!.time/ 86400000
            val currentDateToDays = currentDate!!.time /86400000
            val differenceInDays = currentDateToDays - selectedDateInDays
            val tvSelectedDateInDays = findViewById<TextView>(R.id.tvSelectedDateInDays)
            tvSelectedDateInDays.setText(differenceInDays.toString())

            //for years
            val selectedDateInYears = theDate!!.time/ 31536000000
            val currentDateToYears = currentDate!!.time /31536000000
            val differenceInYears = currentDateToYears - selectedDateInYears
            val tvSelectedDateInYears = findViewById<TextView>(R.id.tvSelectedDateInYears)
            tvSelectedDateInYears.setText(differenceInYears.toString())

        },year,month,day)

        //setting max date
        dpd.datePicker.setMaxDate((Date().time - 86400000))
        dpd.show()

    }

}

private fun TextView.setText(fl: Float) {
    TODO("Not yet implemented")
}

private fun Any.setText(selectedDate: String) {

}
