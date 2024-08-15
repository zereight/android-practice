package com.example.alertdialogbox

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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

        val showButton: Button = findViewById(R.id.showButton);

        showButton.setOnClickListener {
            showAlertDialog();
        }

    }

    private fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(this).setTitle("Alert Dialog")
            .setMessage("This is an alert dialog.").setPositiveButton("OK") { dialog, which ->
                Toast.makeText(this, "You clicked OK", Toast.LENGTH_SHORT).show();
            }
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss();
            }.create();

        alertDialog.show();
    }
}