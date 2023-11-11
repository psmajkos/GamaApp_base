package com.example.navigiationdrawer

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class DetailedActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private val cartItems = mutableListOf<CartItem>()
    private var food: Food? = null

    private var result: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        food = intent.getParcelableExtra("food")

        if (food != null) {
            val textView: TextView = findViewById(R.id.detailedActivityTv)
            val descriptionView: TextView = findViewById(R.id.descriptionActivityTv)
            val priceView: TextView = findViewById(R.id.priceActivityTv)
            val imageView: ImageView = findViewById(R.id.detailedActivityIv)

            textView.text = food!!.name
            descriptionView.text = food!!.description ?: "No description available"
            priceView.text = food!!.price.toString()
            imageView.setImageResource(food!!.image)

            val addToCart = findViewById<Button>(R.id.addToCartbutton)
            editText = findViewById<EditText>(R.id.editText)

            addToCart.setOnClickListener {
                val text = editText.text
                if (text.isNotEmpty()) {
                    val ilosc = editText.text.toString()
                    val number = ilosc.toInt()
                    result = (number * food!!.price).toInt()

                    val cartItem = CartItem(food!!.name, number, result)
                    cartItems.add(cartItem)

                    Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Podaj ilość", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    data class CartItem(val name: String, val number: Int, val result: Int)

    // Rest of your code

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Respond to the Up button click
                onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
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
//                val cartItem = CartItem(food, quantity)
//                cartItems.add(cartItem)
//
//                // Optionally, you can clear the quantity EditText:
//                quantityEditText.text.clear()
//            }
//        }
//    }

}
