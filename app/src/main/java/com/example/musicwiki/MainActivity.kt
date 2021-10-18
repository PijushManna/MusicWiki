package com.example.musicwiki

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musicwiki.repo.Repository


/*
* Application name	MusicWiki
* API key	8bfe4bd8ae71bd4dda4b58cc138e1035
* Shared secret	5ef12968182f820437b62a06272a7530
* Registered to	pijushmanna
* */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Repository.init(applicationContext)
    }
}