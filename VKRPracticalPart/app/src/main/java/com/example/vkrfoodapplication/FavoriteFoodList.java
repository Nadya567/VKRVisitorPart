package com.example.vkrfoodapplication;

import android.app.Application;
import android.util.Log;

import java.util.List;

public class FavoriteFoodList extends Application {

    public List<Integer> favoriteFoodCategoryList;
    public List<Integer> favoriteFoodNumberList;
    private Integer k = 0;


    public void FillingFavoriteDishesArray(int category, int number)
    {
        favoriteFoodCategoryList.add(category);
        favoriteFoodNumberList.add(number);
        k++;
        Log.d("!!!!!", k.toString());
    }
}
