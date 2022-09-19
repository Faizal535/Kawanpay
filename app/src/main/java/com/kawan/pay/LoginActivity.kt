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
import com.google.android.material.textfield.TextInputLayout


class LoginActivity : AppCompatActivity() {
    lateinit var textInputLayout: TextInputLayout
    lateinit var textInputEditText: TextInputEditText
    lateinit var chip: Chip
    lateinit var linearLayout: LinearLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        linearLayout = findViewById(R.id.linear)
        textInputLayout = findViewById(R.id.text_layout)
        textInputEditText = findViewById(R.id.text_edit)
        chip = findViewById(R.id.sign_up)
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
                    val intent = Intent(this, OTP2::class.java)
                    intent.putExtra("phone", phone)
                    startActivity(intent)
                },2000)



            }
        }
    }












}