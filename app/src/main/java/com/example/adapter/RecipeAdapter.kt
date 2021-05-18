package com.example.adapter

import android.graphics.Bitmap
import android.os.Bundle
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
import kotlinx.android.synthetic.main.fragment_card.view.*


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
    private lateinit var textViewTitle : TextView
    private lateinit var textViewDescription : TextView
    private lateinit var imageView: ImageView


    fun setRecipes(recipeList: ArrayList<Recipe>){
        recipes = recipeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_card, viewGroup, false)
        textViewTitle = view.findViewById<TextView>(R.id.recipeTextViewTitle)
        textViewDescription = view.findViewById<TextView>(R.id.recipeTextViewDescription)
        imageView = view.findViewById<ImageView>(R.id.recipeImageView)
        val cardView = view.findViewById<CardView>(R.id.card_view)



        return ViewHolder(view, imageView, textViewTitle, textViewDescription, cardView)
        //viewHolder.textView.setOnClickListener { v -> deleteRecipe(viewHolder.adapterPosition, v) }
        //return viewHolder;
    }

    private fun setCardViewListener(cardView: CardView, position: Int){
        cardView.setOnClickListener(){
            val bundle = Bundle()
            bundle.putString("textViewTitle", recipes[position].recipeTitle)
            bundle.putString("textViewDescription", recipes[position].recipeDescription)


            bundle.putStringArray("ingredients", recipes[position].ingredients.toTypedArray())


            bundle.putStringArray("instructions", recipes[position].instructions.toTypedArray())

            bundle.putParcelable("BitmapImage", recipes[position].image)
            //val bundle = bundleOf("textViewTitle" to textViewTitle, "textViewDescription" to textViewDescription)
            recipeFragment.findNavController().navigate(R.id.action_recipeFragment_to_tabViewFragment, bundle)


        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val cardView = viewHolder.cardView
        viewHolder.textViewTitle.text = recipes[position].recipeTitle
        viewHolder.textViewDescription.text = recipes[position].recipeDescription
        viewHolder.imageView.setImageBitmap(recipes[position].image)
        setCardViewListener(cardView, position)
    }

    override fun getItemCount() = recipes.size


}
