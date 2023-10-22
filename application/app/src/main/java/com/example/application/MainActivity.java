package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //implicite go to activite il ya  intaller par defaut dans notre appareil
    Button b,b2,b3,b4;
    final String textToShare = "Twas brilig and the toves";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.btn);
        b2 =findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cree objet intent
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
                //start intent
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cree objet intent
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:latitude,longitude?q=Golden Gate Bridge"));
                //start intent
                startActivity(i);
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to share text
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, textToShare);

                // Start the sharing activity
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }


        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to open the camera
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // Check if there's a camera app available to handle the intent
                if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    // Start the camera activity
                    startActivityForResult(cameraIntent, 1); // You can use a different request code
                }
            }
        });
    }
}