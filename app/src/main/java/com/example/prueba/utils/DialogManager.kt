package com.example.prueba.utils

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.res.Resources
import android.widget.Toast
import com.example.prueba.R
import java.util.Calendar

object DialogManager {
    fun showDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Hola mundo")
        builder.setMessage("Esto es un mensaje")
        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            Toast.makeText(context, "Click positivo", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton(android.R.string.no) { _, _ ->
            Toast.makeText(context, "Click negativo", Toast.LENGTH_LONG).show()
        }
        builder.setNeutralButton("Neutro") { _, _ ->
            Toast.makeText(context, "Click negativo", Toast.LENGTH_LONG).show()
        }
        builder.show()
    }

    fun showDialogList(context: Context, resources: Resources) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Listados")

        val names = resources.getStringArray(R.array.items_names)

        builder.setItems(names) { _, _ ->
            Toast.makeText(context, "Click negativo", Toast.LENGTH_LONG).show()
        }

        builder.show()
    }

    fun showDialogChoiceList(context: Context, resources: Resources) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Listados")

        val names = resources.getStringArray(R.array.items_names)

        builder.setSingleChoiceItems(names, 2) { _, _ ->
            Toast.makeText(context, "Click negativo", Toast.LENGTH_LONG).show()
        }
        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            Toast.makeText(context, "Click positivo", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton(android.R.string.no) { _, _ ->
            Toast.makeText(context, "Click negativo", Toast.LENGTH_LONG).show()
        }
        builder.show()
    }

    fun showDialogMultipleChoiceList(context: Context, resources: Resources) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Listados")

        val names = resources.getStringArray(R.array.items_names)

        builder.setMultiChoiceItems(names, null) { p0, p1, p2 ->
            Toast.makeText(context, "Click negativo", Toast.LENGTH_LONG).show()
        }
        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            Toast.makeText(context, "Click positivo", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton(android.R.string.no) { _, _ ->
            Toast.makeText(context, "Click negativo", Toast.LENGTH_LONG).show()
        }
        builder.show()
    }

    fun showTimeDialog(context: Context){
        val cal = Calendar.getInstance()
        val dialogTime = TimePickerDialog(
            context,
            null,
            cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE),
            true)
        dialogTime.show()
    }

    fun showDayDialog(context: Context, listener:DatePickerDialog.OnDateSetListener){
        val cal = Calendar.getInstance()
        var dialogTime = DatePickerDialog(
            context,
            listener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH))
        dialogTime.show()
    }
}