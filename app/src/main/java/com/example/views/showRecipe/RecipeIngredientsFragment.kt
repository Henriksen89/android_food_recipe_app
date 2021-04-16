package com.example.views.showRecipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.food_recipe_app.databinding.FragmentRecipeIngredientsBinding

class RecipeIngredientsFragment(bundle: Bundle?) : Fragment(){
    private var bundle = bundle
    private var _binding: FragmentRecipeIngredientsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeIngredientsBinding.inflate(inflater, container, false)
        setUpRecipe()
        return binding.root
    }

    fun setUpRecipe(){
        binding.textViewIngredients.text = bundle?.getString("textViewTitle")
        //imageView = view.findViewById(R.id.)
        //imageView.setImageResource(recipe.image)
    }

}
