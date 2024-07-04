package com.example.user_feature_application

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

data class User(val id: String, val userName: String, val userPhone: String)

class AddUserActivity : AppCompatActivity() {

    private val userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_user)

        var userIdEditText: EditText = findViewById(R.id.userIdEditText)
        var userNameEditText: EditText = findViewById(R.id.userNameEditText)
        var userPhoneEditText: EditText = findViewById(R.id.userPhoneEditText)
        var idEnterEdittext: EditText = findViewById(R.id.idEnterEditText)
        var addButton: Button = findViewById(R.id.addButton)
        var viewButton: Button = findViewById(R.id.view)
        fun addUser() {
            val userId = userIdEditText.text.toString()
            val userName = userNameEditText.text.toString()
            val userPhone = userPhoneEditText.text.toString()
            if (userId.isNotBlank() && userName.isNotBlank() && userPhone.isNotBlank()) {
                val user = User(userId, userName, userPhone)
                userList.add(user)
                Toast.makeText(this, "User added Successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Enter all the details", Toast.LENGTH_SHORT).show()
            }
        }

        fun viewUser() {
            val idToView = idEnterEdittext.text.toString()
            if (idToView.isEmpty()) {
                Toast.makeText(this@AddUserActivity, "Enter Id Details", Toast.LENGTH_SHORT).show()
            }
            else {
                val foundUser = userList.find { it.id == idToView }
                if (foundUser == null) {
                    Toast.makeText(this, "Missing User Details", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val intent = Intent(this, ViewUserActivity::class.java).apply {
                        putExtra(User_Id, foundUser.userName)
                        putExtra(User_Name, foundUser.userPhone)
                        putExtra(USER_PHONE, foundUser.id)
                    }
                    startActivity(intent)
                }
            }
        }
        addButton.setOnClickListener {
            addUser()
        }
        viewButton.setOnClickListener {
            viewUser()
        }
    }

    companion object{
        const val User_Id = "USERID"
        const val User_Name = "USERNAME"
        const val USER_PHONE = "USERPHONE"

    }
}
