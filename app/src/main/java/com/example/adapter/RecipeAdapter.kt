package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.food_recipe_app.R
import com.example.models.Recipe
import com.example.views.MainActivity
import com.example.views.RecipeFragment
import com.example.views.showRecipe.TabViewFragment


class RecipeAdapter(var recipeFragment: RecipeFragment) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    inner class ViewHolder(frameLayout: View?,
                           val imageView: ImageView,
                           val textViewTitle: TextView,
                           val textViewDescription: TextView, val cardView: CardView) : RecyclerView.ViewHolder(frameLayout!!)

    // DiffUtil calculates the differences between two lists and enables only update those items there were different
    // Run async in the background and will not block the main thread
    private val differCallback = object : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.recipeTitle == newItem.recipeTitle
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem == newItem
        }
    }



    interface ViewHolderListener{
        fun ViewRecipe(cardView: CardView)
    }

    private lateinit var recipes: ArrayList<Recipe>
    private lateinit var  cardView : CardView

    fun setRecipes(recipeList: ArrayList<Recipe>){
        recipes = recipeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.fragment_card, viewGroup, false)
        val textViewTitle = view.findViewById<TextView>(R.id.recipeTextViewTitle)
        val textViewDescription = view.findViewById<TextView>(R.id.recipeTextViewDescription)
        val imageView = view.findViewById<ImageView>(R.id.recipeImageView)
        cardView = view.findViewById(R.id.card_view)
        setListener(cardView, view)
        return ViewHolder(view, imageView, textViewTitle, textViewDescription, cardView)
        //viewHolder.textView.setOnClickListener { v -> deleteRecipe(viewHolder.adapterPosition, v) }
        //return viewHolder;
    }

    fun setListener(cardView: CardView, view: View){
        cardView.setOnClickListener(){
            //val activity : MainActivity = view.context as MainActivity
            //val tabViewFragment = TabViewFragment()
            recipeFragment.findNavController().navigate(R.id.action_recipeFragment_to_tabViewFragment)
            //activity.supportFragmentManager.beginTransaction().replace(R.id.recipeFragment, tabViewFragment).addToBackStack(null).commit()
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textViewTitle.text = recipes[position].recipeTitle
        viewHolder.textViewDescription.text = recipes[position].recipeDescription
       // viewHolder.imageView.setImageResource(recipes[position].image)

    }

    override fun getItemCount() = recipes.size

    /*fun getCardView(): CardView {
        if(cardView != null){return cardView}
    }*/

}