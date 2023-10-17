package com.example.navigiationdrawer

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList : ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter

//    val recyclerViewLayout = layoutInflater.inflate(R.layout.recycler_view_layout, null)
//    val recyclerViewlist = recyclerViewLayout.findViewById<RecyclerView>(R.id.myRecyclerView)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        recyclerView = findViewById(R.id.recyclerView)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        foodList = ArrayList()
//
//        foodList.add(Food(R.drawable.rak_talerz_gleboki, "Talerz Głeboki Rak","Talerz głęboki z wysokiej jakości porcelany. Producent RAK, linia Banquet", 0.45))
//        foodList.add(Food(R.drawable.rak_talerz_obiadowy, "Talerz obiadowy RAK","Talerz obiadowy 27cm z wysokiej klasy porcelany firmy RAK, linia Banquet, średnica 27cm.", 0.45))
//        foodList.add(Food(R.drawable.filizanka, "Filiżanka 200ml Rak","Filiżanka z wysokiej jakości porcelany firmy RAK, linia Banquet, pojemność 200ml, elagancka i klasyczna.", 0.45))
//        foodList.add(Food(R.drawable.spodek_filizanka, "Spodek do filiżanki RAK","Spodek z wysokiej jakości porcelany firmy RAK, linia Banquet. Do filiżanki/bulionówki.", 0.35))
//        foodList.add(Food(R.drawable.rak_bulionowka, "Bulionówka 300ml RAK", "Bulionówka 300ml z wysokiej jakości porcelany firmy RAK, linia Banquet", 0.45))
//        foodList.add(Food(R.drawable.waza_rak, "Waza do zupy RAK", "Najwyższej jakości porcelana. Odporna na mycie w zmywarkach i zadrapania", 5.00))
//        foodList.add(Food(R.drawable.polmisek, "Półmisek 32cm RAK", "Półmisek owalny z wysokiej jakości porcelany firmy RAK, linia Banquet, średnica 32cm", 2.50))
//        foodList.add(Food(R.drawable.misa, "Misa 21cm RAK", "Misa z wysokiej jakości porcelany firmy RAK, linia Banquet, średnica 21cm, pojemność 1180ml.", 2.50))
//
//
//
//        foodAdapter = FoodAdapter(foodList)
//        recyclerView.adapter = foodAdapter
//
//        foodAdapter.onItemClick = {
//            val intent = Intent(this, DetailedActivity::class.java)
//            intent.putExtra("food", it)
//
//            startActivity(intent)
//        }





        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }

    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            R.id.nav_settings -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SettingsFragment()).commit()
            R.id.nav_share -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ShareFragment()).commit()
            R.id.nav_about -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AboutFragment()).commit()
            R.id.nav_logout -> Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }

    }

}
