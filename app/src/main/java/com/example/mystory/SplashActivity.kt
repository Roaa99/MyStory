package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        moveToLoginScreen()
    }

    private fun moveToLoginScreen() {

         Handler(Looper.myLooper()!!).postDelayed({


             finish() // دالة خاصة لحذف الاكتفيتي من الذاكرة لذلك عند الرجوع لن تظهر
             // كودالانتقال من هذه الاكتفتي لاكتفيتي الدخول
             // راح ينفذ الانتقال بعد 3 ثواني
             val i = Intent(this,LoginActivity::class.java)
             startActivity(i)

         },3000)

    }
}
/*
هذا الكود خاص لعمل تأخير لتنفيد الاكواد واحط وقت التاخير اللي ابغاها
   Handler(Looper.myLooper()!!).postDelayed({
      // هنا الكود اللي ابغاه يتسوى بعد مدة 3 ثواني
         },3000)
 */