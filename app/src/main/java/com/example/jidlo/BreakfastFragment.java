package com.example.jidlo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
        requestPermissions(permissions, PERMISSION_CODE);

        gridView = (GridView)rootView.findViewById(R.id.gridBreakfast);
        adapter = new CustomGridView(getContext(), breakfastRecipes);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),GridItemActivity.class);
                intent.putExtra("title", breakfastRecipes.get(position).title);
                intent.putExtra("desc", breakfastRecipes.get(position).description);
                intent.putExtra("ingredient1", breakfastRecipes.get(position).ingredient1);
                intent.putExtra("ingredient2", breakfastRecipes.get(position).ingredient2);
                intent.putExtra("ingredient3", breakfastRecipes.get(position).ingredient3);
                intent.putExtra("ingredient4", breakfastRecipes.get(position).ingredient4);
                intent.putExtra("ingredient5", breakfastRecipes.get(position).ingredient5);
                intent.putExtra("ingredient6", breakfastRecipes.get(position).ingredient6);
                intent.putExtra("ingredient7", breakfastRecipes.get(position).ingredient7);
                intent.putExtra("ingredient8", breakfastRecipes.get(position).ingredient8);
                intent.putExtra("ingredient9", breakfastRecipes.get(position).ingredient9);
                intent.putExtra("ingredient10", breakfastRecipes.get(position).ingredient10);
                intent.putExtra("ingredient11", breakfastRecipes.get(position).ingredient11);
                intent.putExtra("ingredient12", breakfastRecipes.get(position).ingredient12);
                intent.putExtra("ingredient13", breakfastRecipes.get(position).ingredient13);
                intent.putExtra("ingredient14", breakfastRecipes.get(position).ingredient14);
                intent.putExtra("ingredient15", breakfastRecipes.get(position).ingredient15);
                intent.putExtra("ingredient16", breakfastRecipes.get(position).ingredient16);
                intent.putExtra("ingredient17", breakfastRecipes.get(position).ingredient17);
                intent.putExtra("ingredient18", breakfastRecipes.get(position).ingredient18);
                intent.putExtra("ingredient19", breakfastRecipes.get(position).ingredient19);
                intent.putExtra("ingredient20", breakfastRecipes.get(position).ingredient20);
                intent.putExtra("step1", breakfastRecipes.get(position).step1);
                intent.putExtra("step2", breakfastRecipes.get(position).step2);
                intent.putExtra("step3", breakfastRecipes.get(position).step3);
                intent.putExtra("step4", breakfastRecipes.get(position).step4);
                intent.putExtra("step5", breakfastRecipes.get(position).step5);
                intent.putExtra("step6", breakfastRecipes.get(position).step6);
                intent.putExtra("step7", breakfastRecipes.get(position).step7);
                intent.putExtra("step8", breakfastRecipes.get(position).step8);
                intent.putExtra("step9", breakfastRecipes.get(position).step9);
                intent.putExtra("step10", breakfastRecipes.get(position).step10);

               startActivity(intent);

            }
        });

        return  rootView;
    }
}
