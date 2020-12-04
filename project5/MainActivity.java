package com.example.project5;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 *Class contains method to starts the Main Activity along with
 * methods to start activity for 4 different Museum upon
 * button click.
 *
 * @author Liman Chang, Kenneth Christian
 */

public class MainActivity extends AppCompatActivity {


   // public Button MoMA_PS1 ,New_York_Historical_Society ,Rubin_Museum, Whitney_Museum_of_American_Art ;



    /**
     * Method to perform application start up.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button MoMA = findViewById(R.id.MoMA_PS1);
        final Button NYHS = findViewById(R.id.New_York_Historical_Society);
        final Button RM = findViewById(R.id.Rubin_Museum);
        final Button WMOAA = findViewById(R.id.Whitney_Museum_of_American_Art);


        //MOMA = 1 , NYHS = 2 , RM = 3, WMOAA = 4
        MoMA.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                //student, adult, senior
                int price[] = {14 , 25 , 18 , 1};
                Intent intent = new Intent(MainActivity.this , Activity2.class);
                intent.putExtra("price" ,price);
                startActivity(intent);

            }
        });

        NYHS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //student, adult, senior
                int price[] = {13 , 22 , 17 , 2};
                Intent intent = new Intent(MainActivity.this , Activity2.class);
                intent.putExtra("price" , price);
                startActivity(intent);

            }
        });

        RM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //student, adult, senior
                int price[] = {14 , 19 , 14 , 3};
                Intent intent = new Intent(MainActivity.this , Activity2.class);
                intent.putExtra("price" , price);
                startActivity(intent);

            }
        });

        WMOAA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //student, adult, senior
                int price[] = {18 , 25 , 18 , 4};
                Intent intent = new Intent(MainActivity.this , Activity2.class);
                intent.putExtra("price" , price);
                startActivity(intent);

            }
        });



    }
    

}
