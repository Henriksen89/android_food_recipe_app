package com.example.views.showRecipe

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.food_recipe_app.R
import com.example.food_recipe_app.databinding.FragmentRecipeOverviewBinding

class RecipeOverviewFragment(bundle: Bundle?) : Fragment(){
    private var bundle = bundle
    private var _binding: FragmentRecipeOverviewBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecipeOverviewBinding.inflate(inflater, container, false)
        setUpRecipe()

        return binding.root
    }

    private fun setUpRecipe(){
        binding.textViewOverviewTitle.text = bundle?.getString("textViewTitle")
        binding.textViewOverviewDescription.text = bundle?.getString("textViewDescription")
        binding.imageViewOverview.setImageBitmap(bundle?.getParcelable<Bitmap>("BitmapImage"))
    }
}
