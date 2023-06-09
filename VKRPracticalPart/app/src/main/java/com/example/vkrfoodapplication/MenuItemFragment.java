package com.example.vkrfoodapplication;

import android.content.Context;
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

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MenuItemFragment extends Fragment {

    public ImageView foodImage;
    public TextView foodName;
    public TextView foodPrice;
    Button openInformationButton;


    String dishNumber;
    String dishName;
    String dishPrice;
    String dishDescription;
    int category;


    public MenuItemFragment() {
    }

    public MenuItemFragment(String _dishNumber, String _dishName, String _dishPrice, String _dishDescription, int _category) {
        dishNumber = _dishNumber;
        dishName = _dishName;
        dishPrice = _dishPrice;
        dishDescription = _dishDescription;
        category = _category;
    }

    public static MenuItemFragment newInstance(int h) {
        MenuItemFragment fragment = new MenuItemFragment();
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();

        openInformationButton = view.findViewById(R.id.open_information_button);

        openInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FoodDescriptionFragment foodDescriptionFragment = new FoodDescriptionFragment(dishNumber, dishName, dishPrice, dishDescription, category);
                fragmentTransaction.replace(R.id.description_food_container, foodDescriptionFragment);
                fragmentTransaction.commit();

            }
        });

        foodName = view.findViewById(R.id.food_name);
        foodImage = view.findViewById(R.id.big_food_image);
        foodPrice = view.findViewById(R.id.food_price);

        changeText();

        if (arguments != null) {
        }
    }

    public void changeText()
    {
        if(category == 0)
        {
            //String[] names = getResources().getStringArray(R.array.SaladsName);
            //String[] prices = getResources().getStringArray(R.array.SaladsPrices);
            TypedArray images = getResources().obtainTypedArray(R.array.SaladsImages);

            foodName.setText(dishName);
            foodImage.setImageResource(images.getResourceId(Integer.parseInt(dishNumber),0));
            foodPrice.setText(dishPrice);
        }


        if(category == 1)
        {
            TypedArray images = getResources().obtainTypedArray(R.array.SoupsImages);

            foodName.setText(dishName);
            foodImage.setImageResource(images.getResourceId(Integer.parseInt(dishNumber),0));
            foodPrice.setText(dishPrice);
        }

        if(category == 2)
        {
            TypedArray images = getResources().obtainTypedArray(R.array.HotDishesImages);

            foodName.setText(dishName);
            foodImage.setImageResource(images.getResourceId(Integer.parseInt(dishNumber),0));
            foodPrice.setText(dishPrice);
        }

        if(category == 3)
        {
            TypedArray images = getResources().obtainTypedArray(R.array.SecondDishesImages);

            foodName.setText(dishName);
            foodImage.setImageResource(images.getResourceId(Integer.parseInt(dishNumber),0));
            foodPrice.setText(dishPrice);
        }

        if(category == 4)
        {
            TypedArray images = getResources().obtainTypedArray(R.array.DrinksImages);

            foodName.setText(dishName);
            foodImage.setImageResource(images.getResourceId(Integer.parseInt(dishNumber),0));
            foodPrice.setText(dishPrice);
        }

        if(category == 5)
        {
            TypedArray images = getResources().obtainTypedArray(R.array.DessertsImages);

            foodName.setText(dishName);
            foodImage.setImageResource(images.getResourceId(Integer.parseInt(dishNumber),0));
            foodPrice.setText(dishPrice);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_menu_item, container, false);
    }

}