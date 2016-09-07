package com.jonbenson.beeradviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FindBeerActivity extends AppCompatActivity {
    protected BeerExpert expert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        expert = new BeerExpert();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }


    // Called when button find_beer is clicked
    public void onClickFindBeer(View view) {
        // Get reference to the TextView we need
        TextView brands = (TextView) findViewById(R.id.brands);

        // Get reference to spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        // Get selected line item in Spinner
        String beerType = String.valueOf(color.getSelectedItem());

        // Get recommendation from BeerExpert class
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }

        // Display beers
        brands.setText(brandsFormatted);
    }
}

class BeerExpert {
    List<String> getBrands (String color) {
        List<String> brands = new ArrayList<>();
        if (color.equals("amber")) {
            brands.add("Jack Amber");
            brands.add("Jack Moose");
        }
        else if (color.equals("light")) {
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        else if (color.equals("brown")) {
            brands.add("Potato Liquid");
            brands.add("Dougie's Drankie");
        }
        else {
            brands.add("Seasick Secretions");
        }
        return brands;
    }
}