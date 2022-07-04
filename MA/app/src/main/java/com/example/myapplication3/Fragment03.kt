package com.example.myapplication3

import android.content.Intent
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*
import kotlin.collections.ArrayList


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
        GridArray.set(0,1)
        GridArray.set(1,2)
        GridArray.set(2,3)
        GridArray.set(3,4)
        GridArray.set(4,5)
        GridArray.set(5,6)
        GridArray.set(6,7)
        GridArray.set(7,8)
        GridArray.set(8,9)
        GridArray.set(9,10)
        GridArray.set(10,11)
        GridArray.set(11,12)

        val up = rootView.findViewById<Button>(R.id.up)
        up.setOnClickListener {
            for (i in 0 until 4) {
                var temp = makeArray(GridArray, 0, i)
            }
            // add 2 or 4 in blank
            var index = newValue(GridArray)
            if (index.size == 0) Toast.makeText(this.context, "GameOver", Toast.LENGTH_SHORT).show()
            else {
                val num = index[0]
                GridArray.set(num, index[1])
                // gridView에 추가
                var customListView: GridView? = null
                customListView = rootView.findViewById<View>(android.R.id.list) as GridView
                val GridAdapter = GridListAdapter(this.activity, GridArray)
                customListView!!.adapter = GridAdapter
            }
        }
        val bottom = rootView.findViewById<Button>(R.id.bottom)
        bottom.setOnClickListener {
            for (i in 0 until 4) {
                var temp = makeArray(GridArray, 1, i)
                //Log.d("log", temp.toString())
            }
            // add 2 or 4 in blank
            var index = newValue(GridArray)
            if (index.size == 0) Toast.makeText(this.context, "GameOver", Toast.LENGTH_SHORT).show()
            else {
                val num = index[0]
                GridArray.set(num, index[1])
                // gridView에 추가
                var customListView: GridView? = null
                customListView = rootView.findViewById<View>(android.R.id.list) as GridView
                val GridAdapter = GridListAdapter(this.activity, GridArray)
                customListView!!.adapter = GridAdapter
            }
        }
        val left = rootView.findViewById<Button>(R.id.left)
        left.setOnClickListener {
            for (i in 0 until 4) {
                var temp = makeArray(GridArray, 2, i)
                //Log.d("log", temp.toString())
            }
            // add 2 or 4 in blank
            var index = newValue(GridArray)
            if (index.size == 0) Toast.makeText(this.context, "GameOver", Toast.LENGTH_SHORT).show()
            else {
                val num = index[0]
                GridArray.set(num, index[1])
                // gridView에 추가
                var customListView: GridView? = null
                customListView = rootView.findViewById<View>(android.R.id.list) as GridView
                val GridAdapter = GridListAdapter(this.activity, GridArray)
                customListView!!.adapter = GridAdapter
            }
        }
        val right = rootView.findViewById<Button>(R.id.right)
        right.setOnClickListener {
            for (i in 0 until 4) {
                var temp = makeArray(GridArray, 3, i)
                //Log.d("log", temp.toString())
            }
            // add 2 or 4 in blank
            var index = newValue(GridArray)
            if (index.size == 0) Toast.makeText(this.context, "GameOver", Toast.LENGTH_SHORT).show()
            else {
                val num = index[0]
                GridArray.set(num, index[1])
                // gridView에 추가
                var customListView: GridView? = null
                customListView = rootView.findViewById<View>(android.R.id.list) as GridView
                val GridAdapter = GridListAdapter(this.activity, GridArray)
                customListView!!.adapter = GridAdapter
            }
        }

        var customListView: GridView? = null
        customListView = rootView.findViewById<View>(android.R.id.list) as GridView
        val GridAdapter = GridListAdapter(this.activity, GridArray)
        customListView!!.adapter = GridAdapter

        return rootView
    }

    fun doAction(atomicArray: ArrayList<Int>){
    }

    // doAction 을 수행할 4칸짜리 array 를 만듦
    // mainArray(전체 Grid) 에서 Action 이 무엇이고, 몇 번째 줄을 만들어야 하는지 받아서 만듦.
    // WhichAct = (0: 위, 1: 아래, 2: 왼쪽, 3: 오른쪽)
    fun makeArray(mainArray: ArrayList<Int>, WhichAct: Int, index: Int): ArrayList<Int> {
        var temp: ArrayList<Int> = arrayListOf<Int>()
        if (WhichAct < 2) { // 위, 아래
            for (i in 0 until 4) {
                if (WhichAct == 0) temp.add(i, mainArray[index + 4 * i])
                else temp.add(i, mainArray[index + 4 * (3 - i)])
            }
        } else { // 왼쪽, 오른쪽
            for (i in 0 until 4) {
                if (WhichAct == 2) temp.add(i, mainArray[index * 4 + i])
                else temp.add(i, mainArray[index * 4 + (3 - i)])
            }
        }
        return temp
    }

    // make new value appear in blank
    fun newValue(mainArray: ArrayList<Int>): ArrayList<Int> {
        var temp: ArrayList<Int> = arrayListOf<Int>()
        for (i:Int in 0..15) {
            if (GridArray[i] == 0) temp.add(i)
        }
        if (temp.size == 0) return temp
        val num = Random().nextInt(temp.size)
        val twoOrfour = Random().nextInt(2)
        if (twoOrfour == 0) return arrayListOf(temp[num], 2)
        else return arrayListOf(temp[num], 4)
    }
}