package com.example.myapplication3

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.detail_phone.view.*


class GridListAdapter(val context: FragmentActivity?, val gridlist: ArrayList<Int>) : BaseAdapter() {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        /* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려주는(inflate) 역할을 한다. */
        val view: View = LayoutInflater.from(context).inflate(R.layout.main_grid_2048, null)

        // 위에서 생성된 view 를 fragment_02.xml 파일의 각 View 와 연결하는 과정
        val grids = view.findViewById<TextView>(R.id.eachGrid)

        val temp = gridlist[position]
        if(temp==0){
            grids.text = ""
        }
        else{
            grids.text = temp.toString()
        }



        return view
    }

    override fun getItem(position: Int): Any {
        return gridlist[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return gridlist.size
    }
}