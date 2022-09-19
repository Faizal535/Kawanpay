package com.kawan.pay
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Accounractivity : AppCompatActivity() {
    val uid = FirebaseAuth.getInstance().currentUser?.uid
       lateinit var textview1:TextView
    lateinit var textview2:TextView
    lateinit var textview3:TextView
    lateinit var imageButton: ImageButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounractivity)
        textview1 = findViewById(R.id.texto1)
        textview2 = findViewById(R.id.texto2)
        textview3 = findViewById(R.id.texto3)
        imageButton = findViewById(R.id.hhhh)
        imageButton.setOnClickListener {
            this.finish()
        }
        val db = FirebaseDatabase.getInstance().reference.child(uid!!)
         db.child("firstname").addValueEventListener(object:ValueEventListener{
             override fun onDataChange(snapshot: DataSnapshot) {
                 val value = snapshot.getValue(String::class.java)
                 textview1.text = value
             }
             override fun onCancelled(error: DatabaseError) {

             }
         })
          db.child("lastname").addValueEventListener(object:ValueEventListener{
              override fun onDataChange(snapshot: DataSnapshot) {
                  val value = snapshot.getValue(String::class.java)
                  textview2.text = value
              }

              override fun onCancelled(error: DatabaseError) {

              }
          })
          db.child("gender").addValueEventListener(object:ValueEventListener{
              override fun onDataChange(snapshot: DataSnapshot) {
                  val value = snapshot.getValue(String::class.java)
                  textview3.text = value
              }

              override fun onCancelled(error: DatabaseError) {

              }

          })
    }
}