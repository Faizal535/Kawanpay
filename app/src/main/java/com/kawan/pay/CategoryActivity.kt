package com.kawan.pay

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity


class CategoryActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var arrayAdapter: ArrayAdapter<*>
    var category = arrayOf(
        "Food & Drinks", "Shopping",
        "Housing", "Transportation",
        "Vehicle", "Life & Entertainment",
        "Financial Expenses", "Investment",
        "others")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        listView = findViewById(R.id.listview)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, category)
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                val args = Bundle()
                args.putString("Source","fooddrink")
                val bottomSheet = BottomSheetDialog()
                bottomSheet.arguments = args
                bottomSheet.show(supportFragmentManager, "ModalBottomSheet")
            }
            if (position == 1) {
                val args = Bundle()
                args.putString("Source","shop")
                val bottomSheet = BottomSheetDialog()
                bottomSheet.arguments = args
                bottomSheet.show(supportFragmentManager, "ModalBottomSheet")
            }

            if (position == 2) {
                val args = Bundle()
                args.putString("Source","House")
                val bottomSheet = BottomSheetDialog()
                bottomSheet.arguments = args
                bottomSheet.show(supportFragmentManager, "ModalBottomSheet")
            }

            if (position == 3) {
                val args = Bundle()
                args.putString("Source","Transport")
                val bottomSheet = BottomSheetDialog()
                bottomSheet.arguments = args
                bottomSheet.show(supportFragmentManager, "ModalBottomSheet")
            }

            if (position == 4) {
                val args = Bundle()
                args.putString("Source","Vehicle")
                val bottomSheet = BottomSheetDialog()
                bottomSheet.arguments = args
                bottomSheet.show(supportFragmentManager, "ModalBottomSheet")
            }

            if (position == 5) {
                val args = Bundle()
                args.putString("Source","Entertain")
                val bottomSheet = BottomSheetDialog()
                bottomSheet.arguments = args
                bottomSheet.show(supportFragmentManager, "ModalBottomSheet")
            }

            if (position == 6) {
                val args = Bundle()
                args.putString("Source","Expense")
                val bottomSheet = BottomSheetDialog()
                bottomSheet.arguments = args
                bottomSheet.show(supportFragmentManager, "ModalBottomSheet")
            }

            if (position == 7) {
                val args = Bundle()
                args.putString("Source","invest")
                val bottomSheet = BottomSheetDialog()
                bottomSheet.arguments = args
                bottomSheet.show(supportFragmentManager, "ModalBottomSheet")
            }

            if (position == 8) {
                val args = Bundle()
                args.putString("Source","other")
                val bottomSheet = BottomSheetDialog()
                bottomSheet.arguments = args
                bottomSheet.show(supportFragmentManager, "ModalBottomSheet")
            }



        }
    }
}