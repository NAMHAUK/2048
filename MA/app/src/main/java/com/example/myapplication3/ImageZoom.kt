package com.example.myapplication3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.zoom_image.*


class ImageZoom : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zoom_image)
        zoomedImage.setImageResource(intent.getIntExtra("zoomImage", 0))
        zoomedImage.setOnClickListener{
            finish()
        }
    }
}