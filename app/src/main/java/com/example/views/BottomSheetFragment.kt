package com.example.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.example.food_recipe_app.R
import com.example.models.DietType
import com.example.models.MealType
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.bottom_sheet_fragment.*

class BottomSheetFragment : BottomSheetDialogFragment() {
    private val mealTypesList = ArrayList<MealType>()
    private val dietTypesList = ArrayList<DietType>()

    private val mainCourse = MealType("Main Course")
    private val sideDish = MealType("Side Dish")
    private val dessert = MealType("Dessert")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.bottom_sheet_fragment, container, false)
        val btnApply : Button = root.findViewById(R.id.btn_apply)

        val chipMainCourse : Chip = root.findViewById(R.id.chip_main_course)
        val chipSideDish : Chip = root.findViewById(R.id.chip_side_dish)
        val chipDessert : Chip = root.findViewById(R.id.chip_dessert)

        val chipClutenFree : Chip = root.findViewById(R.id.chip_gluten_free)
        val chipVegetarian : Chip = root.findViewById(R.id.chip_vegetarian)
        val chipChicken: Chip = root.findViewById(R.id.chip_chicken)

        val chipGroup: ChipGroup = root.findViewById(R.id.chip_group)

        btnApply.setOnClickListener{

            // Meal Type
            if(chipMainCourse.isChecked){
                mealTypesList.add(mainCourse)
            } else{
                mealTypesList.remove(mainCourse)
            }
            if(chipSideDish.isChecked){
                mealTypesList.add(sideDish)
            } else{
                mealTypesList.remove(sideDish)
            }
            if(chipDessert.isChecked){
                mealTypesList.add(dessert)
            }else{
                mealTypesList.remove(dessert)
            }

            // Diet Type
            // TODO

            println(mealTypesList)
            println("Apply button clicked!!")
            Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()
        }
        return root
    }

    fun getMealTypeList() : ArrayList<MealType> {
        return mealTypesList
    }


}