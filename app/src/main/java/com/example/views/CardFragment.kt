package com.example.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.food_recipe_app.R
import com.example.food_recipe_app.databinding.FragmentCardBinding
import com.example.viewmodels.RecipeViewModel

class CardFragment : Fragment() {
    private lateinit var bindingCard: FragmentCardBinding

    private val recipeViewModel: RecipeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingCard = FragmentCardBinding.inflate(inflater, container, false)
        bindingCard.card = recipeViewModel

        return bindingCard.root
    }

}