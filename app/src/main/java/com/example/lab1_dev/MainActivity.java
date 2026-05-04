package com.example.lab1_dev;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variable pour garder la trace des clics
    private int clickNumber = 0;

    // Référence vers l'élément qui montre le chiffre
    private TextView numberShower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connexion des éléments de l'interface
        numberShower = findViewById(R.id.numberDisplay);
        Button showMsgBtn = findViewById(R.id.notificationButton);
        Button addOneBtn = findViewById(R.id.incrementButton);

        // Action pour afficher un message éphémère
        showMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Salut l'équipe !", Toast.LENGTH_SHORT).show();
            }
        });

        // Action pour augmenter le compteur
        addOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNumber++;  // On monte d'un cran
                numberShower.setText(String.valueOf(clickNumber));
            }
        });
    }
}