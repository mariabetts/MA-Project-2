package com.example.maproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        this.inputresults = findViewById(R.id.FinalResults);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countarray_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerwcount.setAdapter(adapter);
    }
    public void onBtnclick(View view){
        if (getcount.getText().toString()==null || getcount.getText().toString().trim().equals("")){
            Toast.makeText(getBaseContext(),"Input Field is Empty", Toast.LENGTH_LONG).show();
        }
        else{
            String phrase = this.getcount.getText().toString();
            int spinnerwcount = TextCounter.getcharcount(phrase);
            String getcount = String.valueOf(spinnerwcount);

            this.getcount.setText((CharSequence) inputresults);

            this.getcount.setText(TextCounter.getcount(phrase));
        }




    }
    public abstract class TextValidator implements TextWatcher {
        private final TextView textView;

        public TextValidator(TextView textView) {
            this.textView = textView;
        }

        public abstract void validate(TextView textView, String text);

        @Override
        final public void afterTextChanged(Editable s) {
            String text = textView.getText().toString();
            validate(textView, text);
        }

        @Override
        final public void beforeTextChanged(CharSequence s, int start, int count, int after) { /* Don't care */ }

        @Override
        final public void onTextChanged(CharSequence s, int start, int before, int count) { /* Don't care */ }




    }

}
