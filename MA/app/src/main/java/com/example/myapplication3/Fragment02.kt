package com.example.myapplication3

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ListView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.util.jar.Manifest

class Fragment02 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_02, container, false)

        var imageArray: ArrayList<Image> = arrayListOf<Image>(
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),
            Image("photo1"),

        )


        var customListView: GridView? = null
        customListView = rootView.findViewById<View>(android.R.id.list) as GridView
        val imageAdapter = ImageListAdapter(this.activity, imageArray)
        customListView.adapter = imageAdapter

        return rootView
    }

}