package com.example.jidlo;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SendARecipeActivity extends AppCompatActivity {

    private ImageView Back, PostImage;
    EditText title, description, no_of_ingredients, preptime, cooktime, totaltime,  servings, calories, ingredient1, ingredient2, ingredient3, ingredient4, ingredient5;
    EditText ingredient6, ingredient7, ingredient8, ingredient9, ingredient10, ingredient11, ingredient12, ingredient13, ingredient14, ingredient15, ingredient16, ingredient17, ingredient18, ingredient19, ingredient20;
    EditText step1, step2, step3, step4, step5, step6, step7, step8, step9, step10;
    CheckBox vegeterian, gluten_free, spicy, contains_nuts;
    Spinner spnCategory1, spnCategory2, spnDifficulty;
    public String cat1, cat2, diff;
    private Button SubmitBtn;
    private static final int PICK_IMAGE = 1;
    private static final int PERMISSION_CODE = 2;
    String ImageUri;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_a_recipe);

        db = new DatabaseHelper(this);
        title = (EditText) findViewById(R.id.title);
        description = (EditText) findViewById(R.id.description);
        spnCategory1 = (Spinner) findViewById(R.id.cat1_spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCategory1.setAdapter(adapter);
        //spnCategory1.setOnItemSelectedListener(this);
        spnCategory1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cat1 = spnCategory1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spnCategory2 = (Spinner) findViewById(R.id.cat2_spinner1);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.category2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCategory2.setAdapter(adapter2);
        //spnCategory2.setOnItemSelectedListener(this);

        spnCategory2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cat2 = spnCategory2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spnDifficulty = (Spinner) findViewById(R.id.difficulty_spinner1);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.difficulty, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDifficulty.setAdapter(adapter3);
        //spnDifficulty.setOnItemSelectedListener(this);
        spnDifficulty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                diff = spnDifficulty.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        no_of_ingredients = (EditText) findViewById(R.id.number_ingredients);
        preptime = (EditText) findViewById(R.id.prep_time);
        cooktime = (EditText) findViewById(R.id.cook_time);
        totaltime = (EditText) findViewById(R.id.total_time);
        servings = (EditText) findViewById(R.id.servings);
        calories = (EditText) findViewById(R.id.calories);
        ingredient1 = (EditText) findViewById(R.id.ingredient1);
        ingredient2 = (EditText) findViewById(R.id.ingredient2);
        ingredient3 = (EditText) findViewById(R.id.ingredient3);
        ingredient4 = (EditText) findViewById(R.id.ingredient4);
        ingredient5 = (EditText) findViewById(R.id.ingredient5);
        ingredient6 = (EditText) findViewById(R.id.ingredient6);
        ingredient7 = (EditText) findViewById(R.id.ingredient7);
        ingredient8 = (EditText) findViewById(R.id.ingredient8);
        ingredient9 = (EditText) findViewById(R.id.ingredient9);
        ingredient10 = (EditText) findViewById(R.id.ingredient10);
        ingredient11 = (EditText) findViewById(R.id.ingredient11);
        ingredient12 = (EditText) findViewById(R.id.ingredient12);
        ingredient13 = (EditText) findViewById(R.id.ingredient13);
        ingredient14 = (EditText) findViewById(R.id.ingredient14);
        ingredient15 = (EditText) findViewById(R.id.ingredient15);
        ingredient16 = (EditText) findViewById(R.id.ingredient16);
        ingredient17 = (EditText) findViewById(R.id.ingredient17);
        ingredient18 = (EditText) findViewById(R.id.ingredient18);
        ingredient19 = (EditText) findViewById(R.id.ingredient19);
        ingredient20 = (EditText) findViewById(R.id.ingredient20);

        step1 = (EditText) findViewById(R.id.step1);
        step2 = (EditText) findViewById(R.id.step2);
        step3 = (EditText) findViewById(R.id.step3);
        step4 = (EditText) findViewById(R.id.step4);
        step5 = (EditText) findViewById(R.id.step5);
        step6 = (EditText) findViewById(R.id.step6);
        step7 = (EditText) findViewById(R.id.step7);
        step8 = (EditText) findViewById(R.id.step8);
        step9 = (EditText) findViewById(R.id.step9);
        step10 = (EditText) findViewById(R.id.step10);

        vegeterian = (CheckBox) findViewById(R.id.vegeterian);
        gluten_free = (CheckBox) findViewById(R.id.gluten_free);
        spicy = (CheckBox) findViewById(R.id.spicy);
        contains_nuts = (CheckBox) findViewById(R.id.containsNuts);


        Back = (ImageView) findViewById(R.id.back_button);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SendARecipeActivity.this, MainActivity.class));
            }
        });

        PostImage = (ImageView) findViewById(R.id.post_Image);
        PostImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PERMISSION_CODE);
                    } else {
                        selectImage();
                    }
                } else {
                    selectImage();
                }
            }
        });

        SubmitBtn = (Button) findViewById(R.id.submitbtn);
        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String recipeTitle = title.getText().toString();
                String recipeDescription = description.getText().toString();
                String Category1 = cat1;
                String Category2 = cat2;
                String difficulty = diff;
                int numIngredients = Integer.parseInt(no_of_ingredients.getText().toString());
                int prepTime = Integer.parseInt(preptime.getText().toString());
                int cookTime = Integer.parseInt(cooktime.getText().toString());
                int totalTime = Integer.parseInt(totaltime.getText().toString());
                int caloriesPerServing = Integer.parseInt(calories.getText().toString());
                int Servings = Integer.parseInt(servings.getText().toString());
                String ing1 = ingredient1.getText().toString();
                String ing2 = ingredient2.getText().toString();
                String ing3 = ingredient3.getText().toString();
                String ing4 = ingredient4.getText().toString();
                String ing5 = ingredient5.getText().toString();
                String ing6 = ingredient6.getText().toString();
                String ing7 = ingredient7.getText().toString();
                String ing8 = ingredient8.getText().toString();
                String ing9 = ingredient9.getText().toString();
                String ing10 = ingredient10.getText().toString();
                String ing11 = ingredient11.getText().toString();
                String ing12 = ingredient12.getText().toString();
                String ing13 = ingredient13.getText().toString();
                String ing14 = ingredient14.getText().toString();
                String ing15 = ingredient15.getText().toString();
                String ing16 = ingredient16.getText().toString();
                String ing17 = ingredient17.getText().toString();
                String ing18 = ingredient18.getText().toString();
                String ing19 = ingredient19.getText().toString();
                String ing20 = ingredient20.getText().toString();

                String stp1 = step1.getText().toString();
                String stp2 = step2.getText().toString();
                String stp3 = step3.getText().toString();
                String stp4 = step4.getText().toString();
                String stp5 = step5.getText().toString();
                String stp6 = step6.getText().toString();
                String stp7 = step7.getText().toString();
                String stp8 = step8.getText().toString();
                String stp9 = step9.getText().toString();
                String stp10 = step10.getText().toString();

                String image = ImageUri;

                Boolean Vegeterian;
                if (vegeterian.isChecked()) {
                    Vegeterian = true;
                } else {
                    Vegeterian = false;
                }

                Boolean GlutenFree;
                if (gluten_free.isChecked()) {
                    GlutenFree = true;
                } else {
                    GlutenFree = false;
                }

                Boolean Spicy;
                if (spicy.isChecked()) {
                    Spicy = true;
                } else {
                    Spicy = false;
                }

                Boolean ContainNuts;
                if (contains_nuts.isChecked()) {
                    ContainNuts = true;
                } else {
                    ContainNuts = false;
                }


                Boolean insert = new Boolean( db.insertRecipe(recipeTitle, recipeDescription, Category1, Category2, numIngredients, prepTime, cookTime, totalTime, difficulty, Servings, caloriesPerServing, ing1,
                        ing2, ing3, ing4, ing5, ing6, ing7, ing8, ing9, ing10, ing11, ing12, ing13, ing14, ing15, ing16, ing17, ing18, ing19, ing20, stp1, stp2, stp3, stp4, stp5, stp6, stp7, stp8,
                        stp9, stp10, image, Vegeterian, GlutenFree, Spicy, ContainNuts) );

               if (insert == false) {

                   Toast.makeText(getApplicationContext(), "Recipe Added Successfully", Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(SendARecipeActivity.this, MainActivity.class));
               }
               else {
                   Toast.makeText(getApplicationContext(), "Recipe was not Added", Toast.LENGTH_SHORT).show();
               }


            }

        });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            Uri imageTest = data.getData();
            ImageUri = imageTest.toString();
            PostImage.setImageURI(imageTest);
            //final int takeFlags = data.getFlags() & (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            //getApplicationContext().getContentResolver().takePersistableUriPermission(ImageUri, takeFlags);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    selectImage();
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void selectImage() {
        Intent gallery = new Intent(Intent.ACTION_PICK);
        gallery.setType("image/*");
        gallery.setAction(Intent.ACTION_OPEN_DOCUMENT);
        startActivityForResult(Intent.createChooser(gallery, "Select Picture"), PICK_IMAGE);
        //startActivityForResult(gallery, PICK_IMAGE);
    }


}