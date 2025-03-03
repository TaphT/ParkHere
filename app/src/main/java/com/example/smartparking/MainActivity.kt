package com.example.smartparking

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.os.Looper
import android.util.Log // Import for logging
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("MainActivity", "onCreate: MainActivity started")

        Handler(Looper.getMainLooper()).postDelayed({
            Log.d("MainActivity", "postDelayed: Starting Home activity")
            val intent = Intent(this, home::class.java)
            // Start the Home activity
            startActivity(intent)
            finish()
        }, 2000)
    }
}

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("HomeActivity", "onCreate: HomeActivity started")

        // Find the button by its ID
        val orderButton: Button = findViewById(R.id.order)

        // Set an onClickListener for the button
        orderButton.setOnClickListener {
            Log.d("HomeActivity", "orderButton: Starting MapActivity")
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)

        }
    }
}

class MapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        Log.d("MapActivity", "onCreate: MapActivity started")

        val alamsutra: Button = findViewById(R.id.alamsutra)

        alamsutra.setOnClickListener {
            Log.d("MapActivity", "alamsutra: Starting OrderActivity")
            val intent = Intent(this, ParkingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

class ParkingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parking)

        val spotImage: ImageView = findViewById(R.id.spotimage)

        spotImage.setOnClickListener {
            Log.d("ParkingActivity", "spotimage clicked!")
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val spotImage: ImageView = findViewById(R.id.detail)

        spotImage.setOnClickListener {
            Log.d("ParkingActivity", "spotimage clicked!")
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val spotImage: ImageView = findViewById(R.id.detail) //

        spotImage.setOnClickListener {
            Log.d("ParkingActivity", "spotimage clicked!")
            val intent = Intent(this, PaymentDetailActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

class PaymentDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_detail)

        val spotImage: ImageView = findViewById(R.id.detail) //

        spotImage.setOnClickListener {
            Log.d("ParkingActivity", "spotimage clicked!")
            val intent = Intent(this, ReceiptActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

class ReceiptActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)

        val spotImage: ImageView = findViewById(R.id.detail) //

        spotImage.setOnClickListener {
            Log.d("ParkingActivity", "spotimage clicked!")
            val intent = Intent(this, SuccessActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

class SuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

//        val spotImage: ImageView = findViewById(R.id.detail)
//
//        spotImage.setOnClickListener {
//            Log.d("ParkingActivity", "spotimage clicked!")
//            val intent = Intent(this, SuccessActivity::class.java)
//            startActivity(intent)
//        }
    }
}
