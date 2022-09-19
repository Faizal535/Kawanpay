package com.kawan.pay

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileActivity : AppCompatActivity() {
    val uid = FirebaseAuth.getInstance().currentUser?.uid
    lateinit var textView: TextView
    lateinit var textView1: TextView
    lateinit var imageButton1: ImageButton
    lateinit var linearLayout: LinearLayout
    lateinit var imageButton2: ImageButton
    lateinit var linearLayout1: LinearLayout
    lateinit var linearLayout2: LinearLayout
    lateinit var linearLayout3: LinearLayout
    lateinit var linearLayout4: LinearLayout
    lateinit var cardView: CardView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        textView = findViewById(R.id.nas)
        textView1 = findViewById(R.id.nas1)
        imageButton1 = findViewById(R.id.back_buttton)
        imageButton2 = findViewById(R.id.edit_detail)
        linearLayout = findViewById(R.id.pro_linear6)
        linearLayout1 = findViewById(R.id.pro_linear)
        linearLayout2 = findViewById(R.id.pro_linear1)
        linearLayout3 = findViewById(R.id.pro_linear2)
        linearLayout4 = findViewById(R.id.pro_linear3)
         cardView = findViewById(R.id.linear)

        val db = FirebaseDatabase.getInstance().reference.child(uid!!)
        db.child("firstname").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(String::class.java)
                textView.text = value
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
        db.child("lastname").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(String::class.java)
                textView1.text = value
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })
        imageButton1.setOnClickListener {
            this.finish()
        }
        linearLayout.setOnClickListener {
            startActivity(Intent(this,Accounractivity::class.java))
        }
        imageButton2.setOnClickListener {
            startActivity(Intent(this,EditActivity::class.java))
        }
        linearLayout1.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kawanpay.blogspot.com/2022/09/email-for-contacting.html"))
            startActivity(browserIntent)
        }
        linearLayout2.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kawanpay.blogspot.com/2022/09/privacy-policy.html"))
            startActivity(browserIntent)
        }
        linearLayout3.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kawanpay.blogspot.com/2022/09/about.html"))
            startActivity(browserIntent)
        }
        linearLayout4.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kawanpay.blogspot.com/2022/09/help.html"))
            startActivity(browserIntent)
        }
        cardView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kawanpay.blogspot.com/2022/09/premium.html"))
            startActivity(browserIntent)
        }

    }

}