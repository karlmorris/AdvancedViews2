package edu.temple.myadapterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    TextView titleTextView;
    Button addFlavorButton;

    ArrayList arrayListOfFlavors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        titleTextView = findViewById(R.id.textView);
        addFlavorButton = findViewById(R.id.button);

        //String[] iceCream = new String[] {"Chocolate", "Vanilla", "Chocolate Chip", "Cookies and Cream"};
        arrayListOfFlavors = new ArrayList();

        arrayListOfFlavors.add("Chocolate");
        arrayListOfFlavors.add("Chocolate Chip");
        arrayListOfFlavors.add("Vanilla");
        arrayListOfFlavors.add("Cookies and Cream");
        arrayListOfFlavors.add("Grape");


        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayListOfFlavors);

        listView.setAdapter(adapter);
        spinner.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                changeText(parent, view, position);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeText(parent, view, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addFlavorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListOfFlavors.add("Strawberry");
                ((BaseAdapter) spinner.getAdapter()).notifyDataSetChanged();
            }
        });

    }

    private void changeText(AdapterView<?> parent, View view, int position) {
        titleTextView.setText(parent.getItemAtPosition(position).toString());
    }

}