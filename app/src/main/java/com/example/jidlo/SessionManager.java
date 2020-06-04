package com.example.jidlo;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;

import com.google.android.material.navigation.NavigationView;

import java.security.PublicKey;
import java.util.HashMap;

public class SessionManager {
   /* NavigationView navigationView;
    Menu menu;*/

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
     Context _context;
    int PRIVATE_MODE = 0;

   private static final String SHARED_PREF_NAME = "AndroidExamplePref";

    private static final String IS_USER_LOGIN = "IsUserLoggedIn";

    public static final String KEY_NAME = "name";

    public static final String KEY_EMAIL = "email";




    public SessionManager(Context context){
        this._context = context;
        sharedPreferences= _context.getSharedPreferences(SHARED_PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createUserLoginSession(String name, String email){
        editor.putBoolean(IS_USER_LOGIN,true);

        editor.putString(KEY_NAME, name);

        editor.putString(KEY_EMAIL, email);

        editor.commit();
    }

    public boolean isUserLoggedIn(){
        return sharedPreferences.getBoolean(IS_USER_LOGIN, false);
    }

    public boolean checkLogin(){
        if(!this.isUserLoggedIn()){

            Intent i  = new Intent(_context, LoginActivity.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            _context.startActivity(i);

            return true;
        }

        return false;
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<>();

        user.put(KEY_NAME, sharedPreferences.getString(KEY_NAME, null));
        user.put(KEY_EMAIL, sharedPreferences.getString(KEY_EMAIL, null));


        return user;
    }

    public void  logoutUser(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(_context,LoginActivity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        _context.startActivity(i);

    }


  /*  public void saveSession(User user){
        //save session of user wheneve he is logged in

    }

    public int getSession(){
        //return user whose session is saved

        return -1;
    }*/
/*

    public void createSession(String name, String email){
        editor.putBoolean(LOGIN, true);
        editor.putString(NAME,name);
        editor.putString(EMAIL, email);
        editor.apply();
    }
*/



  /*  public boolean isLoggin(){

        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLogin(){
        if(!this.isLoggin()){
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
            ((ProfileActivity)context).finish();
*/
           /* menu =navigationView.getMenu();
            menu.findItem(R.id.nav_profile).setVisible(true);
            menu.findItem(R.id.nav_logout).setVisible(true);
            menu.findItem(R.id.nav_login).setVisible(false);*/



    }

  /*  public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<>();
        user.put(NAME, sharedPreferences.getString(NAME, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));

        return user;
    }

    public void logout(){

        editor.clear();
        editor.commit();

        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
        ((ProfileActivity)context).finish();*/

        /*menu =navigationView.getMenu();

        menu.findItem(R.id.nav_profile).setVisible(false);
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_login).setVisible(true);
*/



