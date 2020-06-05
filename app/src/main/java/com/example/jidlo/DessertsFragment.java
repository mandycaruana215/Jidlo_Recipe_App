package com.example.jidlo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

public class DessertsFragment extends Fragment {

    private GridView gridView;
    private CustomGridView adapter;
    String category = "Desserts";
    List<Recipe> dessertsRecipes;
    DatabaseHelper db;

    private static final int PICK_IMAGE = 1;
    private static final int PERMISSION_CODE = 2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {    View rootView = inflater.inflate(R.layout.desserts_fragment, container, false);

        db = new DatabaseHelper(getActivity());
        dessertsRecipes = db.getallrecipes(category);

        //dessertsRecipes.get(0).getTitle()
        String hello = "hello";
        Toast.makeText(getContext(), hello, Toast.LENGTH_LONG).show();

        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
        requestPermissions(permissions, PERMISSION_CODE);

        gridView = (GridView)rootView.findViewById(R.id.gridDesserts);
        adapter = new CustomGridView(getContext(), dessertsRecipes);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),GridItemActivity.class);
                intent.putExtra("title", dessertsRecipes.get(position).title);
                intent.putExtra("desc", dessertsRecipes.get(position).description);
                intent.putExtra("ingredient1", dessertsRecipes.get(position).ingredient1);
                intent.putExtra("ingredient2", dessertsRecipes.get(position).ingredient2);
                intent.putExtra("ingredient3", dessertsRecipes.get(position).ingredient3);
                intent.putExtra("ingredient4", dessertsRecipes.get(position).ingredient4);
                intent.putExtra("ingredient5", dessertsRecipes.get(position).ingredient5);
                intent.putExtra("ingredient6", dessertsRecipes.get(position).ingredient6);
                intent.putExtra("ingredient7", dessertsRecipes.get(position).ingredient7);
                intent.putExtra("ingredient8", dessertsRecipes.get(position).ingredient8);
                intent.putExtra("ingredient9", dessertsRecipes.get(position).ingredient9);
                intent.putExtra("ingredient10", dessertsRecipes.get(position).ingredient10);
                intent.putExtra("ingredient11", dessertsRecipes.get(position).ingredient11);
                intent.putExtra("ingredient12", dessertsRecipes.get(position).ingredient12);
                intent.putExtra("ingredient13", dessertsRecipes.get(position).ingredient13);
                intent.putExtra("ingredient14", dessertsRecipes.get(position).ingredient14);
                intent.putExtra("ingredient15", dessertsRecipes.get(position).ingredient15);
                intent.putExtra("ingredient16", dessertsRecipes.get(position).ingredient16);
                intent.putExtra("ingredient17", dessertsRecipes.get(position).ingredient17);
                intent.putExtra("ingredient18", dessertsRecipes.get(position).ingredient18);
                intent.putExtra("ingredient19", dessertsRecipes.get(position).ingredient19);
                intent.putExtra("ingredient20", dessertsRecipes.get(position).ingredient20);
                intent.putExtra("step1", dessertsRecipes.get(position).step1);
                intent.putExtra("step2", dessertsRecipes.get(position).step2);
                intent.putExtra("step3", dessertsRecipes.get(position).step3);
                intent.putExtra("step4", dessertsRecipes.get(position).step4);
                intent.putExtra("step5", dessertsRecipes.get(position).step5);
                intent.putExtra("step6", dessertsRecipes.get(position).step6);
                intent.putExtra("step7", dessertsRecipes.get(position).step7);
                intent.putExtra("step8", dessertsRecipes.get(position).step8);
                intent.putExtra("step9", dessertsRecipes.get(position).step9);
                intent.putExtra("step10", dessertsRecipes.get(position).step10);
 startActivity(intent);




            }
        });

        return  rootView;
    }
}