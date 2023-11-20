package com.example.prueba.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.prueba.R
import com.example.prueba.databinding.FragmentListCarsBinding


class ListCarsFragment : Fragment() {
    private lateinit var binding: FragmentListCarsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListCarsBinding.inflate(inflater)
        return binding.root
    }

}