package com.example.jidlo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GridItemActivity extends AppCompatActivity {



    TextView title, description, ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6;
    TextView ingredient7, ingredient8, ingredient9, ingredient10, ingredient11, ingredient12, ingredient13, ingredient14, ingredient15, ingredient16,ingredient17, ingredient18, ingredient19, ingredient20;
    TextView step1, step2, step3, step4, step5, step6, step7, step8, step9, step10;

    ImageView Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);

        Back = (ImageView) findViewById(R.id.back_button);
        Back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(GridItemActivity.this, MainActivity.class));

            }
        });

        title = findViewById(R.id.titleTextView);
        description = findViewById(R.id.descriptionTV);
        ingredient1 = findViewById(R.id.ing1);
        ingredient2 = findViewById(R.id.ing2);
        ingredient3 = findViewById(R.id.ing3);
        ingredient4 = findViewById(R.id.ing4);
        ingredient5 = findViewById(R.id.ing5);
        ingredient6 = findViewById(R.id.ing6);
        ingredient7 = findViewById(R.id.ing7);
        ingredient8 = findViewById(R.id.ing8);
        ingredient9 = findViewById(R.id.ing9);
        ingredient10 = findViewById(R.id.ing10);
        ingredient11 = findViewById(R.id.ing11);
        ingredient12 = findViewById(R.id.ing12);
        ingredient13 = findViewById(R.id.ing13);
        ingredient14 = findViewById(R.id.ing14);
        ingredient15 = findViewById(R.id.ing15);
        ingredient16 = findViewById(R.id.ing16);
        ingredient17 = findViewById(R.id.ing17);
       /* ingredient18 = findViewById(R.id.ing18);
        ingredient19 = findViewById(R.id.ing19);
        ingredient20 = findViewById(R.id.ing20);*/

        step1 = findViewById(R.id.stp1);
        step2 = findViewById(R.id.stp2);
        step3 = findViewById(R.id.stp3);
        step4 = findViewById(R.id.stp4);
        step5 = findViewById(R.id.stp5);
        step6 = findViewById(R.id.stp6);
        step7 = findViewById(R.id.stp7);
        step8 = findViewById(R.id.stp8);
        step9 = findViewById(R.id.stp9);
        step10 = findViewById(R.id.stp10);


        Intent intent = getIntent();

        title.setText(intent.getStringExtra("title"));
        description.setText(intent.getStringExtra("desc"));
        ingredient1.setText(intent.getStringExtra("ingredient1"));
        ingredient2.setText(intent.getStringExtra("ingredient2"));
        ingredient3.setText(intent.getStringExtra("ingredient3"));
        ingredient4.setText(intent.getStringExtra("ingredient4"));
        ingredient5.setText(intent.getStringExtra("ingredient5"));
        ingredient6.setText(intent.getStringExtra("ingredient6"));
        ingredient7.setText(intent.getStringExtra("ingredient7"));
        ingredient8.setText(intent.getStringExtra("ingredient8"));
        ingredient9.setText(intent.getStringExtra("ingredient9"));
        ingredient10.setText(intent.getStringExtra("ingredient10"));
        ingredient11.setText(intent.getStringExtra("ingredient11"));
        ingredient12.setText(intent.getStringExtra("ingredient12"));
        ingredient13.setText(intent.getStringExtra("ingredient13"));
        ingredient14.setText(intent.getStringExtra("ingredient14"));
        ingredient15.setText(intent.getStringExtra("ingredient15"));
        ingredient16.setText(intent.getStringExtra("ingredient16"));
        ingredient17.setText(intent.getStringExtra("ingredient17"));
        step1.setText(intent.getStringExtra("step1"));
        step2.setText(intent.getStringExtra("step2"));
        step3.setText(intent.getStringExtra("step3"));
        step4.setText(intent.getStringExtra("step4"));
        step5.setText(intent.getStringExtra("step5"));
        step6.setText(intent.getStringExtra("step6"));
        step7.setText(intent.getStringExtra("step7"));
        step8.setText(intent.getStringExtra("step8"));
        step9.setText(intent.getStringExtra("step9"));
        step10.setText(intent.getStringExtra("step10"));



    }
}
