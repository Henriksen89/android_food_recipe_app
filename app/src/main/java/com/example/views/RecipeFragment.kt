package com.example.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.food_recipe_app.R
import com.example.food_recipe_app.databinding.FragmentRecipeBinding
import com.example.models.Recipe
import kotlinx.android.synthetic.main.fragment_recipe.*

class RecipeFragment : Fragment() {
    private lateinit var binding: FragmentRecipeBinding
    private lateinit var recipe: Recipe



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.btnFilterRecipe.setOnClickListener{
            redirectToBottomSheet()
        }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    private fun redirectToBottomSheet() {
        Navigation.findNavController(requireView()).navigate(R.id.action_recipeFragment_to_bottomSheetFragment2)
    }
}