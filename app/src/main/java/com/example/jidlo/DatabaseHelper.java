package com.example.jidlo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "FinalDatabase.db";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table users_table(email text primary key, name text, password text)");
        db.execSQL("Create table recipes_table(id INTEGER PRIMARY KEY AUTOINCREMENT, title text, description text, category1 text, category2 text, rating INTEGER, number_of_ingredients INTEGER, preptime INTEGER, cooktime INTEGER, totaltime INTEGER, difficulty text, servings INTEGER, calories INTEGER," +
                "ingredient1 text, ingredient2 text, ingredient3 text, ingredient4 text, ingredient5 text, ingredient6 text, ingredient7 text, ingredient8 text, ingredient9 text, ingredient10 text, ingredient11 text, ingredient12 text, " +
                "ingredient13 text, ingredient14 text, ingredient15 text, ingredient16 text, ingredient17 text, ingredient18 text, ingredient19 text, ingredient20 text," +
                 "step1 text, step2 text, step3 text, step4 text, step5 text, step6 text, step7 text, step8 text, step9 text, step10 text, image text, vegeterian boolean, glutenfree boolean, spicy boolean, containsNuts boolean)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users_table");
        db.execSQL("drop table if exists recipe_table");

    }
   public boolean insertRecipe(String title,String description, String category1, String category2, int no_of_ingredients, int preptime, int cooktime, int totaltime, String difficulty, int servings,int calories,
                               String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5, String ingredient6, String ingredient7, String ingredient8, String ingredient9, String ingredient10,
                               String ingredient11, String ingredient12, String ingredient13, String ingredient14, String ingredient15, String ingredient16, String ingredient17, String ingredient18, String ingredient19, String ingredient20,
                               String step1, String step2, String step3, String step4, String step5, String step6, String step7, String step8, String step9, String step10, String image, Boolean vegeterian, Boolean glutenFree, Boolean spicy, Boolean containsNuts)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",title);
        contentValues.put("description",description);
        contentValues.put("category1",category1);
        contentValues.put("category2",category2);
        contentValues.put("number_of_ingredients",no_of_ingredients);
        contentValues.put("preptime",preptime);
        contentValues.put("cooktime",cooktime);
        contentValues.put("totaltime",totaltime);
        contentValues.put("difficulty",difficulty);
        contentValues.put("servings",servings);
        contentValues.put("calories",calories);
        contentValues.put("ingredient1",ingredient1);
        contentValues.put("ingredient2",ingredient2);
        contentValues.put("ingredient3",ingredient3);
        contentValues.put("ingredient4",ingredient4);
        contentValues.put("ingredient5",ingredient5);
        contentValues.put("ingredient6",ingredient6);
        contentValues.put("ingredient7",ingredient7);
        contentValues.put("ingredient8",ingredient8);
        contentValues.put("ingredient9",ingredient9);
        contentValues.put("ingredient10",ingredient10);
        contentValues.put("ingredient11",ingredient11);
        contentValues.put("ingredient12",ingredient12);
        contentValues.put("ingredient13",ingredient13);
        contentValues.put("ingredient14",ingredient14);
        contentValues.put("ingredient15",ingredient15);
        contentValues.put("ingredient16",ingredient16);
        contentValues.put("ingredient17",ingredient17);
        contentValues.put("ingredient18",ingredient18);
        contentValues.put("ingredient19",ingredient19);
        contentValues.put("ingredient20",ingredient20);
        contentValues.put("step1",step1);
        contentValues.put("step2",step2);
        contentValues.put("step3",step3);
        contentValues.put("step4",step4);
        contentValues.put("step5",step5);
        contentValues.put("step6",step6);
        contentValues.put("step7",step7);
        contentValues.put("step8",step8);
        contentValues.put("step9",step9);
        contentValues.put("step10",step10);
        contentValues.put("image",image);
        contentValues.put("vegeterian",vegeterian);
        contentValues.put("glutenfree",glutenFree);
        contentValues.put("spicy",spicy);
        contentValues.put("containsNuts",containsNuts);

        long insert = db.insert("recipes_table", null,contentValues);
        if(insert == 1) return true;
        else return false;

    }

    public boolean insert(String email, String name, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("name",name);
        contentValues.put("password",password);
        long insert = db.insert("users_table", null,contentValues);
        if(insert == 1) return false;
        else return true;

    }

    //checks wheter email already exists in db
    public Boolean checkEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from users_table where email=?", new String []{email});
    if(cursor.getCount()>0) return false;
    else return true;

    }

    //checks email and password

    public Boolean emailpasswordChecker(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users_table where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0) return false;
        else return true;
    }

    public List<Recipe> getallrecipes(String cat){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from recipes_table where category1 = ?", new String[]{cat});
        cursor.moveToFirst();
        Recipe recipe;
        ArrayList<Recipe> result = new ArrayList<Recipe>();
        //ArrayList<Recipe> myArrayList = new ArrayList<Recipe>();
        try{
            while(!cursor.isAfterLast()) {
                recipe = new Recipe();
                recipe.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                recipe.setDescription(cursor.getString(cursor.getColumnIndex("description")));
                recipe.setCategory1(cursor.getString(cursor.getColumnIndex("category1")));
                recipe.setCategory2(cursor.getString(cursor.getColumnIndex("category2")));
                recipe.setDifficulty(cursor.getString(cursor.getColumnIndex("difficulty")));
                recipe.setIngredient1(cursor.getString(cursor.getColumnIndex("ingredient1")));
                recipe.setIngredient2(cursor.getString(cursor.getColumnIndex("ingredient2")));
                recipe.setIngredient3(cursor.getString(cursor.getColumnIndex("ingredient3")));
                recipe.setIngredient4(cursor.getString(cursor.getColumnIndex("ingredient4")));
                recipe.setIngredient5(cursor.getString(cursor.getColumnIndex("ingredient5")));
                recipe.setIngredient6(cursor.getString(cursor.getColumnIndex("ingredient6")));
                recipe.setIngredient7(cursor.getString(cursor.getColumnIndex("ingredient7")));
                recipe.setIngredient8(cursor.getString(cursor.getColumnIndex("ingredient8")));
                recipe.setIngredient9(cursor.getString(cursor.getColumnIndex("ingredient9")));
                recipe.setIngredient10(cursor.getString(cursor.getColumnIndex("ingredient10")));
                recipe.setIngredient11(cursor.getString(cursor.getColumnIndex("ingredient11")));
                recipe.setIngredient12(cursor.getString(cursor.getColumnIndex("ingredient12")));
                recipe.setIngredient13(cursor.getString(cursor.getColumnIndex("ingredient13")));
                recipe.setIngredient14(cursor.getString(cursor.getColumnIndex("ingredient14")));
                recipe.setIngredient15(cursor.getString(cursor.getColumnIndex("ingredient15")));
                recipe.setIngredient16(cursor.getString(cursor.getColumnIndex("ingredient16")));
                recipe.setIngredient17(cursor.getString(cursor.getColumnIndex("ingredient17")));
                recipe.setIngredient18(cursor.getString(cursor.getColumnIndex("ingredient18")));
                recipe.setIngredient19(cursor.getString(cursor.getColumnIndex("ingredient19")));
                recipe.setIngredient20(cursor.getString(cursor.getColumnIndex("ingredient20")));
                recipe.setStep1(cursor.getString(cursor.getColumnIndex("step1")));
                recipe.setStep2(cursor.getString(cursor.getColumnIndex("step2")));
                recipe.setStep3(cursor.getString(cursor.getColumnIndex("step3")));
                recipe.setStep4(cursor.getString(cursor.getColumnIndex("step4")));
                recipe.setStep5(cursor.getString(cursor.getColumnIndex("step5")));
                recipe.setStep6(cursor.getString(cursor.getColumnIndex("step6")));
                recipe.setStep7(cursor.getString(cursor.getColumnIndex("step7")));
                recipe.setStep8(cursor.getString(cursor.getColumnIndex("step8")));
                recipe.setStep9(cursor.getString(cursor.getColumnIndex("step9")));
                recipe.setStep10(cursor.getString(cursor.getColumnIndex("step10")));
                recipe.setImage(cursor.getString(cursor.getColumnIndex("image")));
                recipe.setRating(cursor.getInt(cursor.getColumnIndex("rating")));
                recipe.setNo_of_ingredients(cursor.getInt(cursor.getColumnIndex("number_of_ingredients")));
                recipe.setPreptime(cursor.getInt(cursor.getColumnIndex("preptime")));
                recipe.setCooktime(cursor.getInt(cursor.getColumnIndex("cooktime")));
                recipe.setTotaltime(cursor.getInt(cursor.getColumnIndex("totaltime")));
                recipe.setServings(cursor.getInt(cursor.getColumnIndex("servings")));
                recipe.setCalories(cursor.getInt(cursor.getColumnIndex("calories")));
                recipe.setVegeterian(cursor.getInt(cursor.getColumnIndex("vegeterian"))>0);
                recipe.setSpicy(cursor.getInt(cursor.getColumnIndex("spicy"))>0);
                recipe.setGlutenFree(cursor.getInt(cursor.getColumnIndex("glutenfree"))>0);
                recipe.setContainsNuts(cursor.getInt(cursor.getColumnIndex("containsNuts"))>0);

                Log.v("DatabaseHelperTesting",  cursor.getString(cursor.getColumnIndex("title")));

                result.add(recipe);
                //myArrayList.add(recipe);
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        Log.v("DatabaseHelperTesting",  cursor.getCount() + ", " + result.size());
        return result;
    }







    /*public String getName(String email){
        String name;
        //SQLiteDatabase db = this.getReadableDatabase();
        *//*Cursor cursor = db.rawQuery("select name from users_table where email=?",new String[]{email} );
        if(cursor.getCount()>0) return cursor;*//*

       *//* Cursor cursor=db.query("user_table", new String[]{ KEY_ID,KEY_NAME },KEY_ID +"=?",new String[] { String.valueOf(id) },null,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }
        Name name = new Name(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
        return name;*//*
        String selectQuery = "select name from users_table where email=?";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


    }*/
}
