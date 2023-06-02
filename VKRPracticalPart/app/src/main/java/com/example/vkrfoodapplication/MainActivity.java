package com.example.vkrfoodapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button goToFavoriteFoodButton;
    Button goToCardButton;

    Button saladsButton;
    Button soupsButton;
    Button hotDishesButton;
    Button secondDishesButton;
    Button drinksButton;
    Button dessertsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonsInitialization();
    }


    private void ButtonsInitialization()
    {
        goToFavoriteFoodButton = findViewById(R.id.button_favorite);
        goToCardButton = findViewById(R.id.button_basket);


        saladsButton = findViewById(R.id.salads_button);
        soupsButton = findViewById(R.id.soups_button);
        hotDishesButton = findViewById(R.id.hot_dishes_button);
        secondDishesButton = findViewById(R.id.second_dishes_button);
        drinksButton = findViewById(R.id.drinks_button);
        dessertsButton = findViewById(R.id.desserts_button);

        goToFavoriteFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavoriteFoodActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);

            }
        });

        goToCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });


        saladsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout container = findViewById(R.id.description_food_container);
                container.removeAllViews();
                MenuFragment menuFragment = new MenuFragment();



                //getSupportFragmentManager().beginTransaction().replace(R.id.description_food_container, menuFragment).commit();

                //MenuItemFragment menuItemFragment = new MenuItemFragment();

                for(int i = 0; i < 4; i++)
                {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    MenuItemFragment menuItemFragment = new MenuItemFragment(i, 0);
                    fragmentTransaction.add(R.id.description_food_container, menuItemFragment);
                    fragmentTransaction.commit();
                }
            }
        });

        soupsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout container = findViewById(R.id.description_food_container);
                container.removeAllViews();
                MenuFragment menuFragment = new MenuFragment();

                //getSupportFragmentManager().beginTransaction().replace(R.id.description_food_container, menuFragment).commit();

                //MenuItemFragment menuItemFragment = new MenuItemFragment();

                for(int i = 0; i < 3; i++)
                {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    MenuItemFragment menuItemFragment = new MenuItemFragment(i, 1);
                    fragmentTransaction.add(R.id.description_food_container, menuItemFragment);
                    fragmentTransaction.commit();

                    //menuItemFragment.changeText(i);
                }
            }
        });

        hotDishesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout container = findViewById(R.id.description_food_container);
                container.removeAllViews();
                MenuFragment menuFragment = new MenuFragment();

                //getSupportFragmentManager().beginTransaction().replace(R.id.description_food_container, menuFragment).commit();

                //MenuItemFragment menuItemFragment = new MenuItemFragment();

                for(int i = 0; i < 3; i++)
                {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    MenuItemFragment menuItemFragment = new MenuItemFragment(i, 2);
                    fragmentTransaction.add(R.id.description_food_container, menuItemFragment);
                    fragmentTransaction.commit();

                    //menuItemFragment.changeText(i);
                }
            }
        });

        secondDishesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout container = findViewById(R.id.description_food_container);
                container.removeAllViews();
                MenuFragment menuFragment = new MenuFragment();

                //getSupportFragmentManager().beginTransaction().replace(R.id.description_food_container, menuFragment).commit();

                //MenuItemFragment menuItemFragment = new MenuItemFragment();

                for(int i = 0; i < 10; i++)
                {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    MenuItemFragment menuItemFragment = new MenuItemFragment(i, 3);
                    fragmentTransaction.add(R.id.description_food_container, menuItemFragment);
                    fragmentTransaction.commit();

                    //menuItemFragment.changeText(i);
                }
            }
        });

        drinksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout container = findViewById(R.id.description_food_container);
                container.removeAllViews();
                MenuFragment menuFragment = new MenuFragment();

                //getSupportFragmentManager().beginTransaction().replace(R.id.description_food_container, menuFragment).commit();

                //MenuItemFragment menuItemFragment = new MenuItemFragment();

                for(int i = 0; i < 10; i++)
                {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    MenuItemFragment menuItemFragment = new MenuItemFragment(i, 4);
                    fragmentTransaction.add(R.id.description_food_container, menuItemFragment);
                    fragmentTransaction.commit();

                    //menuItemFragment.changeText(i);
                }
            }
        });

        dessertsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout container = findViewById(R.id.description_food_container);
                container.removeAllViews();
                MenuFragment menuFragment = new MenuFragment();

                //getSupportFragmentManager().beginTransaction().replace(R.id.description_food_container, menuFragment).commit();

                //MenuItemFragment menuItemFragment = new MenuItemFragment();

                for(int i = 0; i < 10; i++)
                {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    MenuItemFragment menuItemFragment = new MenuItemFragment(i, 5);
                    fragmentTransaction.add(R.id.description_food_container, menuItemFragment);
                    fragmentTransaction.commit();

                    //menuItemFragment.changeText(i);
                }
            }
        });
    }
}