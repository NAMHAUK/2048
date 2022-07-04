package com.example.myapplication3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.Fragment


class Fragment03 : Fragment() {
    var GridArray: ArrayList<Int> = arrayListOf<Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View =inflater.inflate(R.layout.fragment_03, container, false)
        // 4*4 Grid 에 각 값 초기화 (초기 number 값은 0)
        for(i:Int in 0..15){
            var tempRow = i/4
            var tempCol = i%4
            GridArray.add(0)
        }


        //setOf(GridArray[4].number,4)
        GridArray.set(0,2)
        GridArray.set(1,2)
        GridArray.set(2,2)
        GridArray.set(3,2)





        var customListView: GridView? = null
        customListView = rootView.findViewById<View>(android.R.id.list) as GridView
        val GridAdapter = GridListAdapter(this.activity, GridArray)
        customListView.adapter = GridAdapter

        val btn_left=rootView.findViewById<View>(R.id.left)
        return rootView
    }


}