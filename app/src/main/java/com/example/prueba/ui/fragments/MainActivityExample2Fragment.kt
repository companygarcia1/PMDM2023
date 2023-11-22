package com.example.prueba.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.prueba.databinding.ActivityMainExample2Binding

class MainActivityExample2Fragment : Fragment() {
    private lateinit var binding: ActivityMainExample2Binding
    private lateinit var ctx: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityMainExample2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setConfigView()
        setListener()

    }

    private fun setConfigView() {

    }

    private fun setListener() {

    }
}