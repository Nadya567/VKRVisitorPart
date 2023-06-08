package com.example.vkrfoodapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class FoodDescriptionFragment extends Fragment {

    //private int dishNumber;
    //private int category;

    String dishNumber;
    String dishName;
    String dishPrice;
    String dishDescription;
    int category;

    ImageView bigPicture;
    TextView textTitle;
    TextView textDescription;
    TextView textPrice;
    Button buttonClose;
    Button putInCardButton;
    Button putInFavoriteButton;
    public String fileName = "favoriteFoodFile.txt";
    public String cardFileName = "foodInCardFile.txt";

    //FavoriteFoodActivity favoriteFoodActivity = (FavoriteFoodActivity)getApplicationContext();;
    FavoriteFoodList favoriteFoodList = new FavoriteFoodList();

    public FoodDescriptionFragment(String _dishNumber, String _dishName, String _dishPrice, String _dishDescription, int _category) {
        dishNumber = _dishNumber;
        dishName = _dishName;
        dishPrice = _dishPrice;
        dishDescription = _dishDescription;
        category = _category;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();

       bigPicture = view.findViewById(R.id.big_food_image);
       textTitle = view.findViewById(R.id.food_title);
       textDescription = view.findViewById(R.id.food_description);
       textPrice = view.findViewById(R.id.food_price);
       buttonClose = view.findViewById(R.id.button_close);
       putInCardButton = view.findViewById(R.id.put_in_card_button);
       putInFavoriteButton = view.findViewById(R.id.put_in_favorite_button);

       buttonClose.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               fragmentClose();
           }
       });

       putInCardButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               saveCardFile(dishName);
           }
       });

       putInFavoriteButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //favoriteFoodList.FillingFavoriteDishesArray(category, dishNumber);

               //saveFile(textTitle.getText().toString(), textPrice.getText().toString());
               saveFile(dishName);
           }
       });

        FragmentFilling();
    }

    private void fragmentClose(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .remove(this);

        fragmentTransaction.commit();
    }

    private void FragmentFilling()
    {
        if(category == 0)
        {
            //String[] names = getResources().getStringArray(R.array.SaladsName);
            //String[] prices = getResources().getStringArray(R.array.SaladsPrices);
            TypedArray images = getResources().obtainTypedArray(R.array.SaladsImages);

            bigPicture.setImageResource(images.getResourceId(Integer.parseInt(dishNumber), category));
            textTitle.setText(dishName);
            textDescription.setText(dishDescription);
            textPrice.setText(dishPrice);
        }

        if(category == 1)
        {
            TypedArray images = getResources().obtainTypedArray(R.array.SoupsImages);

            bigPicture.setImageResource(images.getResourceId(Integer.parseInt(dishNumber), category));
            textTitle.setText(dishName);
            textDescription.setText(dishDescription);
            textPrice.setText(dishPrice);
        }

        if(category == 2)
        {
            TypedArray images = getResources().obtainTypedArray(R.array.HotDishesImages);

            bigPicture.setImageResource(images.getResourceId(Integer.parseInt(dishNumber), category));
            textTitle.setText(dishName);
            textDescription.setText(dishDescription);
            textPrice.setText(dishPrice);
        }

        if(category == 3)
        {
            TypedArray images = getResources().obtainTypedArray(R.array.SecondDishesImages);

            bigPicture.setImageResource(images.getResourceId(Integer.parseInt(dishNumber), category));
            textTitle.setText(dishName);
            textDescription.setText(dishDescription);
            textPrice.setText(dishPrice);
        }

        if(category == 4)
        {
            TypedArray images = getResources().obtainTypedArray(R.array.DrinksImages);

            bigPicture.setImageResource(images.getResourceId(Integer.parseInt(dishNumber), category));
            textTitle.setText(dishName);
            textDescription.setText(dishDescription);
            textPrice.setText(dishPrice);
        }

        if(category == 5)
        {
            TypedArray images = getResources().obtainTypedArray(R.array.DessertsImages);

            bigPicture.setImageResource(images.getResourceId(Integer.parseInt(dishNumber), category));
            textTitle.setText(dishName);
            textDescription.setText(dishDescription);
            textPrice.setText(dishPrice);
        }

    }

    public FoodDescriptionFragment() {
    }
    public static FoodDescriptionFragment newInstance(String param1, String param2) {
        FoodDescriptionFragment fragment = new FoodDescriptionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_food_description, container, false);
    }

    /*public void saveFile(String name, String price)
    {
        try //MODE_WORLD_READABLE и/или MODE_WORLD_WRITEABLE
        {
            OutputStream outputStream = requireActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(name);
            outputStreamWriter.write(price);
            outputStreamWriter.close();
            Toast.makeText(getActivity(), name + " добавлен", Toast.LENGTH_SHORT).show();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }*/

    public void saveFile(String name)
    {
        StringBuffer buffer = openFile();
        try
        {
            if(buffer != null)
            {
                buffer.append(name + "\n");
                OutputStream outputStream = requireActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                outputStreamWriter.write(buffer.toString());
                outputStreamWriter.close();
                Toast.makeText(getActivity(), "Добавлено в избранное", Toast.LENGTH_SHORT).show();
                return;
            }

            OutputStream outputStream = requireActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            //outputStreamWriter.write("");
            outputStreamWriter.write(name);
            outputStreamWriter.close();
            Toast.makeText(getActivity(), "Добавлено в избранное", Toast.LENGTH_SHORT).show();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    /*public void saveFile(Integer dishNumber, Integer category)
    {
        StringBuffer buffer = openFile();
        try
        {
            if(buffer != null)
            {
                buffer.append(dishNumber.toString() + "\n");
                buffer.append(category.toString() + "\n");
                OutputStream outputStream = requireActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                outputStreamWriter.write(buffer.toString());
                outputStreamWriter.close();
                Toast.makeText(getActivity(), "Добавлено в избранное", Toast.LENGTH_SHORT).show();
                return;
            }

            OutputStream outputStream = requireActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            //outputStreamWriter.write("");
            outputStreamWriter.write(dishNumber.toString() + "\n");
            outputStreamWriter.write(category.toString());
            outputStreamWriter.close();
            Toast.makeText(getActivity(), "Добавлено в избранное", Toast.LENGTH_SHORT).show();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }*/

    public StringBuffer openFile() {
        try {
            InputStream inputStream = requireActivity().openFileInput(fileName);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer strBuffer = new StringBuffer();
                String lines;

                while ((lines = bufferedReader.readLine()) != null) {
                    strBuffer.append(lines + "\n");
                }
                return strBuffer;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("!!!!", "123");
        return null;
    }



    public void saveCardFile(String name)
    {
        StringBuffer buffer = openCardFile();
        try
        {
            if(buffer != null)
            {
                buffer.append(name + "\n");
                OutputStream outputStream = requireActivity().openFileOutput(cardFileName, Context.MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                outputStreamWriter.write(buffer.toString());
                outputStreamWriter.close();
                Toast.makeText(getActivity(),"Добавлено в корзину", Toast.LENGTH_SHORT).show();
                return;
            }

            OutputStream outputStream = requireActivity().openFileOutput(cardFileName, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            //outputStreamWriter.write("");
            outputStreamWriter.write(name);
            outputStreamWriter.close();
            Toast.makeText(getActivity(),"Добавлено в корзину", Toast.LENGTH_SHORT).show();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public StringBuffer openCardFile() {
        try {
            InputStream inputStream = requireActivity().openFileInput(cardFileName);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer strBuffer = new StringBuffer();
                String lines;

                while ((lines = bufferedReader.readLine()) != null) {
                    strBuffer.append(lines + "\n");
                }
                return strBuffer;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("!!!!", "123");
        return null;
    }
}