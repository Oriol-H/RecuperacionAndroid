package com.oriol.recuandroid.Ui
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.oriol.recuandroid.Adapter.AnimalListAdapter
import com.oriol.recuandroid.Model.Animals
import com.oriol.recuandroid.ViewModel.MainActivityViewModel
import com.oriol.recuandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnAnimalClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var adapter: AnimalListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding.rvMovies.layoutManager = LinearLayoutManager(this)


        mainActivityViewModel!!.getAnimalsList.observe(this) {animalsModels ->

            if (animalsModels != null) {
                adapter = AnimalListAdapter(this, animalsModels, this)
                adapter!!.notifyDataSetChanged()
                binding.rvMovies.adapter = adapter
            }
        }
    }

    override fun onAnimalItemClicked(detailsAnimals: MutableList<Animals>, position: Int) {
        val intent = Intent(this, Detail_Animals::class.java)
        intent.putExtra("name", detailsAnimals[position].name)
        val age:String = detailsAnimals[position].age.toString()
        intent.putExtra("age", age)
        if (!detailsAnimals[position].imageUrl.isNullOrEmpty()) {
            intent.putExtra("image", detailsAnimals[position].imageUrl)
        } else {
            intent.putExtra("image", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Flag_of_Unknow.svg/1280px-Flag_of_Unknow.svg.png")
        }
        intent.putExtra("descriptionAnimal", detailsAnimals[position].description)
        intent.putExtra("descriptionBreed", detailsAnimals[position].breed.description)
        intent.putExtra("breedName", detailsAnimals[position].breed.name)
        intent.putExtra("kind", detailsAnimals[position].kind)
        startActivity(intent)
    }
}




