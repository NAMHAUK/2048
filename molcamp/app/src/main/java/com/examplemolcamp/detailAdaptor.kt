package com.examplemolcamp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button

class detailAdaptor(val context: Context, val phonelist: ArrayList<phone>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        /* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려주는(inflate) 역할을 한다. */
        val view: View = LayoutInflater.from(context).inflate(R.layout.test_layout, null)

        // 위에서 생성된 view 를 activity_main.xml 파일의 각 View 와 연결하는 과정
        val names = view.findViewById<Button>(R.id.nameButton)

        val temp = phonelist[position]
        names.text = temp.name

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
