package com.example.myapplication

import android.app.Application
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application, val text: String) : AndroidViewModel(application) {

    val liveData = MutableLiveData<String>()

    init {
        startCount()
    }

    fun startCount() {
        object : CountDownTimer(20000, 1000) {
            override fun onTick(p0: Long) {
//                binding.textView.text = (p0 / 1000).toString()
                liveData.value = (p0 / 1000).toString()
            }

            override fun onFinish() {
                Toast.makeText(getApplication(), text, Toast.LENGTH_SHORT).show()
            }

        }.start()

    }
}