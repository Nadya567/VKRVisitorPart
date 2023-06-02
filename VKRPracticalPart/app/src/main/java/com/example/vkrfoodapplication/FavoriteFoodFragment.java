package com.example.vkrfoodapplication;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FavoriteFoodFragment extends Fragment {

    public ImageView foodImage;
    public TextView foodName;
    public TextView foodPrice;
    private int i;
    private int number;
    //Button openInformationButton;
    private Button delete_food_button;

    public FavoriteFoodFragment(int _i, int _number) {

        i = _i;
        number = _number;
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

    private void fragmentCLose() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .remove(this);

        fragmentTransaction.commit();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();

        /*delete_food_button = view.findViewById(R.id.button_delete_from_favorite);
        delete_food_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragmentCLose();
            }
        });*/


        //openInformationButton = view.findViewById(R.id.open_information_button);

        /*openInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int category = i;
                int dishNumber = number;


                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FoodDescriptionFragment foodDescriptionFragment = new FoodDescriptionFragment(category, dishNumber);
                fragmentTransaction.replace(R.id.description_food_container, foodDescriptionFragment);
                fragmentTransaction.commit();

            }
        });*/

        foodName = view.findViewById(R.id.food_name);
        foodImage = view.findViewById(R.id.big_food_image);
        foodPrice = view.findViewById(R.id.food_price);

        changeText();

        if (arguments != null) {
        }
    }

    public void changeText()
    {
        if(number == 0)
        {
            String[] names = getResources().getStringArray(R.array.SaladsName);
            String[] prices = getResources().getStringArray(R.array.SaladsPrices);
            TypedArray images = getResources().obtainTypedArray(R.array.SaladsImages);

            foodName.setText(names[i]);
            foodImage.setImageResource(images.getResourceId(i,0));
            foodPrice.setText(prices[i]);
        }

        if(number == 1)
        {
            String[] names = getResources().getStringArray(R.array.SoupsName);
            String[] prices = getResources().getStringArray(R.array.SoupsPrices);
            TypedArray images = getResources().obtainTypedArray(R.array.SoupsImages);

            foodName.setText(names[i]);
            foodImage.setImageResource(images.getResourceId(i,0));
            foodPrice.setText(prices[i]);
        }

        if(number == 2)
        {
            String[] names = getResources().getStringArray(R.array.HotDishesName);
            String[] prices = getResources().getStringArray(R.array.HotDishesPrices);
            TypedArray images = getResources().obtainTypedArray(R.array.HotDishesImages);

            foodName.setText(names[i]);
            foodImage.setImageResource(images.getResourceId(i,0));
            foodPrice.setText(prices[i]);
        }

        if(number == 3)
        {
            String[] names = getResources().getStringArray(R.array.SecondDishesName);
            String[] prices = getResources().getStringArray(R.array.SecondDishesPrices);
            TypedArray images = getResources().obtainTypedArray(R.array.SecondDishesImages);

            foodName.setText(names[i]);
            foodImage.setImageResource(images.getResourceId(i,0));
            foodPrice.setText(prices[i]);
        }

        if(number == 4)
        {
            String[] names = getResources().getStringArray(R.array.DrinksName);
            String[] prices = getResources().getStringArray(R.array.DrinksPrices);
            TypedArray images = getResources().obtainTypedArray(R.array.DrinksImages);

            foodName.setText(names[i]);
            foodImage.setImageResource(images.getResourceId(i,0));
            foodPrice.setText(prices[i]);
        }

        if(number == 5)
        {
            String[] names = getResources().getStringArray(R.array.DessertsName);
            String[] prices = getResources().getStringArray(R.array.DessertsPrices);
            TypedArray images = getResources().obtainTypedArray(R.array.DessertsImages);

            foodName.setText(names[i]);
            foodImage.setImageResource(images.getResourceId(i,0));
            foodPrice.setText(prices[i]);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_menu_item, container, false);
    }

}