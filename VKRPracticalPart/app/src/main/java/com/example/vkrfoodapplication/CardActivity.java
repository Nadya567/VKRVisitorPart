package com.example.vkrfoodapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class CardActivity extends AppCompatActivity {

    public String cardFileName = "foodInCardFile.txt";
    private String dishNameInArray;
    private String[] dishArrayInOrder = new String[10];
    private int summaryCoast = 0;
    private String[] dishArray;
    private int orderNumber;
    private int productsInOrderCounter = 0;


    Button goToFavoriteFoodButton;
    Button goToMenuButton;
    Button makeOrderButton;
    Button clearCardButton;
    TextView orderPrice;
    LinearLayout cardFoodContainer;
    TextView orderNumberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);



        goToFavoriteFoodButton = findViewById(R.id.button_favorite);
        goToMenuButton = findViewById(R.id.button_menu);
        makeOrderButton = findViewById(R.id.make_order_button);
        clearCardButton = findViewById(R.id.clear_card_button);
        orderPrice = findViewById(R.id.finish_price_text);
        cardFoodContainer = findViewById(R.id.card_food_container);
        orderNumberText = findViewById(R.id.order_number_text);


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

                sendOrderToDashboard();
                Toast.makeText(CardActivity.this, "Заказ оформлен", Toast.LENGTH_SHORT).show();
            }
        });

        clearCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout layout = findViewById(R.id.card_food_container);
                layout.removeAllViews();
                clearFile();
                productsInOrderCounter = 0;
                orderPrice.setText("0 руб");
                Arrays.fill(dishArrayInOrder, "");
            }
        });
    }

    @Override
    protected void onStart() {

        super.onStart();
        //openCardFile();
        openCardFile1();

    }

    /*public void FillingFavoriteItems(Integer dishNumber, Integer category)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MenuItemFragment menuItemFragment = new MenuItemFragment(dishNumber, category);
        //FavoriteFoodFragment favoriteFoodFragment = new FavoriteFoodFragment(dishNumber,category);
        fragmentTransaction.add(R.id.card_food_container, menuItemFragment);
        fragmentTransaction.commit();
    }*/

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
                    //FillingFavoriteItems(Integer.valueOf(dishesArray[j]), Integer.valueOf(dishesArray[j+1]));
                }

                return dishesArray;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] openCardFile1() {
        try
        {
            InputStream inputStream = openFileInput(cardFileName);

            ParseQuery<ParseObject> query = ParseQuery.getQuery("Menu");
            query.orderByDescending("createdAt");

            if (inputStream != null)
            {

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

                query.findInBackground((objects, e) -> {
                    if(e == null)
                    {
                        int size = objects.size();
                        for (int o = 0; o < size; o++)
                        {
                            String name = objects.get(o).getString("DishName");
                            for (int j = 0; j < dishesArray.length; j++)
                            {
                                dishNameInArray = dishesArray[j];
                                //FillingFavoriteItems(Integer.valueOf(dishesArray[j]), Integer.valueOf(dishesArray[j+1]));

                                if (name.equals(dishNameInArray))
                                {
                                    FragmentManager fragmentManager = getSupportFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                                    MenuItemFragment menuItemFragment = new MenuItemFragment(objects.get(o).getNumber("DishNumber").toString(), objects.get(o).getString("DishName"),
                                            objects.get(o).getNumber("DishPrice").toString(), objects.get(o).getString("DishDescription"),
                                            Integer.parseInt((objects.get(o).getNumber("CategoryNumber")).toString()));
                                    dishArrayInOrder[j] = dishNameInArray;
                                    productsInOrderCounter++;

                                    summaryCoast = summaryCoast + Integer.parseInt(objects.get(o).getNumber("DishPrice").toString());
                                    String s = String.valueOf(summaryCoast);

                                    fragmentTransaction.add(R.id.card_food_container, menuItemFragment);
                                    fragmentTransaction.commit();
                                }
                            }
                        }
                        String coast = String.valueOf(summaryCoast) + " руб";
                        orderPrice.setText(coast);
                    }
                    else
                    {
                        Log.d("!!!!&", "!!!");
                    }

                });


                //Log.d("!!!fffffffffffffffffffffffffffffffffffffffffffffffffff", "dsssssssssssssssssssssss");

                //Log.d("!!!fffffffffffffffffffffffffffffffffffffffffffffffffff", "dishesArray[0]");
                //Log.d("!!!", dishesArray[1]);
                //Toast.makeText(FavoriteFoodActivity.this, dishesArray[0], Toast.LENGTH_SHORT).show();
                //Toast.makeText(FavoriteFoodActivity.this, dishesArray[1], Toast.LENGTH_SHORT).show();

                //Сюда добавить вызов метода заполнения фрагментов

                return dishesArray;

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void clearFile()
    {
        try
        {
            OutputStream outputStream = openFileOutput(cardFileName, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write("");
            outputStreamWriter.close();
            Log.d("!!!!2", "Cleared");
            //Toast.makeText(getActivity(), "Добавлено в избранное", Toast.LENGTH_SHORT).show();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    private void sendOrderToDashboard()
    {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("OrderNumber");
        query.orderByDescending("createdAt");

        query.getInBackground("iM4W3C4MBD", new GetCallback<ParseObject>() {
            public void done(ParseObject number, ParseException e) {
                if (e == null) {
                    orderNumber = Integer.parseInt(number.getNumber("Number").toString());
                    Log.d("!!!!", String.valueOf(orderNumber));

                    String numberText = "Заказ № " + String.valueOf(orderNumber);
                    orderNumberText.setText(numberText);

                    if(orderNumber <= 99)
                    {
                        number.increment("Number");
                    }

                    else
                    {
                        number.put("Number", 1);
                    }


                    number.increment("OrdersCount");

                    number.saveInBackground();
                    sendOrder();
                }
                else
                {
                    Log.d("!!!!&", "!!!");
                }
            }
        });
    }

    private void sendOrder()
    {
        ParseQuery<ParseObject> queryOrder = ParseQuery.getQuery("ProductOrders");
        queryOrder.orderByDescending("createdAt");

        queryOrder.findInBackground((objects, e) -> {
            if(e == null)
            {
                //int count = cardFoodContainer.getChildCount(); //!!!!!!!!!!
                //Log.d("!!!!3", String.valueOf(count));
                for(int i = 0; i < productsInOrderCounter; i++)
                {
                    ParseObject dish = new ParseObject("ProductOrders");

                    dish.put("OrderNumber", orderNumber);
                    Log.d("!!!!1", String.valueOf(orderNumber));
                    dish.put("DishName", dishArrayInOrder[i]);

                    dish.saveInBackground();
                }
                clearFile();
            }
            else
            {
                Log.d("!!!!&", "!!!");
            }
        });
    }
}
