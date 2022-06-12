package com.oriol.recuandroid.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oriol.recuandroid.databinding.DetailAnimalsBinding
import com.squareup.picasso.Picasso

class Detail_Animals : AppCompatActivity() {
    private lateinit var binding: DetailAnimalsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailAnimalsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getInfoAnimals()
    }

    private fun getInfoAnimals() {
        Picasso.get().load(intent.getStringExtra("image")).into(binding.imgDetailAnimal)
        binding.txtDetailName.text = "Name: " + intent.getStringExtra("name")
        binding.txtDetailBreed.text = "Breed: " + intent.getStringExtra("breedName")
        binding.txtDetailKind.text = "Kind: " + intent.getStringExtra("kind")
        binding.txtDetailAge.text = "Age: " + intent.getStringExtra("age")
        binding.txtDescriptionAnimal.text = intent.getStringExtra("descriptionAnimal") +
                "\n\n" + intent.getStringExtra("descriptionBreed")
    }

}