package com.example.vkrfoodapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CardActivity extends AppCompatActivity {

    public String cardFileName = "foodInCardFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Button goToFavoriteFoodButton;
        Button goToMenuButton;
        Button makeOrderButton;
        TextView orderPrice;

        goToFavoriteFoodButton = findViewById(R.id.button_favorite);
        goToMenuButton = findViewById(R.id.button_menu);
        makeOrderButton = findViewById(R.id.make_order_button);
        orderPrice = findViewById(R.id.finish_price_text);


        goToFavoriteFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this, FavoriteFoodActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        goToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        makeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout layout = findViewById(R.id.card_food_container);
                layout.removeAllViews();
                orderPrice.setText("0 руб");

                Toast.makeText(CardActivity.this, "Заказ оформлен", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {

        super.onStart();
        openCardFile();
    }

    public void FillingFavoriteItems(Integer dishNumber, Integer category)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MenuItemFragment menuItemFragment = new MenuItemFragment(dishNumber, category);
        //FavoriteFoodFragment favoriteFoodFragment = new FavoriteFoodFragment(dishNumber,category);
        fragmentTransaction.add(R.id.card_food_container, menuItemFragment);
        fragmentTransaction.commit();
    }

    public String[] openCardFile() {
        try {
            InputStream inputStream = openFileInput(cardFileName);


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
                    strBuffer.append(lines + "\n");

                }
                for(int j = 0; j < dishesArray.length; j+=2)
                {
                    FillingFavoriteItems(Integer.valueOf(dishesArray[j]), Integer.valueOf(dishesArray[j+1]));
                }

                return dishesArray;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
