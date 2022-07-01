package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_phone.*


class detailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_phone)
        name.text= intent.getStringExtra("name")
        number.text= intent.getStringExtra("number")
        photo.setImageResource(intent.getIntExtra("photo", 0))
        button.setOnClickListener{
            finish()
        }
    }
}