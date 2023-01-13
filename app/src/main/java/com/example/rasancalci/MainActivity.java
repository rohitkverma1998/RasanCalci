package com.example.rasancalci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerTextSize;

    private TextView View_Rice_Total;
    private TextView View_Wheat_Total;
    private TextView View_Money_To_Take;
    private TextView View_Money_To_Give_For_Both;
    private TextView View_Money_To_Give_For_Rice_Only;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerTextSize = findViewById(R.id.spinnerTextSize);

        spinnerTextSize.setOnItemSelectedListener(this);

        String[] textSizes = getResources().getStringArray(R.array.font_sizes);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,textSizes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTextSize.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinnerTextSize) {
            String valueFromSpinner = parent.getItemAtPosition(position).toString();
            int j=Integer.parseInt(valueFromSpinner);

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

        int Rice_PP = 4;
        int Wheat_PP = 1;
        int Deduct_Rice_PP = 1;
        int Deduct_Wheat_PP = 0;

        int Free_Rice_PP = 0;
        int Free_Wheat_PP = 0;
        int Deduct_Free_Rice_PP = 0;
        int Deduct_Free_Wheat_PP = 0;

        int Rice_Price_Pkg = 15;
        int Wheat_Price_Pkg = 20;

        int Take_Rice_Price_PKg = 0;
        int Take_Wheat_Price_PKg = 0;
        int Take_Price_Pkg = 0;


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

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}