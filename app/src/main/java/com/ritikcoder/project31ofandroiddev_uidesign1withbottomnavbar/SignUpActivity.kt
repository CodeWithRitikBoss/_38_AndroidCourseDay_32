package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    private lateinit var userFirstName: String
    private lateinit var userLastName: String
    private lateinit var userFullName: String
    private lateinit var userName: String
    private lateinit var userEmail: String
    private lateinit var userPassword: String
    private lateinit var userAddress: String

    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            textViewForSignUpActivityHeader.setOnClickListener {
                finish()
            }
            textViewToOpenLoginActivity.setOnClickListener {
                startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
                finish()
            }
            buttonForSingIn.setOnClickListener {
                userFirstName= textInputEditTextForFirstName.text.toString()
                userLastName= textInputEditTextForLastName.text.toString()
                userFullName= "$userFirstName $userLastName"
                userName= textInputEditTextForUserName.text.toString()
                userEmail= textInputEditTextForUserEmail.text.toString()
                userPassword= textInputEditTextForUserPassword.text.toString()
                userAddress= textInputEditTextForUserAddress.text.toString()

                //Creating the reference of UserFirebaseDataClass.
                val userFirebaseDataClass= UserFirebaseDataClass(userFullName, userName, userEmail, userPassword, userAddress)

                databaseReference= FirebaseDatabase.getInstance().getReference("Users")
                databaseReference.child(userName).setValue(userFirebaseDataClass).addOnSuccessListener {
                    //Clearing the all fields.
                    textInputEditTextForFirstName.text?.clear()
                    textInputEditTextForLastName.text?.clear()
                    textInputEditTextForUserName.text?.clear()
                    textInputEditTextForUserEmail.text?.clear()
                    textInputEditTextForUserPassword.text?.clear()
                    textInputEditTextForUserAddress.text?.clear()

                    startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
                    finish()

                }.addOnFailureListener {
                    Toast.makeText(this@SignUpActivity, "Failed", Toast.LENGTH_SHORT).show()
                }

            }

        }

    }
}