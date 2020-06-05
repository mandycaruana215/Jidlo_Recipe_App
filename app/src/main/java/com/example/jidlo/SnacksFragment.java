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

public class SnacksFragment extends Fragment {

    private GridView gridView;
    private CustomGridView adapter;
    String category = "Snacks";
    List<Recipe> snacksRecipes;
    DatabaseHelper db;

    private static final int PICK_IMAGE = 1;
    private static final int PERMISSION_CODE = 2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.snacks_fragment, container, false);

        db = new DatabaseHelper(getActivity());
        snacksRecipes = db.getallrecipes(category);

        //snacksRecipes.get(0).getTitle()
        String hello = "hello";
        Toast.makeText(getContext(), hello, Toast.LENGTH_LONG).show();

        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
        requestPermissions(permissions, PERMISSION_CODE);

        gridView = (GridView) rootView.findViewById(R.id.gridSnacks);
        adapter = new CustomGridView(getContext(), snacksRecipes);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),GridItemActivity.class);
                intent.putExtra("title", snacksRecipes.get(position).title);
                intent.putExtra("desc", snacksRecipes.get(position).description);
                intent.putExtra("ingredient1", snacksRecipes.get(position).ingredient1);
                intent.putExtra("ingredient2", snacksRecipes.get(position).ingredient2);
                intent.putExtra("ingredient3", snacksRecipes.get(position).ingredient3);
                intent.putExtra("ingredient4", snacksRecipes.get(position).ingredient4);
                intent.putExtra("ingredient5", snacksRecipes.get(position).ingredient5);
                intent.putExtra("ingredient6", snacksRecipes.get(position).ingredient6);
                intent.putExtra("ingredient7", snacksRecipes.get(position).ingredient7);
                intent.putExtra("ingredient8", snacksRecipes.get(position).ingredient8);
                intent.putExtra("ingredient9", snacksRecipes.get(position).ingredient9);
                intent.putExtra("ingredient10", snacksRecipes.get(position).ingredient10);
                intent.putExtra("ingredient11", snacksRecipes.get(position).ingredient11);
                intent.putExtra("ingredient12", snacksRecipes.get(position).ingredient12);
                intent.putExtra("ingredient13", snacksRecipes.get(position).ingredient13);
                intent.putExtra("ingredient14", snacksRecipes.get(position).ingredient14);
                intent.putExtra("ingredient15", snacksRecipes.get(position).ingredient15);
                intent.putExtra("ingredient16", snacksRecipes.get(position).ingredient16);
                intent.putExtra("ingredient17", snacksRecipes.get(position).ingredient17);
                intent.putExtra("ingredient18", snacksRecipes.get(position).ingredient18);
                intent.putExtra("ingredient19", snacksRecipes.get(position).ingredient19);
                intent.putExtra("ingredient20", snacksRecipes.get(position).ingredient20);
                intent.putExtra("step1", snacksRecipes.get(position).step1);
                intent.putExtra("step2", snacksRecipes.get(position).step2);
                intent.putExtra("step3", snacksRecipes.get(position).step3);
                intent.putExtra("step4", snacksRecipes.get(position).step4);
                intent.putExtra("step5", snacksRecipes.get(position).step5);
                intent.putExtra("step6", snacksRecipes.get(position).step6);
                intent.putExtra("step7", snacksRecipes.get(position).step7);
                intent.putExtra("step8", snacksRecipes.get(position).step8);
                intent.putExtra("step9", snacksRecipes.get(position).step9);
                intent.putExtra("step10", snacksRecipes.get(position).step10);

                 startActivity(intent);




            }
        });
        return rootView;
    }
}