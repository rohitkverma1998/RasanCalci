package com.example.rasancalci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerTextSize;
    private Spinner spinner;

    private Button button;
    ////////////////////////////////////////////////////////////////////////

    private float Saved_Rice_PP;
    private float Saved_Wheat_PP;
    private float Saved_Deduct_Rice_PP;
    private float Saved_Deduct_Wheat_PP;
    private float Saved_Free_Rice_PP;
    private float Saved_Free_Wheat_PP;
    private float Saved_Deduct_Free_Rice_PP;
    private float Saved_Deduct_Free_Wheat_PP;
    private float Saved_Take_Rice_Price_Pkg;
    private float Saved_Take_Wheat_Price_Pkg;
    private float Saved_Rice_Price_Pkg;
    private float Saved_Wheat_Price_Pkg;

    ///////////////////////////////////////////////////////////////////////

    private TextView View_Rice_Total;
    private TextView View_Wheat_Total;
    private TextView View_Money_To_Take;
    private TextView View_Money_To_Give_For_Both;
    private TextView View_Money_To_Give_For_Rice_Only;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        spinnerTextSize = findViewById(R.id.spinnerTextSize);
//
//        spinnerTextSize.setOnItemSelectedListener(this);
//
//        String[] textSizes = getResources().getStringArray(R.array.font_sizes);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,textSizes);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerTextSize.setAdapter(adapter);







        spinner = (Spinner) findViewById(R.id.spinnerTextSize);

        String[] textSizes = getResources().getStringArray(R.array.font_sizes);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,textSizes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Retrieve spinner position from sharedpreferences
        SharedPreferences sharedPref = getSharedPreferences("Saved", MODE_PRIVATE);
        int spinnerValue = sharedPref.getInt("userChoiceSpinner",-1);
        if(spinnerValue != -1)
            // set the value of the spinner
            spinner.setSelection(spinnerValue);

        spinner.setOnItemSelectedListener(this);







        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSetting();
            }
        });


        SharedPreferences sh = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        ///////////////////////////////////////////////////////////////////////////////////////////

        Saved_Rice_PP = sh.getFloat("Saved_Rice_PP",0);
        Saved_Wheat_PP = sh.getFloat("Saved_Wheat_PP",0);
        Saved_Deduct_Rice_PP = sh.getFloat("Saved_Deduct_Rice_PP",0);
        Saved_Deduct_Wheat_PP = sh.getFloat("Saved_Deduct_Wheat_PP",0);
        Saved_Free_Rice_PP = sh.getFloat("Saved_Free_Rice_PP",0);
        Saved_Free_Wheat_PP = sh.getFloat("Saved_Free_Wheat_PP",0);
        Saved_Deduct_Free_Rice_PP = sh.getFloat("Saved_Deduct_Free_Rice_PP",0);
        Saved_Deduct_Free_Wheat_PP = sh.getFloat("Saved_Deduct_Free_Wheat_PP",0);
        Saved_Take_Rice_Price_Pkg = sh.getFloat("Saved_Take_Rice_Price_Pkg",0);
        Saved_Take_Wheat_Price_Pkg = sh.getFloat("Saved_Take_Wheat_Price_Pkg",0);
        Saved_Rice_Price_Pkg = sh.getFloat("Saved_Rice_Price_Pkg",0);
        Saved_Wheat_Price_Pkg = sh.getFloat("Saved_Wheat_Price_Pkg",0);

        ///////////////////////////////////////////////////////////////////////////////////////////


    }



    public void openSetting(){
        Intent  intent = new Intent(this, Setting.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinnerTextSize) {
            String valueFromSpinner = parent.getItemAtPosition(position).toString();
            int j=Integer.parseInt(valueFromSpinner);

            // save inputed spinner position to sharedpreferences
            int userChoice = parent.getSelectedItemPosition();
            SharedPreferences sharedPref = getSharedPreferences("Saved", 0);
            SharedPreferences.Editor prefEditor = sharedPref.edit();
            prefEditor.putInt("userChoiceSpinner", userChoice);
            prefEditor.commit();

            CalculationAndUpdate2(j);
        }
    }

    private void CalculationAndUpdate(int j) {
        TextView NumberOfPerson = findViewById(R.id.View_Rice_Total);
        NumberOfPerson.setText("Number of Person : "+j);

        View_Rice_Total = findViewById(R.id.View_Rice_Total);
        View_Wheat_Total = findViewById(R.id.View_Wheat_Total);
        View_Money_To_Take = findViewById(R.id.View_Money_To_Take);
        View_Money_To_Give_For_Both = findViewById(R.id.View_Money_To_Give_For_Both);
        View_Money_To_Give_For_Rice_Only = findViewById(R.id.View_To_Give_For_Rice_Only);

        int Number_of_Person;

        int Rice_PP = 4;
        int Wheat_PP = 1;
        int Deduct_Rice_PP = 1;
        int Deduct_Wheat_PP = 0;

        int Free_Rice_PP = 5;
        int Free_Wheat_PP = 0;
        int Deduct_Free_Rice_PP = 1;
        int Deduct_Free_Wheat_PP = 0;

        int Rice_Price_Pkg = 15;
        int Wheat_Price_Pkg = 20;

        int Take_Rice_Price_PKg = 3;
        int Take_Wheat_Price_PKg = 3;
        int Take_Price_Pkg = 3;


        int Rice_Total;
        int Wheat_Total;
        int Money_To_Take_For_Rice;
        int Money_To_Take_For_Wheat;
        int Money_To_Take;
        int Money_To_Give_For_Both;
        int Money_To_Give_For_Rice_Only;

        int Free_Rice_Total;
        int Free_Wheat_Total;
        int Paid_Rice_Total;
        int Paid_Wheat_Total;

        Number_of_Person = j;

        Free_Rice_Total = (Free_Rice_PP - Deduct_Free_Rice_PP) * Number_of_Person;
        Free_Wheat_Total = (Free_Wheat_PP - Deduct_Free_Wheat_PP) * Number_of_Person;

        Paid_Rice_Total = (Rice_PP - Deduct_Rice_PP) * Number_of_Person;
        Paid_Wheat_Total = (Wheat_PP - Deduct_Wheat_PP) * Number_of_Person;

        Rice_Total = Paid_Rice_Total + Free_Rice_Total ;
        Wheat_Total = Paid_Wheat_Total + Free_Wheat_Total;

        Money_To_Take_For_Rice = (Rice_PP * Number_of_Person) * Take_Rice_Price_PKg;
        Money_To_Take_For_Wheat = (Wheat_PP * Number_of_Person) * Take_Wheat_Price_PKg;

        Money_To_Take = Money_To_Take_For_Rice + Money_To_Take_For_Wheat;

        Money_To_Give_For_Both = (Paid_Rice_Total * Rice_Price_Pkg) + (Wheat_Total * Wheat_Price_Pkg) + (Free_Rice_Total * Rice_Price_Pkg) - Money_To_Take;
        Money_To_Give_For_Rice_Only = (Paid_Rice_Total * Rice_Price_Pkg) + (Free_Rice_Total * Rice_Price_Pkg) - Money_To_Take;

        View_Rice_Total.setText("Rice = " + Rice_Total + " Kg");
        View_Wheat_Total.setText("Wheat = " + Wheat_Total + " Kg");
        View_Money_To_Take.setText("Take =  ₹ " + Money_To_Take);
        View_Money_To_Give_For_Both.setText("Both : Give =  ₹ " + Money_To_Give_For_Both);
        View_Money_To_Give_For_Rice_Only.setText("Rice Only : Give =  ₹ " + Money_To_Give_For_Rice_Only);



    }

    private void CalculationAndUpdate2(int j) {
        TextView NumberOfPerson = findViewById(R.id.View_Rice_Total);
        NumberOfPerson.setText("Number of Person : "+j);

        View_Rice_Total = findViewById(R.id.View_Rice_Total);
        View_Wheat_Total = findViewById(R.id.View_Wheat_Total);
        View_Money_To_Take = findViewById(R.id.View_Money_To_Take);
        View_Money_To_Give_For_Both = findViewById(R.id.View_Money_To_Give_For_Both);
        View_Money_To_Give_For_Rice_Only = findViewById(R.id.View_To_Give_For_Rice_Only);

        int Number_of_Person;

        float Rice_PP = Saved_Rice_PP; // 4
        float Wheat_PP = Saved_Wheat_PP; // 1
        float Deduct_Rice_PP = Saved_Deduct_Rice_PP;//1;
        float Deduct_Wheat_PP = Saved_Deduct_Wheat_PP;//0;

        float Free_Rice_PP = Saved_Free_Rice_PP;//0;
        float Free_Wheat_PP = Saved_Free_Wheat_PP;//0;
        float Deduct_Free_Rice_PP = Saved_Deduct_Free_Rice_PP;//0;
        float Deduct_Free_Wheat_PP = Saved_Deduct_Free_Wheat_PP;//0;

        float Rice_Price_Pkg = Saved_Rice_Price_Pkg;//15;
        float Wheat_Price_Pkg = Saved_Wheat_Price_Pkg;//20;

        float Take_Rice_Price_PKg = Saved_Take_Rice_Price_Pkg;//0;
        float Take_Wheat_Price_PKg = Saved_Take_Wheat_Price_Pkg;//0;
        float Take_Price_Pkg = 0;


        float Rice_Total;
        float Wheat_Total;
        float Money_To_Take_For_Rice;
        float Money_To_Take_For_Wheat;
        float Money_To_Take;
        float Money_To_Give_For_Both;
        float Money_To_Give_For_Rice_Only;

        float Free_Rice_Total;
        float Free_Wheat_Total;
        float  Paid_Rice_Total;
        float Paid_Wheat_Total;

        Number_of_Person = j;

        Free_Rice_Total = (Free_Rice_PP - Deduct_Free_Rice_PP) * Number_of_Person;
        Free_Wheat_Total = (Free_Wheat_PP - Deduct_Free_Wheat_PP) * Number_of_Person;

        Paid_Rice_Total = (Rice_PP - Deduct_Rice_PP) * Number_of_Person;
        Paid_Wheat_Total = (Wheat_PP - Deduct_Wheat_PP) * Number_of_Person;

        Rice_Total = Paid_Rice_Total + Free_Rice_Total ;
        Wheat_Total = Paid_Wheat_Total + Free_Wheat_Total;

        Money_To_Take_For_Rice = (Rice_PP * Number_of_Person) * Take_Rice_Price_PKg;
        Money_To_Take_For_Wheat = (Wheat_PP * Number_of_Person) * Take_Wheat_Price_PKg;

        Money_To_Take = Money_To_Take_For_Rice + Money_To_Take_For_Wheat;

        Money_To_Give_For_Both = (Paid_Rice_Total * Rice_Price_Pkg) + (Wheat_Total * Wheat_Price_Pkg) + (Free_Rice_Total * Rice_Price_Pkg) - Money_To_Take;
        Money_To_Give_For_Rice_Only = (Paid_Rice_Total * Rice_Price_Pkg) + (Free_Rice_Total * Rice_Price_Pkg) - Money_To_Take;

        View_Rice_Total.setText("Rice = " + Rice_Total + " Kg");
        View_Wheat_Total.setText("Wheat = " + Wheat_Total + " Kg");
        View_Money_To_Take.setText("Take =  ₹ " + Money_To_Take);
        View_Money_To_Give_For_Both.setText("Both : Give =  ₹ " + Money_To_Give_For_Both);
        View_Money_To_Give_For_Rice_Only.setText("Rice Only : Give =  ₹ " + Money_To_Give_For_Rice_Only);



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}