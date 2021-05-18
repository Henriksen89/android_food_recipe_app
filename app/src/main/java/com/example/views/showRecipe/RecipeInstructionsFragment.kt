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
import com.example.food_recipe_app.databinding.FragmentRecipeInstructionsBinding
import java.util.*

class RecipeInstructionsFragment(bundle: Bundle?) : Fragment(){
    private var bundle = bundle
    private var _binding: FragmentRecipeInstructionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecipeInstructionsBinding.inflate(inflater, container, false)
        setUpRecipe()
        return binding.root
    }

    fun setUpRecipe() {
        binding.textViewInstructions.text = Arrays.toString(bundle?.getStringArray("instructions"))
        // imageView = view.findViewById(R.id.imageView_instructions)
        //imageView.setImageResource(recipe.image)
    }

    fun iterator(){
        for(i in bundle?.getStringArray("instructions")!!){
            binding.textViewInstructions.text = i

        }
    }
}