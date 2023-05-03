package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.login.databinding.ActivityCreateAccountBinding
import com.example.login.databinding.ActivityWelcomeBinding

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCreateAccountBinding
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReg.setOnClickListener {

           var name =  binding.etName.text.toString()
           var email =  binding.etEmail.text.toString()
           var phone =  binding.etPhone.text.toString()
           var password =  binding.etPassword.text.toString()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                if (name.isEmpty()) {
                    binding.etName.error = "Enter your name"
                }
                if (email.isEmpty()) {
                    binding.etEmail.error = "Enter your email"
                }
                if (phone.isEmpty()) {
                    binding.etPhone.error = "Enter your phone"
                }

                if (password.isEmpty()) {
                    binding.etPassword.error = "Enter your password"
                }

                Toast.makeText(this, "Enter valid details", Toast.LENGTH_SHORT).show()

            }

            //validate email pattern
            else if (!email.matches(emailPattern.toRegex())) {
                binding.etEmail.error = "Enter a valid email address"

            }

            //validate phone number
            else if (phone.length != 10) {
                binding.etPhone.error = "Enter a valid phone number"

            }

            //validate passwords
            else if (password.length < 7) {
                binding.etPassword.error = "Password must be at least 7 characters."

            } else {
                //creating an auth for the user
                /*auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {

                    if (it.isSuccessful) {
                        //store user details in the database
                        val databaseRef =
                            database.reference.child("users").child(auth.currentUser!!.uid)
                        val user: User = User(name, email, phone, address, auth.currentUser!!.uid, isVerified)
                        databaseRef.setValue(user).addOnCompleteListener {
                            if (it.isSuccessful) {
                                //Upload profile picture to firebase storage
                                uploadImage()

                                //redirect user to login activity
                                val intent = Intent(this, LoginActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(
                                    this,
                                    "Something went wrong, try again",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    } else {
                        Toast.makeText(this, "Something went wrong, try again", Toast.LENGTH_SHORT)
                            .show()
                    }
                }*/
            }
        }



    }
}