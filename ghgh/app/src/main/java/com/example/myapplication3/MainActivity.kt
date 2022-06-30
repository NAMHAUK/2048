package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ViewPager2, TabLayout 참조
        val viewPager:ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        // FragmentStateAdapter 생성
        val viewpagerFragmentAdapter = ViewpagerFragmentAdapter(this)

        // ViewPager2의 adapter 설정
        viewPager.adapter = viewpagerFragmentAdapter


        // ###### TabLayout과 ViewPager2를 연결
        // 1. 탭메뉴의 이름을 리스트로 생성해둔다.
        val tabTitles = listOf<String>("Phone", "Gallery", "???")

        // 2. TabLayout과 ViewPager2를 연결하고, TabItem의 메뉴명을 설정한다.
        TabLayoutMediator(tabLayout, viewPager, {tab, position -> tab.text = tabTitles[position]}).attach()
    }

}