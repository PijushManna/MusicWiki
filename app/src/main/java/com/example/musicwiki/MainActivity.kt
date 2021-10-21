package com.example.musicwiki

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.musicwiki.repo.Repository
import android.view.animation.TranslateAnimation





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

    companion object {
        fun slideUp(view: View) {
            val animate = TranslateAnimation(
                0F,  // fromXDelta
                0F,  // toXDelta
                view.height.toFloat(),  // fromYDelta
                0F
            ) // toYDelta
            animate.duration = 500
            animate.fillAfter = true
            view.startAnimation(animate)
        }

        // slide the view from its current position to below itself
        fun slideDown(view1: View) {
            val animate = TranslateAnimation(
                0F,  // fromXDelta
                0F,  // toXDelta
                0F,  // fromYDelta
                view1.height.toFloat()
            ) // toYDelta
            animate.duration = 500
            animate.fillAfter = true
            view1.startAnimation(animate)
        }
    }
}