package com.oriol.recuandroid.Ui

import com.oriol.recuandroid.Model.Animals

interface OnAnimalClickListener {
    fun onAnimalItemClicked(detailsAnimals: MutableList<Animals>, position:Int)
}