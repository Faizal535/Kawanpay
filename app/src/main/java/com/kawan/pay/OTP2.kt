package com.kawan.pay

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class OTP2 : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var chip: Chip
    private var mAuth: FirebaseAuth? = null
    private var verificationId: String? = null
    lateinit var linearLayout: LinearLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp2)
        editText = findViewById(R.id.otp_edit)
        chip = findViewById(R.id.otp_next)
        linearLayout = findViewById(R.id.linear)

        mAuth = FirebaseAuth.getInstance()
        val intent = intent
        val mobile = intent.getStringExtra("phone")
        chip.setOnClickListener {
            val code: String = editText.getText().toString().trim()
            if (code.isEmpty() || code.length < 6) {
                editText.error = "Enter valid code"
            } else{
                verifyVerificationCode(code)
            }
        }
        sendVerificationCode(mobile!!)
    }
    private fun sendVerificationCode(number: String) {

        val options = PhoneAuthOptions.newBuilder(mAuth!!)
            .setPhoneNumber(number)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this) // Activity (for callback binding)
            .setCallbacks(mCallBack) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
    private fun signInWithCredential(credential: PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    linearLayout.visibility = View.GONE
                    val i = Intent(this, NameActivity::class.java)
                    startActivity(i)
                    finish()
                } else {
                    Toast.makeText(this, "Failed to login" , Toast.LENGTH_LONG).show()
                }
            }
    }

    private val
            mCallBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            // below method is used when
            // OTP is sent from Firebase
            override fun onCodeSent(s: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(s, forceResendingToken)
                linearLayout.visibility = View.GONE
                Toast.makeText(this@OTP2,"Code sent",Toast.LENGTH_SHORT).show()
                // when we receive the OTP it
                // contains a unique id which
                // we are storing in our string
                // which we have already created.
                verificationId = s
            }

            // this method is called when user
            // receive OTP from Firebase.
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                // below line is used for getting OTP code
                // which is sent in phone auth credentials.
                val code = phoneAuthCredential.smsCode

                // checking if the code
                // is null or not.
                if (code != null) {
                    editText.setText(code)
                    verifyVerificationCode(code)
                }
            }

            // this method is called when firebase doesn't
            // sends our OTP code due to any error or issue.
            override fun onVerificationFailed(e: FirebaseException) {

                // displaying error message with firebase exception.
                Toast.makeText(this@OTP2,"Verification faied", Toast.LENGTH_SHORT).show()
            }
        }

    private fun verifyVerificationCode(code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
        signInWithCredential(credential)
    }











}