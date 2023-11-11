package com.example.navigiationdrawer

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
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
    private val cartItems: MutableList<Food> = mutableListOf()
    private lateinit var cartAdapter: CartAdapter // Create a CartAdapter for the cart

//    val recyclerViewLayout = layoutInflater.inflate(R.layout.recycler_view_layout, null)
//    val recyclerViewlist = recyclerViewLayout.findViewById<RecyclerView>(R.id.myRecyclerView)

    data class CartItem(val food: Food, val quantity: Int)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_cart -> Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show()
            R.id.nav_favorite -> Toast.makeText(this, "Favorite selected", Toast.LENGTH_SHORT).show()
            R.id.nav_third_item -> Toast.makeText(this, "Third item selected", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


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
                .replace(R.id.fragment_container, PorcelainFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }

    }
//    // Add a function to add items to the cart.
//    fun addToCart(food: Food, quantity: Int) {
//        // Check if the item is already in the cart.
//        val existingCartItem = cartItems.find { it.product == food }
//        if (existingCartItem != null) {
//            // If the item is already in the cart, update the quantity.
//            existingCartItem.quantity += quantity
//        } else {
//            // If the item is not in the cart, add it.
//            val cartItem = CartItem(food, quantity)
//            cartItems.add(cartItem)
//        }
//        // Refresh the cart RecyclerView.
//        // Implement this part to update the cart's RecyclerView with the new data.
//    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PorcelainFragment()).commit()
            R.id.nav_settings -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CutleryFragment()).commit()
            R.id.nav_share -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ShareFragment()).commit()
            R.id.nav_about -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AboutFragment()).commit()
//            R.id.cart -> supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, CartFragment()).commit()
            R.id.nav_logout -> Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }

    }
    // Function to add the selected product to the cart
//    fun addToCart(view: View) {
//        val quantityEditText = findViewById<EditText>(R.id.editText)
//        val quantity = quantityEditText.text.toString().toIntOrNull() ?: 0 // Parse quantity from EditText
//
//        if (quantity > 0) {
//            val food = intent.getParcelableExtra<Food>("food")
//
//            if (food != null) {
//                food.quantity = quantity
//                cartItems.add(food)
//
//                // Notify the cart adapter that data has changed
//                cartAdapter.notifyDataSetChanged()
//
//                // Optionally, you can clear the quantity EditText:
//                quantityEditText.text.clear()
//            }
//        }
//    }



}

