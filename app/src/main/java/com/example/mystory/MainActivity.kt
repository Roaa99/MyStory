package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private var textViewEmail:TextView?=null
    private var drawerLayout:DrawerLayout?=null
    private var toolbarView:Toolbar?=null
    private var navigationView:NavigationView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val email=intent.getStringExtra("email")

        connectViews()
        // لازم نستدعي دالة connectview قبل نحط لقيمية في textViewEmail
        textViewEmail?.text= email
        // استخدم هذه الدالة حتى استعمل toolbar اللي سويته
        setSupportActionBar(toolbarView)
        //يظهر شكل السهم على toolbar
       // بعدين نغيير السهم لثلاث خطوط
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupDrawer()
        updateEmailHeader(email!!)
        drawerClicks()
    }



    //دالة تظهر لي ايميل المستخدم في header
    private fun updateEmailHeader(email:String) {

       val headerView=navigationView?.getHeaderView(0)
        val textViewEmail= headerView?.findViewById<TextView>(R.id.tvEmail)
        textViewEmail?.text=email
    }


    private fun connectViews() {
        textViewEmail=findViewById(R.id.tvEmail)
        drawerLayout=findViewById(R.id.drawer)
        toolbarView=findViewById(R.id.toolbar)
        navigationView=findViewById(R.id.navView)
    }


    private fun setupDrawer() {
        // استخدم كلاس ActionBarDrawerToggle
       // ياخذ اربع متغيرات وهي الاكتفيتي الحالية this || وdrwer || و نص open || نص close
       val toggle = ActionBarDrawerToggle(this,drawerLayout,
           R.string.open,R.string.close)
        // دالة الاستماع للdrawer
        drawerLayout?.addDrawerListener(toggle)
        // مزامنة الdrawerlayout متى يفتح ومتى يغلق
        toggle.syncState()
    }

    //   اسوي اعادة كتابة لهذه الداله وهي مسؤولة عن تغير علامة الرجوع في  toolbar الى علامة الثلاثة خطوط وكذلك التفاعل معها لما اضغط عليها نفتح لي drawer
    // اقدر اضيف اكثر من علامة في التول بار مثل التنبيهات او البحث واسوي الكود الخاص فيها
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
               drawerLayout?.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }
    }


    //للتفاعل مع drawer
    private fun drawerClicks() {
        //ال it هنا هو id لل item في المنيو
        navigationView?.setNavigationItemSelectedListener {
            when(it.itemId){

                R.id.home ->{
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.logout -> {
                    // انهي واجهة الرئيسية
                    finish()
                    //انتقل لواجهة تسجيل الدخول
                    val i=Intent(this,LoginActivity::class.java)
                    startActivity(i)
                    true
                }

                else -> true
            }
        }
    }

}