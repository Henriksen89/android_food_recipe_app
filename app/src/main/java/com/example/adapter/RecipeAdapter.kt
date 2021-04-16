package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.food_recipe_app.R
import com.example.models.Recipe
import com.example.views.RecipeFragment


class RecipeAdapter(var recipeFragment: RecipeFragment) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    inner class ViewHolder(frameLayout: View?,
                           val imageView: ImageView,
                           val textViewTitle: TextView,
                           val textViewDescription: TextView, val cardView: CardView) : RecyclerView.ViewHolder(frameLayout!!)

    // DiffUtil calculates the differences between two lists and enables only update those items there were different
    // Run async in the background and will not block the main thread
    private val differCallback = object : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.recipeTitle == newItem.recipeTitle
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem == newItem
        }
    }


    private lateinit var recipes: ArrayList<Recipe>

    fun setRecipes(recipeList: ArrayList<Recipe>){
        recipes = recipeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_card, viewGroup, false)
        val textViewTitle = view.findViewById<TextView>(R.id.recipeTextViewTitle)
        val textViewDescription = view.findViewById<TextView>(R.id.recipeTextViewDescription)
        val imageView = view.findViewById<ImageView>(R.id.recipeImageView)
        val cardView = view.findViewById<CardView>(R.id.card_view)
        setCardViewListener(cardView, view)

        return ViewHolder(view, imageView, textViewTitle, textViewDescription, cardView)
        //viewHolder.textView.setOnClickListener { v -> deleteRecipe(viewHolder.adapterPosition, v) }
        //return viewHolder;
    }

    private fun setCardViewListener(cardView: CardView, view: View){
        cardView.setOnClickListener(){
            recipeFragment.findNavController().navigate(R.id.action_recipeFragment_to_tabViewFragment)

        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textViewTitle.text = recipes[position].recipeTitle
        viewHolder.textViewDescription.text = recipes[position].recipeDescription
       // viewHolder.imageView.setImageResource(recipes[position].image)

    }

    override fun getItemCount() = recipes.size


}