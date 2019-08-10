package com.example.mybeautifulproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {
    private Button okButton;
    private EditText money;
    private EditText purpose;
    private RadioGroup radioGroup;
    public static Box<Transaction> transactionBox;
    private Button report;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        okButton = findViewById(R.id.ok);
        money = findViewById(R.id.Money);
        purpose = findViewById(R.id.purpose);
        radioGroup = findViewById(R.id.kind);
        transactionBox = ObjectBox.get().boxFor(Transaction.class);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioGroup.getCheckedRadioButtonId() == R.id.cost){
                    addTransaction(true);
                } else {
                    addTransaction(false);
                }
            }
        });
        report = findViewById(R.id.report);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Report.class));
                Log.d("tag", "activity 2");
            }
        });

    }
    public void addTransaction(boolean costOrNot){
        Transaction transaction;
        if (costOrNot){
            transaction = new Transaction("" + "-" + money.getText().toString(), purpose.getText().toString(), true );
        } else {
            transaction = new Transaction("" + "+" + money.getText().toString(), purpose.getText().toString(), false );
        }
        //Toast.makeText(MainActivity.this, "bad as else", Toast.LENGTH_LONG).show();
        transactionBox.put(transaction);
        money.setText("");
        purpose.setText("");

    }
}
