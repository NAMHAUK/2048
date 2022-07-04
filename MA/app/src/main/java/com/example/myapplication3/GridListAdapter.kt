package com.example.myapplication3

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
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

        // 위에서 생성된 view 를 fragment_03.xml 파일의 각 View 와 연결하는 과정
        val grids = view.findViewById<TextView>(R.id.eachGrid)

        val temp = gridlist[position]
        if(temp==0){
            grids.text = ""
        }
        else{
            grids.text = temp.toString()
            if (grids.text == "2") grids.setBackgroundColor(Color.parseColor("#DEE1D3"))
            else if (grids.text == "4") grids.setBackgroundColor(Color.parseColor("#5493B9"))
            else if (grids.text == "8") grids.setBackgroundColor(Color.parseColor("#368ABF"))
            else if (grids.text == "16") grids.setBackgroundColor(Color.parseColor("#416CA6"))
            else if (grids.text == "32") grids.setBackgroundColor(Color.parseColor("#829FDB"))
            else if (grids.text == "64") grids.setBackgroundColor(Color.parseColor("#D98841"))
            else if (grids.text == "128") grids.setBackgroundColor(Color.parseColor("#F2B950"))
            else if (grids.text == "256") grids.setBackgroundColor(Color.parseColor("#F2DFA7"))
            else if (grids.text == "512") grids.setBackgroundColor(Color.parseColor("#7EA656"))
            else if (grids.text == "1024") grids.setBackgroundColor(Color.parseColor("#285930"))
            else if (grids.text == "2048") grids.setBackgroundColor(Color.parseColor("#06402F"))
            else if (grids.text == "4096") grids.setBackgroundColor(Color.parseColor("#01261C"))
            else if (grids.text == "8192") grids.setBackgroundColor(Color.parseColor("#A69586"))
            else if (grids.text == "16384") grids.setBackgroundColor(Color.parseColor("#D9BDAD"))
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