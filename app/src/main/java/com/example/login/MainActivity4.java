package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    private TextView txtHasil;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        txtHasil = findViewById(R.id.show_result1);



    }

    public void pindah(View view) {
        TextView username =(TextView) findViewById(R.id.username);

        if(username.getText().toString().equals("merah")){
            txtHasil.setText("Benar");

            Toast.makeText(MainActivity4.this,"Jawaban Benar",Toast.LENGTH_SHORT).show();

        }else{
            txtHasil.setText("Salah");
            Toast.makeText(MainActivity4.this,"Jawaban Salah",Toast.LENGTH_SHORT).show();}

    };

    public void pindah1(View view) {
        if(txtHasil.toString().equals("merah")) {
            Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
            startActivity(intent);
        }/*else {
            Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
            intent.putExtra("string",stringArrayList1);
            startActivity(intent);

        }*/
    }
}
