package com.example.viewpagertext

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    // Step 1: Declare Variables
    private lateinit var viewPager: ViewPager2;
    private lateinit var pagerAdapter: ViewPagerAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Step 6: Set Adapter
        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = ViewPagerAdapter();
        viewPager.adapter = pagerAdapter;
    }
}

// Step 2: Create a new Kotlin file named ViewPagerAdapter.kt
class ViewPagerAdapter : RecyclerView.Adapter<ViewHolder>() {
    // Step 4: Create a List

    //arrayOf랑 차이뭐임?
    private val itemList = listOf("First", "Second", "Third", "Fourth", "Fifth");
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.page_layout, parent, false);

        return com.example.viewpagertext.ViewHolder(view);
    }




    override fun getItemCount(): Int {
        return itemList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position];
        holder.bind(item);
    }
}

// Step 3: Create a new Kotlin file named ViewPagerItem.kt
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val pagerText: TextView = itemView.findViewById(R.id.pagerText);

    fun bind(text: String) {
        pagerText.text = text;
    }
}