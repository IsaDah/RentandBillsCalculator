package com.example.rentandbillscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;


import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MainActivity extends AppCompatActivity
{
    private EditText houseRentEditText;
    private EditText electricityBillEditText;
    private EditText heatingBillEditText;
    private EditText waterBillEditText;
    private EditText internetBillEditText;
    private EditText numberOfResidentsEditText;

    private EditText rentAmongResidentsEditText;
    private EditText totalBillsEditText;
    private EditText billsAmongResidentsEditText;

    private Button calculateTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        houseRentEditText = (EditText)findViewById(R.id.edit_text_house_rent);
        electricityBillEditText = (EditText)findViewById(R.id.edit_text_electricity_bill);
        heatingBillEditText = (EditText)findViewById(R.id.edit_text_heating_bill);
        waterBillEditText = (EditText)findViewById(R.id.edit_text_water_bill);
        internetBillEditText = (EditText)findViewById(R.id.edit_text_internet_bill);
        numberOfResidentsEditText = (EditText)findViewById(R.id.edit_text_residents);

        rentAmongResidentsEditText = (EditText)findViewById(R.id.edit_text_rent_among_residents);
        totalBillsEditText = (EditText)findViewById(R.id.edit_text_bills_total);
        billsAmongResidentsEditText = (EditText)findViewById(R.id.edit_text_bills_devided);

        calculateTotal = (Button)findViewById(R.id.button_calculate_total);

        houseRentEditText.setText("0");
        electricityBillEditText.setText("0");
        heatingBillEditText.setText("0");
        waterBillEditText.setText("0");
        internetBillEditText.setText("0");
        numberOfResidentsEditText.setText("0");

        rentAmongResidentsEditText.setText("0");
        totalBillsEditText.setText("0");
        billsAmongResidentsEditText.setText("0");

        calculateTotal.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    double houseRent = Double.parseDouble(houseRentEditText.getText().toString());
                    double electricityBill = Double.parseDouble(electricityBillEditText.getText().toString());
                    double heatingBill = Double.parseDouble(heatingBillEditText.getText().toString());
                    double waterBill = Double.parseDouble(waterBillEditText.getText().toString());
                    double internetBill = Double.parseDouble(internetBillEditText.getText().toString());
                    double numberOfResidents = Double.parseDouble(numberOfResidentsEditText.getText().toString());

                    double rentAmongResidents = houseRent / numberOfResidents;
                    double billsTotal = electricityBill + heatingBill + waterBill + internetBill;
                    double billsAmongResidents = billsTotal / numberOfResidents;

                    rentAmongResidentsEditText.setText(String.valueOf(rentAmongResidents));
                    totalBillsEditText.setText(String.valueOf(billsTotal));
                    billsAmongResidentsEditText.setText(String.valueOf(billsAmongResidents));
                }
                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this,"Invalid Input", Toast.LENGTH_SHORT).show();
                }

        }
    });

    }
}
