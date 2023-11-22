package com.example.prueba.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba.databinding.ActivityFragmentAdapterExampleBinding
import com.example.prueba.ui.adapters.FragmentAdapterExample
import com.example.prueba.ui.fragments.FragmentA
import com.example.prueba.ui.fragments.FragmentB
import com.example.prueba.ui.fragments.ListCarsFragment2
import com.example.prueba.ui.fragments.ListFragment
import com.example.prueba.ui.fragments.MainActivityExample2Fragment
import com.google.android.material.tabs.TabLayoutMediator

class FragmentAdapterExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentAdapterExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentAdapterExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setConfigView()

    }

    private fun setConfigView() {
        val fragmentAdapter = FragmentAdapterExample(supportFragmentManager, lifecycle)
        fragmentAdapter.addFragment(MainActivityExample2Fragment(), "Nuevo")
        fragmentAdapter.addFragment(FragmentA(), "Titulo 1")
        fragmentAdapter.addFragment(FragmentB(), "Fragment B")
        fragmentAdapter.addFragment(ListCarsFragment2(), "Titulo 12")
        fragmentAdapter.addFragment(ListFragment(), "Titulo 12")

        binding.viewPager2.adapter = fragmentAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = fragmentAdapter.getPageTitle(position)
        }.attach()
    }

}