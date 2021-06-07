package com.example.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.RecipeAdapter
import com.example.food_recipe_app.R
import com.example.food_recipe_app.databinding.FragmentRecipeBinding
import com.example.viewmodels.RecipeViewModel
import androidx.fragment.app.activityViewModels

class RecipeFragment : Fragment() {
    // Data binding
    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecipeAdapter
    private val recipeViewModel: RecipeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)

        binding.btnFilterRecipe.setOnClickListener {
            findNavController().navigate(R.id.action_recipeFragment_to_bottomSheetFragment)
        }

        recyclerView = binding.RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)

        adapter = RecipeAdapter(this)
        adapter.setRecipes(recipeViewModel.getRecipes().value!!)

        recyclerView.adapter = adapter

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        println("RecipeOnStart")
    }

    override fun onResume() {
        super.onResume()
        println("RecipeOnResume")
    }

    override fun onPause() {

        super.onPause()
        println("RecipeOnPause")
    }

    override fun onStop() {
        super.onStop()
        println("RecipeOnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("RecipeOnDestroy")
    }
}

