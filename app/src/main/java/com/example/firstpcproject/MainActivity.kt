package com.example.firstpcproject

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.*
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import org.w3c.dom.Text
import java.util.*


class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this, AlarmReceiver.NOTIFICATION_ID, intent,
            PendingIntent.FLAG_UPDATE_CURRENT)

        val button:Button=findViewById(R.id.button2)
        val text:TextView=findViewById(R.id.text1)
        var year:Int=0

            var today =Calendar.getInstance()
            year = today.get(Calendar.YEAR)
            var month: Int = today.get(Calendar.MONTH)
            var date: Int = today.get(Calendar.DATE)
        button.setOnClickListener {
            val dlg = DatePickerDialog(this,
                { view, year, month, dayOfMonth -> text.text = "${Calendar.getInstance().timeInMillis}일" }, year, month, date)
            dlg.show()
            today.set(Calendar.MONTH,month+6)
            val time1=today.timeInMillis
            alarmManager.set(
                AlarmManager.RTC,
                time1,
                pendingIntent
            )
        }
        val recentkmrecive:EditText=findViewById(R.id.recentkm)
        val recentkmoutput:TextView=findViewById(R.id.recentkmdsic)
        var rkm=0
        recentkmrecive.doAfterTextChanged {
            recentkmoutput.text=recentkmrecive.text
            rkm=Integer.parseInt(recentkmrecive.text.toString())
        }
    }

}