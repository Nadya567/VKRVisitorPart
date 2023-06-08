package com.example.vkrfoodapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;

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

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Menu");
                query.orderByDescending("createdAt");
                query.findInBackground((objects, e) -> {
                    if(e == null)
                    {
                        int size = objects.size();

                        for(int i = 0; i < size; i++)
                        {
                            if(objects.get(i).getNumber("CategoryNumber").toString().equals("0"))
                            {
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                MenuItemFragment menuItemFragment = new MenuItemFragment(objects.get(i).getNumber("DishNumber").toString(), objects.get(i).getString("DishName"),
                                        objects.get(i).getNumber("DishPrice").toString(),  objects.get(i).getString("DishDescription"),0);
                                fragmentTransaction.add(R.id.description_food_container, menuItemFragment);
                                fragmentTransaction.commit();
                            }
                        }

                    }
                    else
                    {
                        Log.d("!!!!&", "!!!");
                    }
                });
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

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Menu");
                query.orderByDescending("createdAt");
                query.findInBackground((objects, e) -> {
                    if(e == null)
                    {
                        int size = objects.size();

                        for(int i = 0; i < size; i++)
                        {
                            if(objects.get(i).getNumber("CategoryNumber").toString().equals("1"))
                            {
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                MenuItemFragment menuItemFragment = new MenuItemFragment(objects.get(i).getNumber("DishNumber").toString(), objects.get(i).getString("DishName"),
                                        objects.get(i).getNumber("DishPrice").toString(), objects.get(i).getString("DishDescription"), 1);
                                fragmentTransaction.add(R.id.description_food_container, menuItemFragment);
                                fragmentTransaction.commit();
                            }
                        }

                    }
                    else
                    {
                        Log.d("!!!!&", "!!!");
                    }
                });
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

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Menu");
                query.orderByDescending("createdAt");
                query.findInBackground((objects, e) -> {
                    if(e == null)
                    {
                        int size = objects.size();

                        for(int i = 0; i < size; i++)
                        {
                            if(objects.get(i).getNumber("CategoryNumber").toString().equals("2"))
                            {
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                MenuItemFragment menuItemFragment = new MenuItemFragment(objects.get(i).getNumber("DishNumber").toString(), objects.get(i).getString("DishName"),
                                        objects.get(i).getNumber("DishPrice").toString(), objects.get(i).getString("DishDescription"), 2);
                                fragmentTransaction.add(R.id.description_food_container, menuItemFragment);
                                fragmentTransaction.commit();
                            }
                        }

                    }
                    else
                    {
                        Log.d("!!!!&", "!!!");
                    }
                });
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

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Menu");
                query.orderByDescending("createdAt");
                query.findInBackground((objects, e) -> {
                    if(e == null)
                    {
                        int size = objects.size();

                        for(int i = 0; i < size; i++)
                        {
                            if(objects.get(i).getNumber("CategoryNumber").toString().equals("3"))
                            {
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                MenuItemFragment menuItemFragment = new MenuItemFragment(objects.get(i).getNumber("DishNumber").toString(), objects.get(i).getString("DishName"),
                                        objects.get(i).getNumber("DishPrice").toString(), objects.get(i).getString("DishDescription"), 3);
                                fragmentTransaction.add(R.id.description_food_container, menuItemFragment);
                                fragmentTransaction.commit();
                            }
                        }

                    }
                    else
                    {
                        Log.d("!!!!&", "!!!");
                    }
                });
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

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Menu");
                query.orderByDescending("createdAt");
                query.findInBackground((objects, e) -> {
                    if(e == null)
                    {
                        int size = objects.size();

                        for(int i = 0; i < size; i++)
                        {
                            if(objects.get(i).getNumber("CategoryNumber").toString().equals("4"))
                            {
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                MenuItemFragment menuItemFragment = new MenuItemFragment(objects.get(i).getNumber("DishNumber").toString(), objects.get(i).getString("DishName"),
                                        objects.get(i).getNumber("DishPrice").toString(), objects.get(i).getString("DishDescription"), 4);
                                fragmentTransaction.add(R.id.description_food_container, menuItemFragment);
                                fragmentTransaction.commit();
                            }
                        }

                    }
                    else
                    {
                        Log.d("!!!!&", "!!!");
                    }
                });
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

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Menu");
                query.orderByDescending("createdAt");
                query.findInBackground((objects, e) -> {
                    if(e == null)
                    {
                        int size = objects.size();

                        for(int i = 0; i < size; i++)
                        {
                            if(objects.get(i).getNumber("CategoryNumber").toString().equals("5"))
                            {
                                FragmentManager fragmentManager = getSupportFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                MenuItemFragment menuItemFragment = new MenuItemFragment(objects.get(i).getNumber("DishNumber").toString(), objects.get(i).getString("DishName"),
                                        objects.get(i).getNumber("DishPrice").toString(), objects.get(i).getString("DishDescription"), 5);
                                fragmentTransaction.add(R.id.description_food_container, menuItemFragment);
                                fragmentTransaction.commit();
                            }
                        }

                    }
                    else
                    {
                        Log.d("!!!!&", "!!!");
                    }
                });
            }
        });
    }
}