package com.example.views.showRecipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.adapter.RecipeAdapter
import com.example.food_recipe_app.R
import com.example.food_recipe_app.databinding.FragmentRecipeBinding
import com.example.food_recipe_app.databinding.FragmentTabViewBinding

class TabViewFragment : Fragment() {
    private var _binding: FragmentTabViewBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTabViewBinding.inflate(inflater, container, false)


        binding.tab1.setOnClickListener{
            findNavController().navigate(R.id.action_tabViewFragment_to_recipeOverviewFragment)
        }
        binding.tab2.setOnClickListener{
            findNavController().navigate(R.id.action_tabViewFragment_to_recipeInstructionsFragment)
        }

        binding.tab3.setOnClickListener{
            findNavController().navigate(R.id.action_tabViewFragment_to_recipeIngredientsFragment)
        }

        return binding.root
    }
}