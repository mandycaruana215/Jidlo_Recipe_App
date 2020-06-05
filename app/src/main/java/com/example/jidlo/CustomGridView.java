package com.example.jidlo;

import android.Manifest;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomGridView extends BaseAdapter {

    private Context myContext;
    public List<Recipe> myRecipes;

    public CustomGridView(Context context, List<Recipe> recipes)
    {
        this.myContext = context;
        this.myRecipes = recipes;
    }

    @Override
    public int getCount() {
        return myRecipes.size();
    }

    @Override
    public Object getItem(int position) {
        return myRecipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;

        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             gridView = inflater.inflate(R.layout.viewmodel, null);
        }

        int id = myRecipes.get(position).id;

        ImageView recipeimageView = (ImageView)gridView.findViewById(R.id.recipeimageIV);
        recipeimageView.setImageURI(Uri.parse(myRecipes.get(position).image));


        TextView recipetitle = (TextView)gridView.findViewById(R.id.titleTV);
        recipetitle.setText(myRecipes.get(position).title);

        TextView recipedesc = (TextView)gridView.findViewById(R.id.descriptionTV);
        recipedesc.setText(myRecipes.get(position).description);

        TextView recipecalories = (TextView)gridView.findViewById(R.id.caloriesTV);
        recipecalories.setText(myRecipes.get(position).calories + "");

        TextView recipeprepTime = (TextView)gridView.findViewById(R.id.prepTimeTV);
        recipeprepTime.setText(myRecipes.get(position).preptime + " mins");

        TextView recipecookTime = (TextView)gridView.findViewById(R.id.cookTimeTV);
        recipecookTime.setText(myRecipes.get(position).cooktime + " mins");

        TextView recipediff = (TextView)gridView.findViewById(R.id.difficultyTV);
        recipediff.setText(myRecipes.get(position).difficulty + "");

        TextView serv = (TextView)gridView.findViewById(R.id.servings) ;
        serv.setText(myRecipes.get(position).servings +"");

        TextView recipenoIngredients = (TextView)gridView.findViewById(R.id.numberOfIngredientsTV);
        recipenoIngredients.setText(myRecipes.get(position).no_of_ingredients + "");
        String allergiestext = null;

        if(myRecipes.get(position).vegeterian.equals(true)){
            if(allergiestext == null)
                allergiestext = "Vegetarian";
            else
                allergiestext += ", Vegetarian";
        }
        if(myRecipes.get(position).glutenFree.equals(true)){
            if(allergiestext == null)
                allergiestext = "Gluten Free";
            else
                allergiestext += ", Gluten Free";
        }

        if(myRecipes.get(position).containsNuts.equals(true)){
            if(allergiestext == null)
                allergiestext = "Contains Nuts";
            else
                allergiestext += ", Contains Nuts";
        }

        if(myRecipes.get(position).spicy.equals(true)){
            if(allergiestext == null)
                allergiestext = "Spicy";
            else
                allergiestext += ", Spicy";
        }


        TextView allergies = (TextView)gridView.findViewById(R.id.allergies);
        allergies.setText(allergiestext);

        Log.v("CGA",  myRecipes.get(position).title + " " + myRecipes.get(position).description); //used for testing purposes

        return gridView;

    }

}
