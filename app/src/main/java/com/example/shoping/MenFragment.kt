package com.example.shoping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment

class MenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val autoCompleteTextView: AutoCompleteTextView = view.findViewById(R.id.autoCompleteTextView)
        val apparel: AutoCompleteTextView = view.findViewById(R.id.apparel)
        val Bag: AutoCompleteTextView = view.findViewById(R.id.Bag)
        val shoes: AutoCompleteTextView = view.findViewById(R.id.shoes)
        val beauty: AutoCompleteTextView = view.findViewById(R.id.Beauty)
        val accessories: AutoCompleteTextView = view.findViewById(R.id.Accessories)

        val items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, items)


        autoCompleteTextView.setAdapter(adapter)
        apparel.setAdapter(adapter)
        Bag.setAdapter(adapter)
        shoes.setAdapter(adapter)
        beauty.setAdapter(adapter)
        accessories.setAdapter(adapter)
    }
}