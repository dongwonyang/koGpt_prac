package com.example.search_kogpt.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.search_kogpt.databinding.ActivitySearchBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding: ActivitySearchBinding by lazy {
        ActivitySearchBinding.inflate(layoutInflater)
    }

    private val vpAdapter: MainViewPagerAdapter by lazy {
        MainViewPagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        vp.adapter = vpAdapter

        TabLayoutMediator(tlTop, vp) { tab, positon ->
        }
    }
}