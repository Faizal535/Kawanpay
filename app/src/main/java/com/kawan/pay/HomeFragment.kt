package com.kawan.pay
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class HomeFragment : Fragment() {
    var uid = FirebaseAuth.getInstance().currentUser?.uid
    lateinit var textView: TextView
    lateinit var imageButton1: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        imageButton1 = view.findViewById(R.id.profile)
        textView = view.findViewById(R.id.coin)
        imageButton1.setOnClickListener {
            startActivity(Intent(context,ProfileActivity::class.java))
        }
        FirebaseDatabase.getInstance().reference.child(uid!!).child("Total reward").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val value = snapshot.value.toString().toInt()
                    textView.text = value.toString()
                } else{
                    val value = 0
                    textView.text = value.toString()
                }

            }
            override fun onCancelled(error: DatabaseError) {

            }

        })
        return view
    }


}