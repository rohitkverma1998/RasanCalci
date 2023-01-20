package com.example.rasancalci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Setting extends AppCompatActivity {

    private Button Save_Button;
    ///////////////////////////////////////////////////////////////////////////

    private TextInputLayout Edit_Rice_PP;
    private TextView View_Rice_PP;

    private TextInputLayout Edit_Wheat_PP;
    private TextView View_Wheat_PP;

    private TextInputLayout Edit_Deduct_Rice_PP;
    private TextView View_Deduct_Rice_PP;

    private TextInputLayout Edit_Deduct_Wheat_PP;
    private TextView View_Deduct_Wheat_PP;

    private TextInputLayout Edit_Free_Rice_PP;
    private TextView View_Free_Rice_PP;

    private TextInputLayout Edit_Free_Wheat_PP;
    private TextView View_Free_Wheat_PP;

    private TextInputLayout Edit_Deduct_Free_Rice_PP;
    private TextView View_Deduct_Free_Rice_PP;

    private TextInputLayout Edit_Deduct_Free_Wheat_PP;
    private TextView View_Deduct_Free_Wheat_PP;

    private TextInputLayout Edit_Take_Rice_Price_Pkg;
    private TextView View_Take_Rice_Price_Pkg;

    private TextInputLayout Edit_Take_Wheat_Price_Pkg;
    private TextView View_Take_Wheat_Price_Pkg;

    private TextInputLayout Edit_Rice_Price_Pkg;
    private TextView View_Rice_Price_Pkg;

    private TextInputLayout Edit_Wheat_Price_Pkg;
    private TextView View_Wheat_Price_Pkg;

    //////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Save_Button = (Button) findViewById(R.id.Save_Button);
        ///////////////////////////////////////////////////////////////

        Edit_Rice_PP = findViewById(R.id.edit_Rice_PP);
        View_Rice_PP = findViewById(R.id.view_Rice_PP);

        Edit_Wheat_PP = findViewById(R.id.edit_Wheat_PP);
        View_Wheat_PP = findViewById(R.id.view_Wheat_PP);

        Edit_Deduct_Rice_PP = findViewById(R.id.edit_Deduct_Rice_PP);
        View_Deduct_Rice_PP = findViewById(R.id.view_Deduct_Rice_PP);

        Edit_Deduct_Wheat_PP = findViewById(R.id.edit_Deduct_Wheat_PP);
        View_Deduct_Wheat_PP = findViewById(R.id.view_Deduct_Wheat_PP);

        Edit_Free_Rice_PP = findViewById(R.id.edit_Free_Rice_PP);
        View_Free_Rice_PP = findViewById(R.id.view_Free_Rice_PP);

        Edit_Free_Wheat_PP = findViewById(R.id.edit_Free_Wheat_PP);
        View_Free_Wheat_PP = findViewById(R.id.view_Free_Wheat_PP);

        Edit_Deduct_Free_Rice_PP = findViewById(R.id.edit_Deduct_Free_Rice_PP);
        View_Deduct_Free_Rice_PP = findViewById(R.id.view_Deduct_Free_Rice_PP);

        Edit_Deduct_Free_Wheat_PP = findViewById(R.id.edit_Deduct_Free_Wheat_PP);
        View_Deduct_Free_Wheat_PP = findViewById(R.id.view_Deduct_Free_Wheat_PP);

        Edit_Take_Rice_Price_Pkg = findViewById(R.id.edit_Take_Rice_Price_Pkg);
        View_Take_Rice_Price_Pkg = findViewById(R.id.view_Take_Rice_Price_Pkg);

        Edit_Take_Wheat_Price_Pkg = findViewById(R.id.edit_Take_Wheat_Price_Pkg);
        View_Take_Wheat_Price_Pkg = findViewById(R.id.view_Take_Wheat_Price_Pkg);

        Edit_Rice_Price_Pkg = findViewById(R.id.edit_Rice_Price_Pkg);
        View_Rice_Price_Pkg = findViewById(R.id.view_Rice_Price_Pkg);

        Edit_Wheat_Price_Pkg = findViewById(R.id.edit_Wheat_Price_Pkg);
        View_Wheat_Price_Pkg = findViewById(R.id.view_Wheat_Price_Pkg);



        /////////////////////////////////////////////////////////////


        readDataFromSharedPreferences();

        Save_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////

                if(!(Edit_Rice_PP.getEditText().getText().toString().isEmpty())) {

                    View_Rice_PP.setText(Edit_Rice_PP.getEditText().getText().toString());
                    float Rice_PP = Float.parseFloat(View_Rice_PP.getText().toString());
                    myEdit.putFloat("Saved_Rice_PP",Rice_PP);

                }

                if(!(Edit_Wheat_PP.getEditText().getText().toString().isEmpty())) {

                    View_Wheat_PP.setText(Edit_Wheat_PP.getEditText().getText().toString());
                    float Wheat_PP = Float.parseFloat(View_Wheat_PP.getText().toString());
                    myEdit.putFloat("Saved_Wheat_PP",Wheat_PP);

                }

                if(!(Edit_Deduct_Rice_PP.getEditText().getText().toString().isEmpty())) {

                    View_Deduct_Rice_PP.setText(Edit_Deduct_Rice_PP.getEditText().getText().toString());
                    float Deduct_Rice_PP = Float.parseFloat(View_Deduct_Rice_PP.getText().toString());
                    myEdit.putFloat("Saved_Deduct_Rice_PP",Deduct_Rice_PP);

                }

                if(!(Edit_Deduct_Wheat_PP.getEditText().getText().toString().isEmpty())) {

                    View_Deduct_Wheat_PP.setText(Edit_Deduct_Wheat_PP.getEditText().getText().toString());
                    float Deduct_Wheat_PP = Float.parseFloat(View_Deduct_Wheat_PP.getText().toString());
                    myEdit.putFloat("Saved_Deduct_Wheat_PP",Deduct_Wheat_PP);

                }

                if(!(Edit_Free_Rice_PP.getEditText().getText().toString().isEmpty())) {

                    View_Free_Rice_PP.setText(Edit_Free_Rice_PP.getEditText().getText().toString());
                    float Free_Rice_PP = Float.parseFloat(View_Free_Rice_PP.getText().toString());
                    myEdit.putFloat("Saved_Free_Rice_PP",Free_Rice_PP);

                }

                if(!(Edit_Free_Wheat_PP.getEditText().getText().toString().isEmpty())) {

                    View_Free_Wheat_PP.setText(Edit_Free_Wheat_PP.getEditText().getText().toString());
                    float Free_Wheat_PP = Float.parseFloat(View_Free_Wheat_PP.getText().toString());
                    myEdit.putFloat("Saved_Free_Wheat_PP",Free_Wheat_PP);

                }

                if(!(Edit_Deduct_Free_Rice_PP.getEditText().getText().toString().isEmpty())) {

                    View_Deduct_Free_Rice_PP.setText(Edit_Deduct_Free_Rice_PP.getEditText().getText().toString());
                    float Deduct_Free_Rice_PP = Float.parseFloat(View_Deduct_Free_Rice_PP.getText().toString());
                    myEdit.putFloat("Saved_Deduct_Free_Rice_PP",Deduct_Free_Rice_PP);

                }

                if(!(Edit_Deduct_Free_Wheat_PP.getEditText().getText().toString().isEmpty())) {

                    View_Deduct_Free_Wheat_PP.setText(Edit_Deduct_Free_Wheat_PP.getEditText().getText().toString());
                    float Deduct_Free_Wheat_PP = Float.parseFloat(View_Deduct_Free_Wheat_PP.getText().toString());
                    myEdit.putFloat("Saved_Deduct_Free_Wheat_PP",Deduct_Free_Wheat_PP);

                }

                if(!(Edit_Take_Rice_Price_Pkg.getEditText().getText().toString().isEmpty())) {

                    View_Take_Rice_Price_Pkg.setText(Edit_Take_Rice_Price_Pkg.getEditText().getText().toString());
                    float Take_Rice_Price_Pkg = Float.parseFloat(View_Take_Rice_Price_Pkg.getText().toString());
                    myEdit.putFloat("Saved_Take_Rice_Price_Pkg",Take_Rice_Price_Pkg);

                }

                if(!(Edit_Take_Wheat_Price_Pkg.getEditText().getText().toString().isEmpty())) {

                    View_Take_Wheat_Price_Pkg.setText(Edit_Take_Wheat_Price_Pkg.getEditText().getText().toString());
                    float Take_Wheat_Price_Pkg = Float.parseFloat(View_Take_Wheat_Price_Pkg.getText().toString());
                    myEdit.putFloat("Saved_Take_Wheat_Price_Pkg",Take_Wheat_Price_Pkg);

                }

                if(!(Edit_Rice_Price_Pkg.getEditText().getText().toString().isEmpty())) {

                    View_Rice_Price_Pkg.setText(Edit_Rice_Price_Pkg.getEditText().getText().toString());
                    float Rice_Price_Pkg = Float.parseFloat(View_Rice_Price_Pkg.getText().toString());
                    myEdit.putFloat("Saved_Rice_Price_Pkg",Rice_Price_Pkg);

                }

                if(!(Edit_Wheat_Price_Pkg.getEditText().getText().toString().isEmpty())) {

                    View_Wheat_Price_Pkg.setText(Edit_Wheat_Price_Pkg.getEditText().getText().toString());
                    float Wheat_Price_Pkg = Float.parseFloat(View_Wheat_Price_Pkg.getText().toString());
                    myEdit.putFloat("Saved_Wheat_Price_Pkg",Wheat_Price_Pkg);

                }



                /////////////////////////////////////////////////////////////////////////////////////////////////////////
                myEdit.commit();


                openMainActivity();
            }
        });



    }

    public void readDataFromSharedPreferences(){
        SharedPreferences sh = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        ////////////////////////////////////////////////////////////////////////////////////////

        float Saved_Rice_PP = sh.getFloat("Saved_Rice_PP",0);
        View_Rice_PP.setText(""+Saved_Rice_PP);

        float Saved_Wheat_PP = sh.getFloat("Saved_Wheat_PP",0);
        View_Wheat_PP.setText(""+Saved_Wheat_PP);

        float Saved_Deduct_Rice_PP = sh.getFloat("Saved_Deduct_Rice_PP",0);
        View_Deduct_Rice_PP.setText(""+Saved_Deduct_Rice_PP);

        float Saved_Deduct_Wheat_PP = sh.getFloat("Saved_Deduct_Wheat_PP",0);
        View_Deduct_Wheat_PP.setText(""+Saved_Deduct_Wheat_PP);

        float Saved_Free_Rice_PP = sh.getFloat("Saved_Free_Rice_PP",0);
        View_Free_Rice_PP.setText(""+Saved_Free_Rice_PP);

        float Saved_Free_Wheat_PP = sh.getFloat("Saved_Free_Wheat_PP",0);
        View_Free_Wheat_PP.setText(""+Saved_Free_Wheat_PP);

        float Saved_Deduct_Free_Rice_PP = sh.getFloat("Saved_Deduct_Free_Rice_PP",0);
        View_Deduct_Free_Rice_PP.setText(""+Saved_Deduct_Free_Rice_PP);

        float Saved_Deduct_Free_Wheat_PP = sh.getFloat("Saved_Deduct_Free_Wheat_PP",0);
        View_Deduct_Free_Wheat_PP.setText(""+Saved_Deduct_Free_Wheat_PP);

        float Saved_Take_Rice_Price_Pkg = sh.getFloat("Saved_Take_Rice_Price_Pkg",0);
        View_Take_Rice_Price_Pkg.setText(""+Saved_Take_Rice_Price_Pkg);

        float Saved_Take_Wheat_Price_Pkg = sh.getFloat("Saved_Take_Wheat_Price_Pkg",0);
        View_Take_Wheat_Price_Pkg.setText(""+Saved_Take_Wheat_Price_Pkg);

        float Saved_Rice_Price_Pkg = sh.getFloat("Saved_Rice_Price_Pkg",0);
        View_Rice_Price_Pkg.setText(""+Saved_Rice_Price_Pkg);

        float Saved_Wheat_Price_Pkg = sh.getFloat("Saved_Wheat_Price_Pkg",0);
        View_Wheat_Price_Pkg.setText(""+Saved_Wheat_Price_Pkg);

        ///////////////////////////////////////////////////////////////////////////////////////

    }


    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}