package com.example.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.RecipeAdapter
import com.example.food_recipe_app.R
import com.example.food_recipe_app.databinding.FragmentRecipeBinding
import com.example.viewmodels.RecipeViewModel

class RecipeFragment : Fragment(), RecipeAdapter.ViewHolderListener {
    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecipeAdapter
    private val recipeViewModel: RecipeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)

       // binding.RecyclerView.layoutManager.apply {
       //     requireView().findViewById<CardView>(R.id.card_view)
       // }


        binding.btnFilterRecipe.setOnClickListener{
            findNavController().navigate(R.id.action_recipeFragment_to_bottomSheetFragment)
        }

        recyclerView = binding.RecyclerView
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)

        adapter = RecipeAdapter(this)
        adapter.setRecipes(recipeViewModel.getRecipes().value!!)
        /*adapter.ViewHolder().cardView.setOnClickListener {
            findNavController().navigate(R.id.action_cardFragment_to_tabViewFragment)
        }*/
        recyclerView.adapter = adapter

        //val cardView = adapter.getCardView()
        //setCardViewListener(cardView)


        return binding.root
        }


    fun setCardViewListener(cardView: CardView){
        if(cardView != null){
        cardView.setOnClickListener(){
            findNavController().navigate(R.id.action_recipeFragment_to_tabViewFragment)

        }}
    }

    override fun ViewRecipe(cardView: CardView) {
        //cardView.setOnClickListener(){
        //    findNavController().navigate(R.id.action_recipeFragment_to_tabViewFragment)
        //}
    }

}

    //private fun setupRecyclerView(){
       // binding.RecyclerView.adapter = recipeAdapter
      //  binding.RecyclerView.layoutManager = LinearLayoutManager(requireContext())

       // recipeAdapter.setRecipes(recipeViewModel.getRecipes().value!!)
    //}

