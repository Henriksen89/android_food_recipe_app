package com.example.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.example.adapter.RecipeAdapter
import com.example.food_recipe_app.R
import com.example.food_recipe_app.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment() {
    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding!!


    private lateinit var recipeAdapter: RecipeAdapter

   // private lateinit var recipe: Recipe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)


        binding.btnFilterRecipe.setOnClickListener{
            findNavController().navigate(R.id.action_recipeFragment_to_bottomSheetFragment)
        }
        findNavController().navigate(R.id.action_recipeFragment_to_cardFragment)

        return binding.root
        }

    //private fun setupRecyclerView(){
       // binding.RecyclerView.adapter = recipeAdapter
      //  binding.RecyclerView.layoutManager = LinearLayoutManager(requireContext())

       // recipeAdapter.setRecipes(recipeViewModel.getRecipes().value!!)
    //}
    }
