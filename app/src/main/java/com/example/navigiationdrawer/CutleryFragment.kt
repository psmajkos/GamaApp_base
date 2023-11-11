package com.example.navigiationdrawer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CutleryFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_porcelain, container, false)
        Log.d("HomeFragment", "Initializing RecyclerView")
        recyclerView = view.findViewById(R.id.porcelainViewlist)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        foodList = ArrayList()
        // Populate foodList with data here...
        foodList.add(Food(R.drawable.eternum_lyzeczka_do_herbaty, "Łyżeczka deserowa Eternum","Łyżeczka deserowa ze stali nierdzewnej 18/10 firmy Eternum, linia Sonate.", 0.40))
        foodList.add(Food(R.drawable.stolowa_eternum_sonate_lyzka, "Łyżka stołowa Eternum", "Łyżka stołowa ze stali 18/10 Eternum, linia Sonate", 0.40))

        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter

        foodAdapter.onItemClick = {
            val intent = Intent(requireContext(), DetailedActivity::class.java)
            intent.putExtra("food", it)

            startActivity(intent)
        }


        Log.d("HomeFragment", "foodList size: ${foodList.size}")
        return view
    }

    // ... other methods in your fragment
}