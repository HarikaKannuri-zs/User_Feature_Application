package com.example.user_feature_application

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ViewUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_user)

        val userIdTextView: TextView = findViewById(R.id.TextViewUserId)
        val userNameTextView: TextView = findViewById(R.id.TextViewUserName)
        val userPhoneTextView: TextView = findViewById(R.id.TextViewUserPhone)
        val userId = intent.getStringExtra(AddUserActivity.User_Id)
        val userName = intent.getStringExtra(AddUserActivity.User_Name)
        val userPhone = intent.getStringExtra(AddUserActivity.USER_PHONE)
        userIdTextView.text = "User Id : $userId"
        userNameTextView.text = "User Name : $userName"
        userPhoneTextView.text = "User Phone: $userPhone"

        val closeButton:Button = findViewById(R.id.closeButton)

        closeButton.setOnClickListener{
            finish()
        }
    }
}