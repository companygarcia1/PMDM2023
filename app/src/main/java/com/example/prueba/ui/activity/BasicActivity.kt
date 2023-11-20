package com.example.prueba.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba.R
import com.example.prueba.databinding.ActivityBasicBinding
import com.example.prueba.ui.fragments.FragmentB
import com.example.prueba.ui.fragments.ListCarsFragment
import com.example.prueba.ui.fragments.ListFragment
import com.example.prueba.utils.FragmentManager

class BasicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBasicBinding
    private var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBasicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configView()
        setListener()
    }

    private fun configView() {
        showFragmentListCar()
    }

    private fun setListener() {
        binding.btnFragment.setOnClickListener {
            if (position == 0) {
                showFragmentB()
            } else if (position == 1) {
                showFragmentList()
            } else {
                showFragmentListCar()
            }
        }
    }

    private fun showFragmentListCar() {
        val fragment = ListCarsFragment()
        FragmentManager.replaceFragment(supportFragmentManager, fragment, R.id.content_fragment)
        position = 0
    }

    private fun showFragmentB() {
        val fragment = FragmentB()
        FragmentManager.replaceFragment(supportFragmentManager, fragment, R.id.content_fragment)
        position = 1
    }

    private fun showFragmentList() {
        val fragment = ListFragment()
        FragmentManager.replaceFragment(supportFragmentManager, fragment, R.id.content_fragment)
        position = 2
    }
}