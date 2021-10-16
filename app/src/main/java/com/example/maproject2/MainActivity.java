package com.example.maproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maproject2.countutils.TextCounter;
import com.example.maproject2.countutils.string;

import org.w3c.dom.Text;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerwcount;
    EditText getcount;
    TextView inputresults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spinnerwcount = (Spinner) findViewById(R.id.spinnerwcount);
        this.getcount =  findViewById(R.id.getcount);
        this.inputresults = findViewById(R.id.wordcount);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.countarray_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerwcount.setAdapter(adapter);
    }


    
    public void onclick(View view){
        Spinner MainSpinner = (Spinner) findViewById(R.id.spinnerwcount);
        String Text = MainSpinner.getSelectedItem().toString();

        String phrase = this.getcount.getText().toString();
        boolean emptyphrase= phrase.isEmpty();

        
        if (!emptyphrase) {
            if (Text.equals("Words")) {
                int WordCount = TextCounter.getwordcount(phrase);
                String formattedResult = String.valueOf(WordCount);
                this.inputresults.setText(formattedResult);
            } else if (Text.equals("Characters")) {
                int CharacterCount = TextCounter.getcharcount(phrase);
                String formattedResult = String.valueOf(CharacterCount);
                this.inputresults.setText(formattedResult);
            }
        } else {
            Toast.makeText(this,"Please input a phrase",Toast.LENGTH_LONG).show();
        }







    }




    }


