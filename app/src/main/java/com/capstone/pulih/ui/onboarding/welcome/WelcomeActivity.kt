package com.capstone.pulih.ui.onboarding.welcome

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstone.pulih.R
import com.capstone.pulih.databinding.ActivityWelcomeBinding
import com.capstone.pulih.ui.auth.login.LoginActivity
import com.capstone.pulih.ui.inputdata.InputDataActivity
import com.capstone.pulih.utils.AuthConstant
import com.capstone.pulih.utils.Preferences

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWelcomeBinding
    private lateinit var sharedPref: Preferences
    private  lateinit var intent : Intent

    override fun onStart() {
        super.onStart()
        sharedPref = Preferences(this)
        if(sharedPref.getBoolean(AuthConstant.PREF_IS_LOGIN)){
            intent = Intent(this@WelcomeActivity, InputDataActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLoginUser.setOnClickListener {
            intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnLoginCounselor.setOnClickListener{
            comingSoon()
        }
    }
    private fun comingSoon(){
        Toast.makeText(this@WelcomeActivity, getString(R.string.coming_soon), Toast.LENGTH_LONG).show()
    }
}