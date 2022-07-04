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
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*
import kotlin.collections.ArrayList


class Fragment03 : Fragment() {
    var GridArray: ArrayList<Int> = arrayListOf<Int>()
    var score:Int = 0

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
        GridArray.set(2,2)
        GridArray.set(3,2)

        var tempArray = arrayListOf<Int>(
            GridArray[0],GridArray[1],GridArray[2],GridArray[3]
        )
        tempArray= doAction(tempArray)
        for(i:Int in 0..3){
            GridArray[i]=tempArray[i]
        }

        val scorev = rootView?.findViewById<TextView>(R.id.score)
        if (scorev != null) {
            scorev.text = score.toString()
        }


        val up = rootView.findViewById<Button>(R.id.up)
        up.setOnClickListener {
            for (i in 0 until 4) {
                var temp = makeArray(GridArray, 0, i)
                var temptemp=doAction(temp)
                for(j in 0 until 4){
                    GridArray[i+4*j]=temptemp[j]
                }

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
                var temptemp=doAction(temp)
                for(j in 0 until 4){
                    GridArray[i+4*j]=temptemp[3-j]
                }
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
                var temptemp=doAction(temp)
                for(j in 0 until 4){
                    GridArray[j+4*i]=temptemp[j]
                }
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
                var temptemp=doAction(temp)
                for(j in 0 until 4){
                    GridArray[j+4*i]=temptemp[3-j]
                }
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

    fun doAction(atomicArray: ArrayList<Int>):ArrayList<Int>{
        var v = -1  // 합쳐진다면 합쳐질 index
        var c = 0   // 움직여서 들어 갈 index
        for(i:Int in 0..3){
            if(atomicArray[i]==0){
                continue
            }
            else{
                v=i
                break
            }
        }

        // 모든 칸이 비어 있음.
        if(v<0){return atomicArray}

        // 마지막 칸만 차 있으므로 마지막 칸 -> 첫번째 칸
        if(v==3){
            atomicArray.set(0,atomicArray[3])
            atomicArray.set(3,0)
            return atomicArray
        }

        for(i:Int in (v+1)..3){
            Log.d("i",i.toString())
            Log.d("v",v.toString())
            Log.d("c",c.toString())
            Log.d("forA",atomicArray.toString())
            Log.d("score",score.toString())
            // 현재 보는 칸이 비어 있음
            if(atomicArray[i]==0){continue}


            // 같은데 index 가 다 마지막이면 그 값 변경해주고, 아니면 continue
            if(v==i){
                if(i==3){
                    atomicArray.set(c,atomicArray[3])
                    if(c!=3){atomicArray.set(3,0)}
                }
                Log.d("atomicA",atomicArray.toString())
                continue
            }

            // 값이 같은게 옆에 있으므로 합쳐짐
            else if(atomicArray[v]==atomicArray[i]){
                score += (atomicArray[v]*2)
                atomicArray.set(c,(atomicArray[v]*2))
                atomicArray.set(i,0)
                if(c!=v){atomicArray.set(v,0)}
                v = i+1
                c += 1
                Log.d("atomicA",atomicArray.toString())
            }

            // 다르므로 앞에 것은 c index
            else if(atomicArray[v]!=atomicArray[i]){
                atomicArray.set(c,atomicArray[v])
                c += 1
                v = i
                Log.d("atomicA",atomicArray.toString())
            }

            // i=3 인 개체는 합쳐질리 없으므로 그대로 값 이동.
            if(i==3){
                atomicArray.set(c,atomicArray[3])
                if(c!=3){atomicArray.set(3,0)}
                Log.d("atomicA",atomicArray.toString())
            }

        }
        Log.d("score",score.toString())
        return atomicArray
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