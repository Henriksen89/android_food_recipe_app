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
                           val textViewDescription: TextView,
                           val cardView: CardView) : RecyclerView.ViewHolder(frameLayout!!)

    private lateinit var recipes: ArrayList<Recipe>
    private lateinit var textViewTitle : TextView
    private lateinit var textViewDescription : TextView
    private lateinit var imageView: ImageView

    fun setRecipes(recipeList: ArrayList<Recipe>){
        recipes = recipeList
        notifyDataSetChanged()
    }

    override fun getItemCount() = recipes.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_card, viewGroup, false)
        textViewTitle = view.findViewById<TextView>(R.id.recipeTextViewTitle)
        textViewDescription = view.findViewById<TextView>(R.id.recipeTextViewDescription)
        imageView = view.findViewById<ImageView>(R.id.recipeImageView)
        val cardView = view.findViewById<CardView>(R.id.card_view)

        return ViewHolder(view, imageView, textViewTitle, textViewDescription, cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val cardView = viewHolder.cardView
        viewHolder.textViewTitle.text = recipes[position].recipeTitle
        viewHolder.textViewDescription.text = recipes[position].recipeDescription
        viewHolder.imageView.setImageBitmap(recipes[position].image)
        setCardViewListener(cardView, position)
    }

    private fun setCardViewListener(cardView: CardView, position: Int){
        cardView.setOnClickListener(){
            val bundle = Bundle()
            createBundleData(bundle, position)
            recipeFragment.findNavController().navigate(R.id.action_recipeFragment_to_tabViewFragment, bundle)
        }
    }

    private fun createBundleData(bundle: Bundle, position: Int) : Bundle{
        bundle.putString("textViewTitle", recipes[position].recipeTitle)
        bundle.putString("textViewDescription", recipes[position].recipeDescription)
        bundle.putStringArray("ingredients", recipes[position].ingredients.toTypedArray())
        bundle.putStringArray("instructions", recipes[position].instructions.toTypedArray())
        bundle.putParcelable("BitmapImage", recipes[position].image)
        return bundle
    }
}
