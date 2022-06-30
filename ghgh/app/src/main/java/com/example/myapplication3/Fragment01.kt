package com.example.myapplication3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import java.nio.file.Files.list
import java.util.Collections.list

class Fragment01 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView: View = inflater.inflate(R.layout.fragment_01, container, false)

        // xml의 listview id를 반드시 "@android:id/list"로 해줘야 한다.
        var phoneArray: ArrayList<phone> = arrayListOf<phone>(
            phone("010-9954-6310","남하욱"),
            phone("010-9954-6310","남하"),
            phone("010-9954-6310","남욱"),
            phone("010-1234-1234","몰루")
        )
        var customListView: ListView? = null
        customListView = rootView.findViewById<View>(android.R.id.list) as ListView
        val phoneAdapter = MainListAdapter(this.activity, phoneArray)
        customListView.adapter = phoneAdapter
        return rootView
    }
    companion object {
        private var phoneAdapter: MainListAdapter? = null
    }
}
