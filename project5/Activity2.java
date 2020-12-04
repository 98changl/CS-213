package com.example.project5;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        int[] price = extras.getIntArray("price");
        //student, adult, senior , mes. type
        //MOMA = 1 , NYHS = 2 , RM = 3, WMOAA = 4


        //adult
        TextView adulttext = findViewById(R.id.adulttext);
        Spinner adultSpinner = findViewById(R.id.AdultSpinner);
        adulttext.append("Adult $" + price[1]);

        //senior
        TextView seniortext = findViewById(R.id.seniortext);
        Spinner seniorSpinner = findViewById(R.id.senorSpinner);
        seniortext.append("Senior $" + price[2]);

        //student
        Spinner studentSpinner = findViewById(R.id.studentSpinner);
        TextView studenttext = findViewById(R.id.studenttext);
        studenttext.append("Student $" + price[0]);




    }

    public void cal(){

    }

    public void goToWeb(View view){

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.moma.org/ps1")));
    }

    public void calculation(View view) {

    }

}
