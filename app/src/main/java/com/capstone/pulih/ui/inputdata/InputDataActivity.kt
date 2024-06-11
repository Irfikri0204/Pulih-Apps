package com.capstone.pulih.ui.inputdata

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstone.pulih.databinding.ActivityInputDataBinding
import com.capstone.pulih.ui.main.MainActivity
import com.capstone.pulih.utils.AuthConstant
import com.capstone.pulih.utils.Preferences

class InputDataActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInputDataBinding
    private lateinit var intent : Intent
    private lateinit var sharedPref: Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            sharedPref = Preferences(this)
            sharedPref.put(AuthConstant.PREF_IS_INPUT,true)
            Toast.makeText(this, "Data Berhasil Disimpan!", Toast.LENGTH_LONG).show()
            intent = Intent(this@InputDataActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        sharedPref = Preferences(this)
        if(sharedPref.getBoolean(AuthConstant.PREF_IS_INPUT)){
            intent = Intent(this@InputDataActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}