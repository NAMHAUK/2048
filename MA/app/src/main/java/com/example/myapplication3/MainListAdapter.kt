package com.example.myapplication3

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity

class MainListAdapter(val context: FragmentActivity?, val phonelist: ArrayList<phone>) : BaseAdapter() {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        /* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려주는(inflate) 역할을 한다. */
        val view: View = LayoutInflater.from(context).inflate(R.layout.test_layout, null)

        // 위에서 생성된 view 를 activity_main.xml 파일의 각 View 와 연결하는 과정
        val names = view.findViewById<Button>(R.id.nameButton)

        val temp = phonelist[position]
        names.text = temp.name

        names.setOnClickListener {
            val intent = Intent(this.context, detailActivity::class.java)
            val resourceId = context?.resources?.getIdentifier(temp.photo, "drawable", context.packageName)

            intent.putExtra("number", temp.number)
            intent.putExtra("name", temp.name)
            intent.putExtra("photo",resourceId)

            this.context?.startActivity(intent)
        }

        return view
    }

    override fun getItem(position: Int): Any {
        return phonelist[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return phonelist.size
    }
}