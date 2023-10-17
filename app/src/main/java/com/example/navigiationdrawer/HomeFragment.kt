package com.example.navigiationdrawer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//// TODO: Rename parameter arguments, choose names that match
//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

///**
// * A simple [Fragment] subclass.
// * Use the [HomeFragment.newInstance] factory method to
// * create an instance of this fragment.
// */
class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        Log.d("HomeFragment", "Initializing RecyclerView")
        recyclerView = view.findViewById(R.id.porcelainViewlist)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        foodList = ArrayList()
        // Populate foodList with data here...
        foodList.add(Food(R.drawable.rak_talerz_gleboki, "Talerz Głeboki Rak","Talerz głęboki z wysokiej jakości porcelany. Producent RAK, linia Banquet", 0.45))
        foodList.add(Food(R.drawable.rak_talerz_obiadowy, "Talerz obiadowy RAK","Talerz obiadowy 27cm z wysokiej klasy porcelany firmy RAK, linia Banquet, średnica 27cm.", 0.45))
        foodList.add(Food(R.drawable.filizanka, "Filiżanka 200ml Rak","Filiżanka z wysokiej jakości porcelany firmy RAK, linia Banquet, pojemność 200ml, elagancka i klasyczna.", 0.45))
        foodList.add(Food(R.drawable.spodek_filizanka, "Spodek do filiżanki RAK","Spodek z wysokiej jakości porcelany firmy RAK, linia Banquet. Do filiżanki/bulionówki.", 0.35))
        foodList.add(Food(R.drawable.rak_bulionowka, "Bulionówka 300ml RAK", "Bulionówka 300ml z wysokiej jakości porcelany firmy RAK, linia Banquet", 0.45))
        foodList.add(Food(R.drawable.waza_rak, "Waza do zupy RAK", "Najwyższej jakości porcelana. Odporna na mycie w zmywarkach i zadrapania", 5.00))
        foodList.add(Food(R.drawable.polmisek, "Półmisek 32cm RAK", "Półmisek owalny z wysokiej jakości porcelany firmy RAK, linia Banquet, średnica 32cm", 2.50))
        foodList.add(Food(R.drawable.misa, "Misa 21cm RAK", "Misa z wysokiej jakości porcelany firmy RAK, linia Banquet, średnica 21cm, pojemność 1180ml.", 2.50))

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