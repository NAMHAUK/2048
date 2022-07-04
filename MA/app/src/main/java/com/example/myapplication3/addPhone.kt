package com.example.myapplication3

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_phone.*
import kotlinx.android.synthetic.main.detail_phone.*


class addPhone : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_phone)

        val edt_name: EditText = findViewById(R.id.edt_name)
        val edt_phone: EditText = findViewById(R.id.edt_phone)
        val btn_save: Button = findViewById(R.id.btn_save)
        val preferences: SharedPreferences = getSharedPreferences("addInfo", MODE_PRIVATE)

        // button event
        btn_save.setOnClickListener {
            val editor = preferences.edit()
            editor.putString("username", edt_name.text.toString())
            editor.putString("userphone", edt_phone.text.toString())
            // 항상 commit or apply 를 해줘야 저장이 된다.
            editor.apply()
            // Fragment01로 데이터 전달
            intent.putExtra("name", edt_name.text.toString())
            intent.putExtra("number", edt_phone.text.toString())
            setResult(RESULT_OK, intent)
            //this.startActivity(intent)
            //Log.d("log", edt_name.text.toString())
            finish()
        }
    }
}