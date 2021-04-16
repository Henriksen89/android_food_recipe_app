package com.example.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.forEach
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.food_recipe_app.R
import com.example.food_recipe_app.databinding.FragmentBottomSheetBinding
import com.example.food_recipe_app.databinding.FragmentRecipeBinding
import com.example.models.DietType
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

class BottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!

    private val mealTypes = ArrayList<CharSequence>()
    private val mealTypesList = MutableLiveData<ArrayList<CharSequence>>()
    private val dietTypesList = ArrayList<DietType>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        //val btnApply : Button = root.findViewById(R.id.btn_apply)

        binding.btnApply.setOnClickListener{
            if (chip_main_course.isChecked){
                println("main")
            }
            println("Apply button clicked!!")
            Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_bottomSheetFragment_to_recipeFragment)
        }



        return binding.root
    }

    fun getMealTypeList() : LiveData<ArrayList<CharSequence>> {
        mealTypesList.value = mealTypes
        return mealTypesList
    }

    private fun registerFilterChange() {


    }


}