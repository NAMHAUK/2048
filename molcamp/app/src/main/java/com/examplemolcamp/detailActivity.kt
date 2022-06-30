package com.examplemolcamp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_phone.*


class detailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_phone)
        name.text= intent.getStringExtra("name")
        number.text= intent.getStringExtra("number")
        button.setOnClickListener{
            finish()
        }
    }
}
