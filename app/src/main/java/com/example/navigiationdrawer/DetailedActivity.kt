package com.example.navigiationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val food = intent.getParcelableExtra<Food>("food")
        if (food != null) {

            val textView : TextView = findViewById(R.id.detailedActivityTv)
            val descriptionView : TextView = findViewById(R.id.descriptionActivityTv)
            val priceView : TextView = findViewById(R.id.priceActivityTv)

            val imageView : ImageView = findViewById(R.id.detailedActivityIv)


            textView.text = food.name
            descriptionView.text = food.description ?: "No description available"
            priceView.text = food.price.toString()
            imageView.setImageResource(food.image)

        }
    }

}
