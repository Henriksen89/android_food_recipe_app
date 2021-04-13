package com.example.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.food_recipe_app.R
import com.example.food_recipe_app.databinding.FragmentRecipeBinding
import com.example.models.Recipe

class RecipeFragment : Fragment() {
    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding!!
   // private lateinit var recipe: Recipe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)

        binding.btnFilterRecipe.setOnClickListener{
            findNavController().navigate(R.id.action_recipeFragment_to_bottomSheetFragment)
        }
        return binding.root
        }
    }
