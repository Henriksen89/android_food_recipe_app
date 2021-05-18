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
        var counter = 1
        var instructions = ""
        for(i in bundle?.getStringArray("instructions")!!){
            println(i)
            instructions += counter.toString() + ".  " +  i + "\n"
            counter++
        }
        binding.textViewInstructions.text = instructions
    }

}