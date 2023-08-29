package com.tamatem.tmatemplusproject.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tamatem.tmatemplusproject.presentation.databinding.ActivityMainBinding
import com.tamatem.tmatemplusproject.presentation.fragments.WebFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}