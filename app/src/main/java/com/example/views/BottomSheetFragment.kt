package com.example.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.food_recipe_app.R
import com.example.food_recipe_app.databinding.FragmentBottomSheetBinding
import com.example.viewmodels.RecipeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*
import androidx.fragment.app.activityViewModels

class BottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!

    private val recipeViewModel: RecipeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)

        binding.btnApply.setOnClickListener{
            var checkedMealType = getCheckMealType()
            recipeViewModel.updateMealType(checkedMealType)
            Toast.makeText(view?.context, "Selected " + checkedMealType, Toast.LENGTH_LONG).show()
            onDestroy()
            findNavController().navigate(R.id.action_bottomSheetFragment_to_recipeFragment)
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onResume() {
        super.onResume()
        println("onResume")
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("bottomsheet onDestroy")
    }

    private fun getCheckMealType(): String {
        if (chip_main_course.isChecked){
            return "MainCourse"
        }
        if (chip_side_dish.isChecked) {
            return "SideDish"
        }
        if (chip_dessert.isChecked){
            return "Dessert"
        } else {
            return "MainCourse"
        }
    }
}