Voici le fichier README corrigé sans la mention des screenshots dans la structure et sans la note :

---

# LAB 1 – HelloToast : Manipuler les composants et les événements 🍞

## Aperçu de l'application

Une application Android simple permettant d'afficher un message Toast temporaire et d'incrémenter un compteur. L'application contient deux boutons : un pour afficher un message contextuel, et un autre pour augmenter un nombre affiché à l'écran.

| Écran principal | Incrémentation + Toast |
|----------------|------------------------|
| <img src="pic1.png" width="200"> | <img src="pic2.png" width="200"> |

## Fonctionnalités

- **Affichage Toast** : message temporaire "Salut l'équipe !" qui apparaît en bas de l'écran
- **Compteur incrémental** : le chiffre augmente de 1 à chaque clic sur le deuxième bouton
- **Interface simple** : deux boutons organisés verticalement au centre de l'écran

## Structure du projet

```
lab1_dev/
├── app/src/main/
│   ├── java/com.example.lab1_dev/
│   │   └── MainActivity.java
│   └── res/
│       └── layout/
│           └── activity_main.xml
```

## Code source complet

### 1. Layout – `res/layout/activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="16dp">

    <!-- Zone d'affichage du nombre de clics -->
    <TextView
        android:id="@+id/numberDisplay"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="36sp"
        android:layout_marginBottom="24dp" />

    <!-- Bouton pour déclencher la notification -->
    <Button
        android:id="@+id/notificationButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Voir le message"
        android:layout_marginBottom="12dp" />

    <!-- Bouton pour augmenter le chiffre -->
    <Button
        android:id="@+id/incrementButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Ajouter 1" />
</LinearLayout>
```

### 2. Activité principale – `MainActivity.java`

```java
package com.example.lab1_dev;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

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
```

## Comment exécuter l'application

1. **Créer un projet** Android Studio avec "Empty Views Activity"
2. **Nom du projet** : `lab1_dev`
3. **Langage** : Java
4. **API minimum** : 24 (Android 7.0)
5. **Remplacer** `activity_main.xml` par le code ci-dessus
6. **Remplacer** `MainActivity.java` par le code ci-dessus
7. **Compiler** et exécuter sur émulateur ou appareil physique

## Fonctionnement

| Action | Résultat |
|--------|----------|
| Clic sur "Voir le message" | Affiche "Salut l'équipe !" en bas de l'écran pendant 2 secondes |
| Clic sur "Ajouter 1" | Le chiffre au centre augmente de 1 |
| Clics répétés sur "Ajouter 1" | Le compteur continue d'augmenter |

## Points techniques abordés

- **LinearLayout** : organisation verticale des éléments
- **TextView** : affichage du compteur avec `android:textSize="36sp"`
- **Button** : deux boutons avec gestionnaires d'événements
- **findViewById()** : liaison entre XML et code Java
- **setOnClickListener()** : écoute des clics utilisateur
- **Toast.makeText().show()** : affichage d'un message temporaire
- **Incrémentation** : `clickNumber++` et mise à jour avec `setText()`

---

**Auteur** : ELHEZZAM RANIA  
**Réalisé avec** : Android Studio sur MacOS Apple Silicon M2 (ARM-64 Native)
