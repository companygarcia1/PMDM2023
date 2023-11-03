package com.example.prueba.ui.activity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prueba.R
import com.example.prueba.databinding.ActivityDialogBinding
import com.example.prueba.databinding.ActivityMainBinding
import com.example.prueba.utils.DialogManager

class DialogActivity : AppCompatActivity() {
    lateinit var binding: ActivityDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
    }

    private fun setListener() {
        binding.btnDialog.setOnClickListener {
            DialogManager.showDialog(this)
        }

        binding.btnDialogItem.setOnClickListener {
            DialogManager.showDayDialog(this, DatePickerDialog.OnDateSetListener { _, i, i2, i3 ->
                Toast.makeText(this, "Entra", Toast.LENGTH_LONG).show()
            })

        }
    }
}