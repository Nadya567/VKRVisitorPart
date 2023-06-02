package com.example.vkrfoodapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class FavoriteFoodActivity extends AppCompatActivity {

    //public Integer [][] favoriteItemsList;

    FavoriteFoodList favoriteFoodList = new FavoriteFoodList();
    public String fileName = "favoriteFoodFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_food);

        Button goToMenuButton;
        Button goToCardButton;

        goToMenuButton = findViewById(R.id.button_menu);
        goToCardButton = findViewById(R.id.button_basket);
        //Show();

        goToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavoriteFoodActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });

        goToCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FavoriteFoodActivity.this, CardActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });


    }

    @Override
    protected void onStart() {

        super.onStart();
        openFile();
    }

    public void FillingFavoriteItems(Integer dishNumber, Integer category)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MenuItemFragment menuItemFragment = new MenuItemFragment(dishNumber, category);
        //FavoriteFoodFragment favoriteFoodFragment = new FavoriteFoodFragment(dishNumber,category);
        fragmentTransaction.add(R.id.favorite_food_container, menuItemFragment);
        fragmentTransaction.commit();
    }
/*
    public StringBuffer openFile() {
        try {
            InputStream inputStream = openFileInput(fileName);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer strBuffer = new StringBuffer();
                String lines;
                String dishesArray[] = new String[2];
                int i = 0;

                while ((lines = bufferedReader.readLine()) != null) {
                    dishesArray[i] = lines;
                    i++;
                    //Toast.makeText(FavoriteFoodActivity.this, lines, Toast.LENGTH_SHORT).show();
                    strBuffer.append(lines + "\n");
                }

                //Log.d("!!!", dishesArray[0]);
                //Log.d("!!!", dishesArray[1]);
                //Toast.makeText(FavoriteFoodActivity.this, dishesArray[0], Toast.LENGTH_SHORT).show();
                //Toast.makeText(FavoriteFoodActivity.this, dishesArray[1], Toast.LENGTH_SHORT).show();

                //Сюда добавить вызов метода заполнения фрагментов

                FillingFavoriteItems(Integer.valueOf(dishesArray[0]), Integer.valueOf(dishesArray[1]));
                return strBuffer;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/

    public String[] openFile() {
        try {
            InputStream inputStream = openFileInput(fileName);


            if (inputStream != null) {

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer strBuffer = new StringBuffer();
                String lines;
                String dishesArray[] = new String[50];
                int i = 0;

                while ((lines = bufferedReader.readLine()) != null) {

                    dishesArray[i] = lines;
                    i++;
                    //Toast.makeText(FavoriteFoodActivity.this, lines, Toast.LENGTH_SHORT).show();
                    strBuffer.append(lines + "\n");

                }
                for(int j = 0; j < dishesArray.length; j+=2)
                {
                    FillingFavoriteItems(Integer.valueOf(dishesArray[j]), Integer.valueOf(dishesArray[j+1]));
                    Log.d("123", dishesArray[j]);
                    Log.d("1234", dishesArray[j+1]);
                }

                //Log.d("!!!fffffffffffffffffffffffffffffffffffffffffffffffffff", "dsssssssssssssssssssssss");

                //Log.d("!!!fffffffffffffffffffffffffffffffffffffffffffffffffff", "dishesArray[0]");
                //Log.d("!!!", dishesArray[1]);
                //Toast.makeText(FavoriteFoodActivity.this, dishesArray[0], Toast.LENGTH_SHORT).show();
                //Toast.makeText(FavoriteFoodActivity.this, dishesArray[1], Toast.LENGTH_SHORT).show();

                //Сюда добавить вызов метода заполнения фрагментов

                return dishesArray;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}