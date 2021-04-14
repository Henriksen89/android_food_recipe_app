package com.example.views.showRecipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.food_recipe_app.R
import com.example.food_recipe_app.databinding.FragmentRecipeBinding
import com.example.food_recipe_app.databinding.FragmentRecipeIngredientsBinding
import com.example.models.Recipe

class RecipeIngredientsFragment(var recipe: Recipe) : Fragment(){
    private lateinit var imageView: ImageView
    private var _binding: FragmentRecipeIngredientsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeIngredientsBinding.inflate(inflater, container, false)

        return binding.root
    }

    fun setUpRecipe(view: View){
        //imageView = view.findViewById(R.id.)
        //imageView.setImageResource(recipe.image)
    }

}
