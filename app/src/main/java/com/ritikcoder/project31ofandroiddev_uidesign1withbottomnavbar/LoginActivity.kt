package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    private lateinit var userName: String
    private lateinit var userPassword: String

    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            textViewForLoginActivityHeader.setOnClickListener {
                finish()
            }
            textViewToOpenSingUpActivity.setOnClickListener {
                startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
                finish()
            }
            buttonForLogin.setOnClickListener {
                userName= textInputEditTextForUserName.text.toString()
                userPassword= textInputEditTextForUserPassword.text.toString()

                //Code to Reading data from the Firebase database.
                //Taking reference till the "users" node
                if (userName.isNotEmpty()){
                    readData(userName)
                }else{
                    Toast.makeText(this@LoginActivity, "please enter user name", Toast.LENGTH_SHORT).show()
                }
            }


        }

    }

    private fun readData(userName: String) {
        databaseReference= FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(userName).get().addOnSuccessListener {
            if(it.exists()){
                //getting data from the Firebase database.
                val gettingName= it.child("name").value
                val gettingUserName= it.child("userName").value
                val gettingUserEmail= it.child("userEmail").value
                val gettingUserPassword= it.child("userPassword").value
                val gettingUserAddress= it.child("address").value

                Toast.makeText(this@LoginActivity, "$gettingName, $gettingUserName, $gettingUserPassword, $gettingUserAddress", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this@LoginActivity, "User doesn't exist", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this@LoginActivity, "Failed! inside of DB", Toast.LENGTH_SHORT).show()
        }
    }
}