package com.kawan.pay
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class splashActivity : AppCompatActivity() {
    lateinit var videoView: VideoView
    var currentUser: FirebaseUser? = null
    private var mAuth: FirebaseAuth? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        videoView = findViewById(R.id.ks_f)
        val videopath:String = StringBuilder("android.resource://")
            .append(packageName).append("/raw/splash").toString()
        videoView.setVideoPath(videopath)
        mAuth = FirebaseAuth.getInstance()
        currentUser = mAuth!!.currentUser
        videoView.setOnCompletionListener {
            Handler().postDelayed({
                if (currentUser == null) {
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    val mainIntent = Intent(this, MainActivity::class.java)
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(mainIntent)
                    finish()
                }
            }, 2000)

        }
        videoView.start()

    }
}
