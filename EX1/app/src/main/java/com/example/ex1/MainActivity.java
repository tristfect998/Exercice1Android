package com.example.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputNumber1;
    private EditText inputNumber2;
    private Button buttonValidate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber1 = findViewById(R.id.Number1);
        inputNumber2 = findViewById(R.id.Number2);
        buttonValidate = findViewById(R.id.ComapreButton);
        SetListener();
    }

    private void SetListener(){
        buttonValidate.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                message();
            }
        });
    }

    private void message(){
        try{
            int number1 = Integer.parseInt(inputNumber1.getText().toString());
            int number2 = Integer.parseInt(inputNumber2.getText().toString());
            if(number1 > number2){
                showHint("Le nombre de gauche est le plus grand");
                inputNumber1.setBackgroundColor(Color.BLUE);
                inputNumber2.setBackgroundColor(Color.TRANSPARENT);
            }else if(number1 < number2){
                showHint("Le nombre de droite est le plus grand");
                inputNumber2.setBackgroundColor(Color.BLUE);
                inputNumber1.setBackgroundColor(Color.TRANSPARENT);
            }else {
                showHint("Les 2 nombre sont égal");
                inputNumber1.setBackgroundColor(Color.TRANSPARENT);
                inputNumber2.setBackgroundColor(Color.TRANSPARENT);
            }
        }catch (Exception ex){
            showHint("Valeur non valide");
        }
    }

    private  void showHint(String hint){
        Toast.makeText(this, hint, Toast.LENGTH_SHORT).show();
    }
}
