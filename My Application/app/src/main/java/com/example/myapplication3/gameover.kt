package com.example.myapplication3

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_phone.*
import kotlinx.android.synthetic.main.zoom_image.*
import org.w3c.dom.Text

class gameover : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gameover)
        val gameover: TextView = findViewById(R.id.gameover)
        gameover.setOnClickListener {
            finish()
        }
    }
}
