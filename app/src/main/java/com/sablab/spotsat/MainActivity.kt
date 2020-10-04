package com.sablab.spotsat

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var logo: ImageView? = null
    var backGround: ImageView? = null
    var guestBtn: Button? = null
    var loginBtn: Button? = null
    var signUpBtn: Button? = null
    var nameTag: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        startActivity(Intent(this , SearchMenuActivity::class.java))
        logo = findViewById(R.id.logo)
        backGround = findViewById(R.id.imageView)
        nameTag = findViewById(R.id.nameTage)
        guestBtn = findViewById(R.id.guest)
        loginBtn = findViewById(R.id.login)
        signUpBtn = findViewById(R.id.signUp)
        val scrapper = HtmlScrapper()
//        GlobalScope.launch{
//            withContext(Dispatchers.IO){
//                val arrayList = scrapper.scrapSearchResults("OSCAR")
//                if (arrayList.isEmpty()){
//                    Log.d("lol" , " ITS EMPTY")
//                }
//                for (element in arrayList){
//                    Log.d("see this" , element.name + "  " + element.idNum + "  " + element.state)
//                }
//            }
//
//        }
//
//        if (savedInstanceState == null) {
//            animationThread.start()
//        } else {
//            guestBtn?.alpha = 1f
//            loginBtn?.alpha = 1f
//            signUpBtn?.alpha = 1f
//            logo?.alpha = 1f
//            nameTag?.alpha = 1f
//        }


    }

    var animationThread = Thread(object : Runnable {
        override fun run() {
            var scaleAnim: Animation
            runOnUiThread {
                scaleAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.scale)
                backGround?.startAnimation(scaleAnim)
            }
            Thread.sleep(2000)
            runOnUiThread {
                logo?.alpha = 1f
                nameTag?.alpha = 1f
                val fadeInAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
                logo?.startAnimation(fadeInAnim)
                nameTag?.startAnimation(fadeInAnim)
            }
            Thread.sleep(2000)
            runOnUiThread {
                val fadeInAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)

                guestBtn?.alpha = 1f
                loginBtn?.alpha = 1f
                signUpBtn?.alpha = 1f
                guestBtn?.startAnimation(fadeInAnim)
                loginBtn?.startAnimation(fadeInAnim)
                signUpBtn?.startAnimation(fadeInAnim)
            }
        }
    })
}