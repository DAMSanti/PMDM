package com.example.sesion2_06_a_contador_base.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {
    private val _contador = MutableLiveData<Int>()
    val contador: LiveData<Int> = _contador

    fun add() {
        _contador.value = (_contador.value ?: 0) + 1
    }
}