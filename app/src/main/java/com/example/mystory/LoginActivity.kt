package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private var editTextUsername:EditText?=null
    private var editTextPassword:EditText?=null
    private var buttonLogin:Button?=null
    private var checkboxView:CheckBox?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        connectViews()
        login()
        //checkFields()
    }




    private fun connectViews() {
        editTextUsername=findViewById(R.id.etUsername)
        editTextPassword=findViewById(R.id.etPassword)
        buttonLogin=findViewById(R.id.btnLogin)
        checkboxView=findViewById(R.id.checkbox)
    }

    private fun login() {

        //مصفوفة مستخدمي التطبيق
        val usersArray:ArrayList<User> = ArrayList()
        usersArray.add(User("roaa@gmail.com" , "0123"))
        usersArray.add(User("sara@gmail.com" , "4567"))
        usersArray.add(User("yara@gmail.com" , "8910"))

      //نتأكد اذا اسم المستخدم والباسورد موجود عندي في المصفوفة
        buttonLogin?.setOnClickListener {
            //هنا نعرف اسم المستخدم والباسورد المدخل من المستخدم وننشأ اوبجكت جديد حتى نقدر نقارنه في المصفوفة عندنا
            val username = editTextUsername?.text.toString()
            val password = editTextPassword?.text.toString()
            val user = User(username,password)

            // كودالمقارنه
            for(index in usersArray){
                if(index.email== user.email && index.password==user.password){
                    //Toast.makeText(this,"Welcome ${user.email}",Toast.LENGTH_LONG).show()
                        finish()// حتى يحذف واجهة الدخول من الذاكرة
                        val i:Intent= Intent(this,MainActivity::class.java)
                        i.putExtra("email",index.email)
                        startActivity(i)
                     break
                } else{
                    Toast.makeText(this,"Check your data",Toast.LENGTH_LONG).show()
                }
            }
        }


    }

    private fun checkFields() {
        buttonLogin?.setOnClickListener {
            if(editTextUsername?.text?.isEmpty() == true){
                editTextUsername?.setError("Enter your email")
            }else if( editTextPassword?.text?.isEmpty()==true){
                editTextPassword?.error="Enter your password"
            }
        }
    }

}