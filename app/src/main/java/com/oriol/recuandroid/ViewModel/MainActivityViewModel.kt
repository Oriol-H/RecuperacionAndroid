package com.oriol.recuandroid.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.oriol.recuandroid.Model.Animals
import com.oriol.recuandroid.Repositories.MainRepositorie

class MainActivityViewModel: ViewModel() {
    private val mainRepositorie: MainRepositorie = MainRepositorie()

    val getAnimalsList: LiveData<MutableList<Animals>>
        get() = mainRepositorie.getAnimalsLiveData

}

