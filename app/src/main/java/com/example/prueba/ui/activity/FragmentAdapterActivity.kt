package com.example.prueba.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba.R
import com.example.prueba.databinding.ActivityFragmentAdapterBinding
import com.example.prueba.ui.adapters.DepthPageTransformer
import com.example.prueba.ui.adapters.FragmentAdapter
import com.example.prueba.ui.fragments.FragmentA
import com.example.prueba.ui.fragments.FragmentB
import com.example.prueba.ui.fragments.ListCarsFragment2
import com.example.prueba.ui.fragments.MainActivity2Fragment
import com.google.android.material.tabs.TabLayoutMediator

class FragmentAdapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentAdapterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configView()
    }

    private fun configView() {
        val adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        adapter.addFragment(MainActivity2Fragment(),"mi fragment")
        adapter.addFragment(ListCarsFragment2(),"listado")
        adapter.addFragment(FragmentA(), "Fragment A")
        adapter.addFragment(FragmentB(), "Jose")

        binding.viewPager2.adapter = adapter
       // binding.viewPager2.setPageTransformer(DepthPageTransformer())

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }
}