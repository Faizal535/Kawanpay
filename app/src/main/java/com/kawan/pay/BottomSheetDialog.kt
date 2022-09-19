package com.kawan.pay

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class BottomSheetDialog : BottomSheetDialogFragment() {
    lateinit var linearLayout: LinearLayout
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var editText4: EditText
    lateinit var button: Button
    var cateogryvalue:String? = null
    var uid = FirebaseAuth.getInstance().currentUser?.uid
    lateinit var dataClass:DataClass
    var fetchedvalue:Int = 0


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val v =  inflater.inflate(R.layout.bottomsheet, container, false)
        val mArgs = arguments
        val myValue = mArgs!!.getString("Source")
         if (myValue.equals("fooddrink")){
             cateogryvalue = "Food & drink"
         } else if (myValue.equals("shop")){
             cateogryvalue = "Shopping"
         }else if (myValue.equals("House")) {
             cateogryvalue = "Housing"

         }else if (myValue.equals("Transport")) {
             cateogryvalue = "Transportation"

         }else if (myValue.equals("Vehicle")) {
             cateogryvalue = "Vehicle"
         } else if (myValue.equals("Entertain")) {
             cateogryvalue = "Life & Entertainment"

         }else if (myValue.equals("Expense")) {
             cateogryvalue = "Financial Expenses"

         } else if (myValue.equals("invest")) {
             cateogryvalue = "Investment"

         } else{
             cateogryvalue = "other"
         }
        editText1 = v.findViewById(R.id.budget)
        editText2 = v.findViewById(R.id.budget1)
        editText3 = v.findViewById(R.id.budget2)
        editText4  = v.findViewById(R.id.budget3)
        button = v.findViewById(R.id.budget4)
        linearLayout = v.findViewById(R.id.linear)
        editText3.setText(cateogryvalue)
        FirebaseDatabase.getInstance().reference.child(uid!!).child(cateogryvalue.toString()).child("Total Spending").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    fetchedvalue = snapshot.value.toString().toInt()
                } else {
                    fetchedvalue = 0
                }



            }

            override fun onCancelled(error: DatabaseError) {

            }

        })





        button.setOnClickListener {
          if (editText1.text.isEmpty() || editText2.text.isEmpty() || editText3.text.isEmpty() || editText4.text.isEmpty()){
              Toast.makeText(context,"Fill all info",Toast.LENGTH_SHORT).show()
          } else {
              val date:String = editText2.text.toString()
              val spending:Int =editText4.text.toString().toInt()
              dataClass = DataClass(date, cateogryvalue, spending)
              linearLayout.visibility = View.VISIBLE
              FirebaseDatabase.getInstance().reference.child(uid!!).child(cateogryvalue.toString()).child("budget").setValue(editText1.text.toString())
              FirebaseDatabase.getInstance().reference.child(uid!!).child(cateogryvalue.toString()).push().setValue(dataClass).addOnSuccessListener {
                  FirebaseDatabase.getInstance().reference.child(uid!!).child(cateogryvalue.toString()).child("Total Spending").setValue(fetchedvalue + spending).addOnSuccessListener {
                      linearLayout.visibility = View.GONE
                      this.dismiss()
                  }.addOnFailureListener {
                      linearLayout.visibility = View.GONE
                      Toast.makeText(context,"Failed to upload",Toast.LENGTH_SHORT).show()
                  }

              }.addOnFailureListener {
                  linearLayout.visibility = View.GONE
                  Toast.makeText(context,"Failed to upload",Toast.LENGTH_SHORT).show()

              }

          }


        }
        return v



    }


}