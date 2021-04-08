package com.example.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.food_recipe_app.R
import com.example.models.Recipe

class RecipeAdapter(private val listener: ViewHolderListener) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    class ViewHolder(frameLayout: View?, val imageView: ImageView, val textViewTitle: TextView, val textViewDescription: TextView) : RecyclerView.ViewHolder(frameLayout!!)

    interface ViewHolderListener{
        // fun deleteRecipeOnClick(position: Int)
        fun addRecipeOnClick(position: Int, number: Int)
    }

    private lateinit var recipes: ArrayList<Recipe>


    fun setRecipes(recipeList: ArrayList<Recipe>){
        recipes = recipeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.recipe, viewGroup, false)
        val textViewTitle = view.findViewById<TextView>(R.id.recipeTextViewTitle)
        val textViewDescription = view.findViewById<TextView>(R.id.recipeTextViewDescription)
        val imageView = view.findViewById<ImageView>(R.id.recipeImageView)
        return ViewHolder(view, imageView, textViewTitle, textViewDescription)
        //viewHolder.textView.setOnClickListener { v -> deleteRecipe(viewHolder.adapterPosition, v) }
        //return viewHolder;
    }

    override fun onBindViewHolder(viewHolder: RecipeAdapter.ViewHolder, position: Int) {
        viewHolder.textViewTitle.text = recipes[position].recipeTitle
        viewHolder.textViewDescription.text = recipes[position].recipeDescription
        viewHolder.imageView.setImageResource(recipes[position].image)

    }

    override fun getItemCount() = recipes.size



}