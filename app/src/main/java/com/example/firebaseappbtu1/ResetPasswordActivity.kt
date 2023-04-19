package com.example.firebaseappbtu1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ResetPasswordActivity: AppCompatActivity() {
    private lateinit var emailEditText : EditText
    private lateinit var forgotPasswordButton : TextView

    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        init()
        listeners()
    }

    private fun listeners() {
        forgotPasswordButton.setOnClickListener {
            val email = "giorgirazmadze0605@gmail.com"
            auth
                .sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Email sent.", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun init () {
        emailEditText = findViewById(R.id.emailEditText)
        forgotPasswordButton = findViewById(R.id.forgotPasswordButton)

    }


}