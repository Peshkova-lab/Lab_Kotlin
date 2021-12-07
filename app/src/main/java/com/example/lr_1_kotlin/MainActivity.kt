package com.example.lr_1_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.lr_1_kotlin.model.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var listsUsers = listOf<User>(User("root", "root"))

    fun login(view: View) {
        var edit_login =findViewById<EditText>(R.id.editTextTextEmailAddress)
        var edit_pass =findViewById<EditText>(R.id.editTextTextPassword)
        var login : String = edit_login.text.toString()
        var pass:String = edit_pass.text.toString()

        if (signIn(login,pass)!=null) {
            Toast.makeText(this, " Hello  $login", Toast.LENGTH_LONG).show()
            val scorePage1 = Intent(this, CalculateBZHU::class.java)
            startActivity(scorePage1)

        }else{
            Toast.makeText(this, " Error input login and password", Toast.LENGTH_LONG).show()
        }
    }



    private fun signIn(login: String, pass: String):User? {
        var result = listsUsers.firstOrNull{it.login== login && it.password== pass}
        return result


    }
}