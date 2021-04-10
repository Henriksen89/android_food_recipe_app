package com.example.views.showRecipe

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.food_recipe_app.R
import com.example.viewmodels.ViewRecipeViewModel

/**
 * A placeholder fragment containing a simple view.
 */
class ViewRecipeFragment : Fragment() {

    private lateinit var viewRecipeViewModel: ViewRecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewRecipeViewModel = ViewModelProvider(this).get(ViewRecipeViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.tab_overview_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.textView_overview)
        viewRecipeViewModel.text.observe(this, Observer<String> {
            textView.text = it
        })
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): ViewRecipeFragment {
            return ViewRecipeFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}