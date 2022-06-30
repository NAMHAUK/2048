package com.examplemolcamp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.util.*

class MainActivity : AppCompatActivity() {
    var phoneArray = arrayListOf<phone>(
        phone("010-9954-6310","남하욱"),
        phone("010-1234-1234","몰루")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        // Json 파일 열어서 String 으로 얻음
        val jsonString = assets.open("phoneNumbers.json").reader().readText()
        Log.d("jsonString",jsonString)

        // jsonArray 로 파싱
        val jsonArray =JSONArray(jsonString)
        Log.d("jsonArray", jsonArray.toString())

        // string 배열

        var nameArray = arrayOf("")

        // jsonArray 순회 : 인덱스별 JsonObject 취득후, key 에 해당하는 value 확인
        for (index in 0 until jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(index)

            // key 이름에 해당하는 값 얻음
            val number = jsonObject.getString("number")
            val name = jsonObject.getString("name")

            // string 배열에 각 값을 추가

            numberArray = numberArray.plus(number)
            nameArray = nameArray.plus(name)

        }
        Log.d("numberArray", numberArray[1])
*/
        setContentView(R.layout.activity_main)
        val phoneAdapter = MainListAdapter(this, phoneArray)
        listview1.adapter = phoneAdapter


    }
}