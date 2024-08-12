package com.example.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
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

        // Explicit Intent를 추가한다.
        val explicitButton = findViewById<Button>(R.id.explicitButton);

        // 클릭 이벤트를 만든다.
        explicitButton.setOnClickListener {

            // 인텐트 객체를 추가한다.
            val explicitIntent = Intent(this, SecondActivity::class.java);

            // SecondIntent로 이동한다.
            startActivity(explicitIntent);

            // finish()를 하게되면, MainActivity가 종료되어서, secondActicity에서 뒤로가기로 돌아갈 곳이 사라진다.
            finish();
        }

        // Implicit Itent
        val implicitButton = findViewById<Button>(R.id.implicitButton);
        val url = "https://www.google.com";

        implicitButton.setOnClickListener {
            val implicitIntent = Intent(Intent.ACTION_CREATE_DOCUMENT, Uri.parse((url)))
            startActivity(implicitIntent);
        }
    }
}