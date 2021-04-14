package com.example.views.showRecipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.food_recipe_app.R
import com.example.models.Recipe

class RecipeIngredientsFragment(var recipe: Recipe) : Fragment(){
    private lateinit var imageView: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.tab_ingredients_fragment, container, false)
        setUpRecipe(view)
        return view
    }

    fun setUpRecipe(view: View){
        imageView = view.findViewById(R.id.imageView_ingredients)
        imageView.setImageResource(recipe.image)
    }

}