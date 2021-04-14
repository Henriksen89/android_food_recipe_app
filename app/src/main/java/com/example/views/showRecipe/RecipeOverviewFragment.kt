package com.example.views.showRecipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.food_recipe_app.R
import com.example.models.Recipe

class RecipeOverviewFragment() : Fragment(){
    private lateinit var imageView: ImageView
    private lateinit var textViewTitle: TextView
    private lateinit var textViewDescription: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_recipe_overview, container, false)
        setUpRecipe(view)

        return view
    }

    fun setUpRecipe(view: View){
        imageView = view.findViewById(R.id.imageView_overview)
        textViewTitle = view.findViewById(R.id.textView_overview_title)
        textViewDescription = view.findViewById(R.id.textView_overview_description)
        //imageView.setImageResource(recipe.image)
        //textViewTitle.text = recipe.recipeTitle
        //textViewDescription.text = recipe.recipeDescription
    }
}
