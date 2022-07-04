package com.example.myapplication3

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream


class Fragment01 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_01, container, false)

        var phoneArray = arrayListOf<phone>()

        val am = resources.assets
        var `is`: InputStream? = null
        val buf = ByteArray(1024)
        var text = ""
        try {
            `is` = am.open("phoneNumbers.json")
            if (`is`.read(buf) > 0) {
                text = String(buf)
            }
            `is`.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        // Json 파일 열어서 String 으로 얻음
        var jsonString = text
        // jsonArray 로 파싱
        var jsonArray = JSONArray(jsonString)

        // jsonArray 순회 : 인덱스별 JsonObject 취득후, key 에 해당하는 value 확인
        for (index in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(index)
            // key 이름에 해당하는 값 얻음
            val number = jsonObject.getString("number")
            val name = jsonObject.getString("name")
            val photo = jsonObject.getString("photo")
            phoneArray.add(phone(number, name, photo))
        }

        phoneArray.sortBy { it.name }

        var customListView: ListView? = null
        // xml의 listview id를 반드시 "@android:id/list"로 해줘야 한다.
        customListView = rootView.findViewById<View>(android.R.id.list) as ListView
        var phoneAdapter = MainListAdapter(this.activity, phoneArray)
        customListView.adapter = phoneAdapter

        // plus button 눌렀을 때 이름/번호 작성 activity
        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                // Handle the Intent
                val ename = result.data?.getStringExtra("name").toString()
                val enumber = result.data?.getStringExtra("number").toString()
                //Toast.makeText(this.context, ename, Toast.LENGTH_SHORT).show()
                phoneArray.add(phone(enumber, ename, "mario"))
                phoneArray.sortBy { it.name }
            }
        }
        val add = rootView.findViewById<Button>(R.id.add)
        add.setOnClickListener {
            val intent = Intent(this.context, addPhone::class.java)
            startForResult.launch(intent)
        }

        return rootView
    }
    companion object {
        private var phoneAdapter: MainListAdapter? = null
    }
}