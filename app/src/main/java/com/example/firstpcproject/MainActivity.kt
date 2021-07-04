package com.example.firstpcproject

import android.app.AlarmManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Button
import android.app.DatePickerDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.icu.util.GregorianCalendar
import android.view.View
import android.widget.DatePicker
import java.util.Calendar
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button=findViewById(R.id.btn1)
        val text:TextView=findViewById(R.id.text)
        /*button.setOnClickListener{
            text.text = "현자타임."
        }*/
        button.setOnClickListener {
            val today = GregorianCalendar()
            val year: Int = today.get(Calendar.YEAR)
            val month: Int = today.get(Calendar.MONTH)
            val date: Int = today.get(Calendar.DATE)
            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    text.text = "${year}년 ${month+1}월 ${dayOfMonth}일"
                }
            }, year, month, date)
            dlg.show()
        }
    }
}