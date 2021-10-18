package com.example.musicwiki.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import com.example.musicwiki.R

class WelcomeGenreAdapter(context: Context, private val res: Int, items: ArrayList<String>) :
    ArrayAdapter<String>(context, res, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var v = convertView
        if (v == null) {
            v = LayoutInflater.from(context).inflate(res, parent, false)
        }
        val imgTag:Button = v!!.findViewById(R.id.btn_genre)
        imgTag.text = getItem(position)
        return v
    }

}