package com.example.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.Adapter

class MainActivity : AppCompatActivity() {
    // Declare a Spinner variable
    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable edge-to-edge display
        enableEdgeToEdge()
        // Set the content view to the activity_main layout
        setContentView(R.layout.activity_main)

        // Apply window insets to the main view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // Get the system bars insets
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Set padding to the view based on system bars insets
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the Spinner by finding it by its ID
        spinner = findViewById<Spinner>(R.id.spinner)

        // Create a list of items to display in the Spinner
        val listItems = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        // Create an ArrayAdapter using the simple_spinner_item layout and the list of items
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listItems)

        // Set the layout resource to create the drop-down views
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set the adapter to the Spinner
        spinner.adapter = arrayAdapter

        // Set an item selected listener to the Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Get the selected item
                val selectedItem = parent?.getItemAtPosition(position).toString()
                // Show a toast message with the selected item
                Toast.makeText(this@MainActivity, "Selected: $selectedItem", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No action needed when nothing is selected
            }
        }
    }
}