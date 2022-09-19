package com.kawan.pay

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ViewExpenses : AppCompatActivity() {
    var uid = FirebaseAuth.getInstance().currentUser?.uid
    lateinit var textView: TextView
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var textView4: TextView
    lateinit var textView5: TextView
    lateinit var textView6: TextView
    lateinit var textView7: TextView
    lateinit var textView8: TextView
    lateinit var textView9: TextView
    lateinit var textView10: TextView
    lateinit var textView11: TextView
    lateinit var textView12: TextView
    lateinit var textView13: TextView
    lateinit var textView14: TextView
    lateinit var textView15: TextView
    lateinit var textView16: TextView
    lateinit var textView17: TextView



    var myvalue:Int = 0
    var budgetvalue:String = ""
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_expenses)
        textView = findViewById(R.id.expense_text1)
        textView1 = findViewById(R.id.food_budget)
        textView2 = findViewById(R.id.shopping_expand)
        textView3 = findViewById(R.id.shooping_budget)
        textView4 = findViewById(R.id.housing_expan)
        textView5 = findViewById(R.id.housing_budget)
        textView6 = findViewById(R.id.trans_expense)
        textView7 = findViewById(R.id.trans_budget)
        textView8 = findViewById(R.id.vehicle_expense)
        textView9 = findViewById(R.id.vehicle_budget)
        textView10 = findViewById(R.id.life_expense)
        textView11 = findViewById(R.id.life_budget)
        textView12 = findViewById(R.id.finance_expense)
        textView13 = findViewById(R.id.finance_budget)
        textView14 = findViewById(R.id.invest_expense)
        textView15 = findViewById(R.id.invest_budget)
        textView16 = findViewById(R.id.other_expense)
        textView17 = findViewById(R.id.other_budegt)
        FirebaseDatabase.getInstance().reference.child(uid!!).child("Food & drink").child("Total Spending").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                   myvalue = snapshot.value.toString().toInt()
                   textView.text = myvalue.toString()
                } else {
                 myvalue = 0
                 textView.text = myvalue.toString()
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })
        FirebaseDatabase.getInstance().reference.child(uid!!).child("Food & drink").child("budget").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                   budgetvalue = snapshot.value.toString()
                    textView1.text = budgetvalue
                } else {
                    budgetvalue = 0.00.toString()
                    textView1.text = budgetvalue
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })

        FirebaseDatabase.getInstance().reference.child(uid!!).child("Shopping").child("Total Spending").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    myvalue = snapshot.value.toString().toInt()
                    textView2.text = myvalue.toString()
                } else {
                    myvalue = 0
                    textView2.text = myvalue.toString()
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        FirebaseDatabase.getInstance().reference.child(uid!!).child("Shopping").child("budget").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    budgetvalue = snapshot.value.toString()
                    textView3.text = budgetvalue
                } else {
                    budgetvalue = 0.00.toString()
                    textView3.text = budgetvalue
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })

        FirebaseDatabase.getInstance().reference.child(uid!!).child("Housing").child("Total Spending").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    myvalue = snapshot.value.toString().toInt()
                    textView4.text = myvalue.toString()
                } else {
                    myvalue = 0
                    textView4.text = myvalue.toString()
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        FirebaseDatabase.getInstance().reference.child(uid!!).child("Housing").child("budget").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    budgetvalue = snapshot.value.toString()
                    textView5.text = budgetvalue
                } else {
                    budgetvalue = 0.00.toString()
                    textView5.text = budgetvalue
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })


        FirebaseDatabase.getInstance().reference.child(uid!!).child("Transportation").child("Total Spending").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    myvalue = snapshot.value.toString().toInt()
                    textView6.text = myvalue.toString()
                } else {
                    myvalue = 0
                    textView6.text = myvalue.toString()
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        FirebaseDatabase.getInstance().reference.child(uid!!).child("Transportation").child("budget").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    budgetvalue = snapshot.value.toString()
                    textView7.text = budgetvalue
                } else {
                    budgetvalue = 0.00.toString()
                    textView7.text = budgetvalue
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })

        FirebaseDatabase.getInstance().reference.child(uid!!).child("Vehicle").child("Total Spending").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    myvalue = snapshot.value.toString().toInt()
                    textView8.text = myvalue.toString()
                } else {
                    myvalue = 0
                    textView8.text = myvalue.toString()
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        FirebaseDatabase.getInstance().reference.child(uid!!).child("Vehicle").child("budget").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    budgetvalue = snapshot.value.toString()
                    textView9.text = budgetvalue
                } else {
                    budgetvalue = 0.00.toString()
                    textView9.text = budgetvalue
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })


        FirebaseDatabase.getInstance().reference.child(uid!!).child("Life & Entertainment").child("Total Spending").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    myvalue = snapshot.value.toString().toInt()
                    textView10.text = myvalue.toString()
                } else {
                    myvalue = 0
                    textView10.text = myvalue.toString()
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        FirebaseDatabase.getInstance().reference.child(uid!!).child("Life & Entertainment").child("budget").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    budgetvalue = snapshot.value.toString()
                    textView11.text = budgetvalue
                } else {
                    budgetvalue = 0.00.toString()
                    textView11.text = budgetvalue
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })



        FirebaseDatabase.getInstance().reference.child(uid!!).child("Financial Expenses").child("Total Spending").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    myvalue = snapshot.value.toString().toInt()
                    textView12.text = myvalue.toString()
                } else {
                    myvalue = 0
                    textView12.text = myvalue.toString()
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        FirebaseDatabase.getInstance().reference.child(uid!!).child("Financial Expenses").child("budget").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    budgetvalue = snapshot.value.toString()
                    textView13.text = budgetvalue
                } else {
                    budgetvalue = 0.00.toString()
                    textView13.text = budgetvalue
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })



        FirebaseDatabase.getInstance().reference.child(uid!!).child("Investment").child("Total Spending").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    myvalue = snapshot.value.toString().toInt()
                    textView14.text = myvalue.toString()
                } else {
                    myvalue = 0
                    textView14.text = myvalue.toString()
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        FirebaseDatabase.getInstance().reference.child(uid!!).child("Investment").child("budget").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    budgetvalue = snapshot.value.toString()
                    textView15.text = budgetvalue
                } else {
                    budgetvalue = 0.00.toString()
                    textView15.text = budgetvalue
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })


        FirebaseDatabase.getInstance().reference.child(uid!!).child("other").child("Total Spending").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    myvalue = snapshot.value.toString().toInt()
                    textView16.text = myvalue.toString()
                } else {
                    myvalue = 0
                    textView16.text = myvalue.toString()
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        FirebaseDatabase.getInstance().reference.child(uid!!).child("other").child("budget").addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    budgetvalue = snapshot.value.toString()
                    textView17.text = budgetvalue
                } else {
                    budgetvalue = 0.00.toString()
                    textView17.text = budgetvalue
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })































































































    }
}