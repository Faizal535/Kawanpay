package com.kawan.pay

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class NameActivity : AppCompatActivity() {
    lateinit var linearLayout: LinearLayout
    lateinit var textInputEditText1: TextInputEditText
    lateinit var textInputEditText2: TextInputEditText
    lateinit var radioButton1: RadioButton
    lateinit var radioButton2: RadioButton
    lateinit var chip: Chip
     var gender:String = ""
    val uid = FirebaseAuth.getInstance().currentUser?.uid
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        chip = findViewById(R.id.Asd)
        textInputEditText1 = findViewById(R.id.first_name)
        textInputEditText2 = findViewById(R.id.last_name)
        radioButton1 = findViewById(R.id.male)
        radioButton2 = findViewById(R.id.female)
        linearLayout = findViewById(R.id.linear)
        chip.setOnClickListener {
            if (textInputEditText1.text.toString()
                    .isNotEmpty() || textInputEditText2.text.toString()
                    .isNotEmpty() || radioButton1.isChecked && radioButton2.isChecked
            ) {
                Sendtodatabase()
            } else {
                Toast.makeText(this, "Fill all value first", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun Sendtodatabase() {
        linearLayout.visibility = View.VISIBLE
        val firstname = textInputEditText1.text.toString().trim()
        val lastname = textInputEditText2.text.toString().trim()
        if (radioButton1.isChecked){
            gender = "male"
        }
        if (radioButton2.isChecked){
            gender = "female"
        }
      FirebaseDatabase.getInstance().reference.child(uid!!).child("firstname").setValue(firstname)
        FirebaseDatabase.getInstance().reference.child(uid).child("lastname").setValue(lastname)
        FirebaseDatabase.getInstance().reference.child(uid).child("gender").setValue(gender).addOnSuccessListener {
            linearLayout.visibility = View.GONE
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }




    }


}


