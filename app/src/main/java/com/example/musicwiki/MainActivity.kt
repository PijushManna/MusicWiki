package com.example.musicwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import com.example.musicwiki.databinding.ActivityMainBinding

/*
* Application name	MusicWiki
* API key	8bfe4bd8ae71bd4dda4b58cc138e1035
* Shared secret	5ef12968182f820437b62a06272a7530
* Registered to	pijushmanna
* */

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        MainViewModel(application)
    }
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}