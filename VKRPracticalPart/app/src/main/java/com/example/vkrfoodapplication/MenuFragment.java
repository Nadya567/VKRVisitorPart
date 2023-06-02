package com.example.vkrfoodapplication;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MenuFragment extends Fragment {


    //MenuItemFragment menuItemFragment = new MenuItemFragment();

    public MenuFragment() {
    }

    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        FragmentFilling();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    private void FragmentFilling()
    {
        MenuItemFragment menuItemFragment = new MenuItemFragment();

        for(int i = 0; i < 1; i++)
        {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.food_fragments_container, menuItemFragment);
            fragmentTransaction.commit();

            //menuItemFragment.changeText(i);
        }


    }
}