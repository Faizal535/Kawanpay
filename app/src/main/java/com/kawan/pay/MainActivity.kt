package com.kawan.pay
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*


class MainActivity : AppCompatActivity() {
    val uid = FirebaseAuth.getInstance().currentUser?.uid
   lateinit var bottomNavigationView: BottomNavigationView
   lateinit var fragmentContainerView: FragmentContainerView
   var totalcoin:Int = 0
   @SuppressLint("MissingInflatedId")
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       FirebaseDatabase.getInstance().reference.child(uid!!).child("Total reward").addValueEventListener(object:ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               if (snapshot.exists()){
                   totalcoin = snapshot.value.toString().toInt()
               } else {
                   totalcoin = 0
               }

           }
           override fun onCancelled(error: DatabaseError) {
           }

       })
       val calaender: Calendar = Calendar.getInstance()
       val year:Int = calaender.get(Calendar.YEAR)
       val month:Int = calaender.get(Calendar.MONTH)
       val day:Int = calaender.get(Calendar.DAY_OF_MONTH)
       val todayString:String = year.toString() + "" + month + "" + day
       val prefrences:SharedPreferences = getSharedPreferences("PREFS",0)
       val currentday:Boolean = prefrences.getBoolean(todayString,false)
       if (!currentday){
           val editor:SharedPreferences.Editor = prefrences.edit()
           editor.putBoolean(todayString,true)
           editor.apply()
           val builder = AlertDialog.Builder(this)
           val customLayout: View = layoutInflater
               .inflate(R.layout.rewarddialog, null)
           builder.setView(customLayout)
           builder.setPositiveButton("Claim now",DialogInterface.OnClickListener { dialog, which ->
               FirebaseDatabase.getInstance().reference.child(uid).child("Total reward").setValue(totalcoin + 1)
           })
           val dialog: AlertDialog = builder.create()
           dialog.show()

       }
       bottomNavigationView = findViewById(R.id.bottom_view)
       bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);
       fragmentContainerView = findViewById(R.id.fragment_container)
       val fragment = HomeFragment()
       val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
       fragmentTransaction.replace(R.id.fragment_container, fragment, "")
       fragmentTransaction.commit()
   }

    private val selectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    val fragment = HomeFragment()
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment_container, fragment, "")
                    fragmentTransaction.commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.expence -> {
                    val fragment1 = ExpenceTracker()
                    val fragmentTransaction1 = supportFragmentManager.beginTransaction()
                    fragmentTransaction1.replace(R.id.fragment_container, fragment1)
                    fragmentTransaction1.commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            true
        }

}



















