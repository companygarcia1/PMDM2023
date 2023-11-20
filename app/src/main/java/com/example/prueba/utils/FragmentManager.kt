package com.example.prueba.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object FragmentManager {

    fun replaceFragment(sp: FragmentManager, fragment: Fragment, fragmentHolder: Int) {
        val transaction = sp.beginTransaction()
        transaction.replace(fragmentHolder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}