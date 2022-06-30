package com.examplemolcamp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.test_layout.*
import org.json.JSONArray
import java.util.*

class MainActivity : AppCompatActivity() {
    var phoneArray = arrayListOf<phone>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Json 파일 열어서 String 으로 얻음
        val jsonString = assets.open("phoneNumbers.json").reader().readText()

        // jsonArray 로 파싱
        val jsonArray =JSONArray(jsonString)

        // jsonArray 순회 : 인덱스별 JsonObject 취득후, key 에 해당하는 value 확인
        for (index in 0 until jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(index)

            // key 이름에 해당하는 값 얻음
            val number = jsonObject.getString("number")
            val name = jsonObject.getString("name")

            // 배열에 각 값을 추가
            phoneArray.add(phone(number,name))
        }

        setContentView(R.layout.activity_main)

//        listview1.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
//            val selectItem = parent.getItemAtPosition(position) as phone
//
//            val intent = Intent(this, detailActivity::class.java)
//            intent.putExtra("number",selectItem.number)
//            intent.putExtra("name",selectItem.name)
//            startActivity(intent)
//            finish()
//        }

        val phoneAdapter = MainListAdapter(this, phoneArray)
        listview1.adapter = phoneAdapter
    }
}