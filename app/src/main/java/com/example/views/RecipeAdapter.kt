package com.example.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.food_recipe_app.R
import com.example.models.Recipe

class RecipeAdapter(private val listener: ViewHolderListener) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    class ViewHolder(frameLayout: View?, val imageView: ImageView, val textViewTitle: TextView, val textViewDescription: TextView) : RecyclerView.ViewHolder(frameLayout!!)

    private lateinit var cardView: CardView

    /**
     * Interface to communicate with the activity listener
     */
    interface ViewHolderListener{
        // fun deleteRecipeOnClick(position: Int)
        fun addRecipeOnClick(position: Int, number: Int)
        fun viewRecipe(selectedRecipe: Recipe)
    }

    private lateinit var recipes: ArrayList<Recipe>


    fun setRecipes(recipeList: ArrayList<Recipe>){
        recipes = recipeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.recipelist_main, viewGroup, false)
        cardView = view.findViewById(R.id.card_view)
        val textViewTitle = view.findViewById<TextView>(R.id.recipeTextViewTitle)
        val textViewDescription = view.findViewById<TextView>(R.id.recipeTextViewDescription)
        val imageView = view.findViewById<ImageView>(R.id.recipeImageView)

        val viewHolder = ViewHolder(view, imageView, textViewTitle, textViewDescription)

        cardView.setOnClickListener{view -> recipeView(viewHolder.adapterPosition, view)}

        return viewHolder

        //viewHolder.textView.setOnClickListener { v -> deleteRecipe(viewHolder.adapterPosition, v) }
        //return viewHolder;
    }

    override fun onBindViewHolder(viewHolder: RecipeAdapter.ViewHolder, position: Int) {
        viewHolder.textViewTitle.text = recipes[position].recipeTitle
        viewHolder.textViewDescription.text = recipes[position].recipeDescription
        viewHolder.imageView.setImageResource(recipes[position].image)



    }

    override fun getItemCount() = recipes.size

    fun recipeView(position: Int, v: View){
        listener.viewRecipe(recipes[position])
        }

}




