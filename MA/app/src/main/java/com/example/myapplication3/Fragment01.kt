package com.example.myapplication3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONArray
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
        val jsonString = text
        // jsonArray 로 파싱
        val jsonArray = JSONArray(jsonString)

        // jsonArray 순회 : 인덱스별 JsonObject 취득후, key 에 해당하는 value 확인
        for (index in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(index)
            // key 이름에 해당하는 값 얻음
            val number = jsonObject.getString("number")
            val name = jsonObject.getString("name")
            val photo = jsonObject.getString("photo")
            phoneArray.add(phone(number, name,photo))
        }

        var customListView: ListView? = null
        // xml의 listview id를 반드시 "@android:id/list"로 해줘야 한다.
        customListView = rootView.findViewById<View>(android.R.id.list) as ListView
        val phoneAdapter = MainListAdapter(this.activity, phoneArray)
        customListView.adapter = phoneAdapter
        return rootView
    }
    companion object {
        private var phoneAdapter: MainListAdapter? = null
    }
}
