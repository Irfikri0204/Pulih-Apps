package com.capstone.pulih.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstone.pulih.databinding.ActivityLoginBinding
import com.capstone.pulih.ui.auth.register.RegisterActivity
import com.capstone.pulih.ui.main.MainActivity
import com.capstone.pulih.utils.AuthConstant
import com.capstone.pulih.utils.Preferences
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var sharedPref: Preferences
    private lateinit var intent : Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        //        Navigasi ke Register Fragment
        binding.linkRegister.setOnClickListener {
            intent = Intent(this@LoginActivity,RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

//        Menampilkan Message Menggunakan Toast
        binding.btnLogin.setOnClickListener {
//            Mengambil String dari Input
            val email = binding.edLoginEmail.text.toString()
            val password = binding.edLoginPassword.text.toString()
//            Pengkondisian Inputan
            if (email.isNotEmpty()&&password.isNotEmpty()){
//                Firebase Login
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        sharedPref = Preferences(this)
                        sharedPref.put(AuthConstant.PREF_IS_LOGIN,true)
                        Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_LONG).show()
                        intent = Intent(this@LoginActivity,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                Toast.makeText(this,"Harap isi dengan benar!", Toast.LENGTH_LONG).show()
            }
        }
    }
}