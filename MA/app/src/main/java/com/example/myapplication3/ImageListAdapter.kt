package com.example.myapplication3

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity


class ImageListAdapter(val context: FragmentActivity?, val imagelist: ArrayList<Image>) : BaseAdapter() {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        /* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려주는(inflate) 역할을 한다. */
        val view: View = LayoutInflater.from(context).inflate(R.layout.imagelist, null)

        // 위에서 생성된 view 를 activity_main.xml 파일의 각 View 와 연결하는 과정
        val images = view.findViewById<ImageView>(R.id.imageView)


        val temp = imagelist[position]
        val resourceId = context?.resources?.getIdentifier(temp.image , "drawable", context.packageName)
        resourceId?.let { images.setImageResource(it) }

        return view
    }

    override fun getItem(position: Int): Any {
        return imagelist[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return imagelist.size
    }
}