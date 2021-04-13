package com.example.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.food_recipe_app.R
import com.example.models.DietType
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

class BottomSheetFragment : BottomSheetDialogFragment() {
    private val mealTypes = ArrayList<CharSequence>()
    private val mealTypesList = MutableLiveData<ArrayList<CharSequence>>()
    private val dietTypesList = ArrayList<DietType>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
        val btnApply : Button = root.findViewById(R.id.btn_apply)

        btnApply.setOnClickListener{
            registerFilterChange()

            println("Apply button clicked!!")
            Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()
        }
        return root
    }

    fun getMealTypeList() : LiveData<ArrayList<CharSequence>> {
        mealTypesList.value = mealTypes
        return mealTypesList
    }

    private fun registerFilterChange() {
        mealTypes.add(chip_group.findViewById<Chip>(id).text)


        println(mealTypes)
    }


}