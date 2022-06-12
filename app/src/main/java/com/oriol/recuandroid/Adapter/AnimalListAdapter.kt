package com.oriol.recuandroid.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oriol.recuandroid.Model.Animals
import com.oriol.recuandroid.R
import com.oriol.recuandroid.Ui.OnAnimalClickListener
import com.squareup.picasso.Picasso

class AnimalListAdapter(var context: Context, var animalsList: MutableList<Animals>, private val onAnimalClickListener: OnAnimalClickListener):
    RecyclerView.Adapter<AnimalListAdapter.MyViewModel>() {
        inner class MyViewModel(itemView:View) : RecyclerView.ViewHolder(itemView) {

            var img_Animal: ImageView =  itemView.findViewById(R.id.img_Animal)
            var tv_Name: TextView = itemView.findViewById(R.id.tv_Name)
            var tv_Breed: TextView = itemView.findViewById(R.id.tv_Breed)
            var tv_Kind: TextView = itemView.findViewById(R.id.tv_Kind)
            var tv_Age: TextView = itemView.findViewById(R.id.tv_Age)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        return MyViewModel(LayoutInflater.from(context).inflate(R.layout.card_animals, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        if (!animalsList[position].imageUrl.isEmpty()){
            Picasso.get().load(animalsList[position].imageUrl).into(holder.img_Animal)
        } else {
            Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d2/Flag_of_Unknow.svg/1280px-Flag_of_Unknow.svg.png").into(holder.img_Animal)
        }
        holder.tv_Name.text = animalsList[position].name
        holder.tv_Breed.text = animalsList[position].breed.name
        holder.tv_Kind.text = animalsList[position].kind
        holder.itemView.setOnClickListener {
            onAnimalClickListener.onAnimalItemClicked(animalsList,position)
        }

        if (animalsList[position].age <1) {
            holder.tv_Age.text = "Cachorro"
        }
        if (animalsList[position].age in 2..5) {
            holder.tv_Age.text = "Adulto"
        }
        if (animalsList[position].age > 6 ){
            holder.tv_Age.text = "Senior"
        }
    }

    override fun getItemCount(): Int {
        return  animalsList.size
    }

}