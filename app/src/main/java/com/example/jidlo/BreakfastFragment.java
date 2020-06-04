package com.example.jidlo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

public class BreakfastFragment extends Fragment {

    private GridView gridView;
    private CustomGridView adapter;
    String category = "Breakfast";
    List<Recipe> breakfastRecipes;
    DatabaseHelper db;

    private static final int PICK_IMAGE = 1;
    private static final int PERMISSION_CODE = 2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {    View rootView = inflater.inflate(R.layout.breakfast_fragment, container, false);

        db = new DatabaseHelper(getActivity());
        breakfastRecipes = db.getallrecipes(category);

        //breakfastRecipes.get(0).getTitle()
        String hello = "hello";
        Toast.makeText(getContext(), hello, Toast.LENGTH_LONG).show();

        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
        requestPermissions(permissions, PERMISSION_CODE);

        gridView = (GridView)rootView.findViewById(R.id.gridBreakfast);
        adapter = new CustomGridView(getContext(), breakfastRecipes);
        gridView.setAdapter(adapter);

        return  rootView;
    }
}
