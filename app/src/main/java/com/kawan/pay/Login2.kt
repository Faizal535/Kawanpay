package com.kawan.pay

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.textfield.TextInputEditText

class Login2 : AppCompatActivity() {
    lateinit var linearLayout: LinearLayout
    lateinit var textInputEditText: TextInputEditText
    lateinit var chip: Chip
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        linearLayout = findViewById(R.id.linear)
        textInputEditText = findViewById(R.id.editm)
        chip = findViewById(R.id.mkl)
        chip.setOnClickListener {
            if (TextUtils.isEmpty(textInputEditText.text.toString())) {
                Toast.makeText(
                    this,
                    "Please enter a valid phone number.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                linearLayout.visibility = View.VISIBLE
                Handler().postDelayed({
                    val phone = "+60" + textInputEditText.text.toString()
                    val intent = Intent(this, OTPActivity::class.java)
                    intent.putExtra("phone", phone)
                    startActivity(intent)

                                      },2000)


            }
        }
    }

}