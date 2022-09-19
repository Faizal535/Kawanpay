package com.kawan.pay


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class ExpenceTracker : Fragment() {

       lateinit var button: Button
       lateinit var buttton1:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_expence_tracker, container, false)
         button = view.findViewById(R.id.add_budget)
        buttton1 = view.findViewById(R.id.view_expenses)
        button.setOnClickListener {
           startActivity(Intent(context,CategoryActivity::class.java))
        }
        buttton1.setOnClickListener {
            startActivity(Intent(context,ViewExpenses::class.java))
        }
        return view
    }


}