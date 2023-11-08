package com.example.prueba.ui.activity

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import com.example.prueba.R
import com.example.prueba.databinding.ActivityThreadBinding
import com.example.prueba.utils.NotificationManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class ThreadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreadBinding
    private var job: Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
        setConfigView()
    }

    private fun setConfigView() {
        binding.btnStart.isEnabled = true
        binding.btnCancel.isEnabled = false
        binding.progressBar.progress = 0
    }

    private fun setListener() {
        binding.btnStart.setOnClickListener {
            val builder = NotificationManager.buildNotification(this,"mi_canal")
            builder.setContentText("titulo")
            builder.setContentTitle("prueba")
            builder.setSmallIcon(R.drawable.ic_launcher_foreground)
            NotificationManager.show(this, 1234, builder)

            job = calculate(10)
        }

        binding.btnCancel.setOnClickListener {
            job.let {
                job?.cancel().apply {
                    binding.btnCancel.isEnabled = false
                    binding.btnStart.isEnabled = true
                    binding.progressBar.progress = 0
                }
            }
        }
    }

    private fun calculate(duracion: Long) = GlobalScope.launch(Dispatchers.Main) {
        binding.btnStart.isEnabled = false
        binding.btnCancel.isEnabled = true
        binding.progressBar.progress = 0
        withContext(Dispatchers.IO) {
            for (i in 0..duracion) {
                if (getCarToApi(1000)) {
                    binding.progressBar.progress = binding.progressBar.progress + 10
                }
            }
        }
        binding.btnStart.isEnabled = true
        binding.btnCancel.isEnabled = false
        binding.progressBar.progress = 100

    }

    suspend fun getCarToApi(duracion: Long): Boolean {
        delay(duracion)
        return true
    }
}