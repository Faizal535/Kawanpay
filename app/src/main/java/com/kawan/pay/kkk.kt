package com.kawan.pay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kawan.pay.R
import android.content.SharedPreferences

class kkk : AppCompatActivity() {
    var year = 0
    var month = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val today = year.toString() + "" + month
        val sharedPreferences = getSharedPreferences("PREFS", 0)
        val currentDay = sharedPreferences.getBoolean(today, false)
        if (!currentDay) {
            val editor = sharedPreferences.edit()
            editor.putBoolean(today, true)
            editor.apply()
        }
    }
}