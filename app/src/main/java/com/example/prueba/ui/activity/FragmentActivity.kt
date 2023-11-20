package com.example.prueba.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prueba.R
import com.example.prueba.databinding.ActivityFragmentBinding
import com.example.prueba.ui.fragments.FragmentA
import com.example.prueba.ui.fragments.FragmentB
import com.example.prueba.utils.FragmentManager

class FragmentActivity : AppCompatActivity() {
    lateinit var binding: ActivityFragmentBinding
    private var isFragmenA = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setView()
        setListener()
    }

    private fun setListener() {
        binding.btnChange.setOnClickListener {
            if (isFragmenA) {
                showFragmentB()
            } else {
                showFragmentA()
            }
        }
    }

    private fun setView() {
        setSupportActionBar(binding.myToolbar)
        showFragmentA()
    }

    private fun showFragmentA() {
        var fragment = FragmentA.NewFragmentA("jose")
       /* val fragmentA = FragmentA()
        val arguments = Bundle()
        arguments.putString(FragmentA.ARG_A,"jose")
        fragmentA.arguments = arguments*/

        FragmentManager.replaceFragment(supportFragmentManager, fragment, R.id.fragment_holder)
        isFragmenA = true
    }

    private fun showFragmentB() {
        FragmentManager.replaceFragment(supportFragmentManager, FragmentB(), R.id.fragment_holder)

        isFragmenA = false
    }

}