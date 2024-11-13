package com.example.sesion2_06_a_grupo_base.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GrupoAleatViewModel : ViewModel() {
    private val _grupo = MutableLiveData<List<Int>>()
    val grupo: LiveData<List<Int>> = _grupo

    fun generarGrupo() {
        _grupo.value = (1..16).shuffled().take(4).sorted()
    }
}