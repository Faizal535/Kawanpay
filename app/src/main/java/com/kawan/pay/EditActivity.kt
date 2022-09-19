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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EditActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_edit)
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
        RetrivedData()
    }

    private fun RetrivedData() {
        FirebaseDatabase.getInstance().reference.child(uid!!).child("firstname").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(String::class.java)
                textInputEditText1.setText(value)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        FirebaseDatabase.getInstance().reference.child(uid).child("lastname").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(String::class.java)
                textInputEditText2.setText(value)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


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
            finish()
        }




    }










}