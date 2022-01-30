package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    private EditText edtAngka1;
    //private EditText proses1;
    private EditText edtAngka2;
   // private EditText proses2;
    private EditText edtJawab;
    private TextView txtHasil;
    private TextView txtHasil1;
    private Button btnCek;
    private Button btnLogin;
    Spinner spinner;
    private Button btnBantuan;
    ArrayList jawaban= new ArrayList();
    ArrayList jawaban1= new ArrayList();
    ArrayList jawaban2= new ArrayList();
    String[]pilihan={"+","x","-"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        edtAngka1 = findViewById(R.id.Edtangka1);
        edtAngka2 = findViewById(R.id.Edtangka2);
        edtJawab = findViewById(R.id.Edtjawab);
        txtHasil = findViewById(R.id.show_result);
        txtHasil1 = findViewById(R.id.show_result1);
        btnCek = findViewById(R.id.button_result);
        btnBantuan = findViewById(R.id.button_bantuan);
        btnCek.setOnClickListener(this);
        //spinner = findViewById(R.id.spiner);
        InputAngka();
        btnLogin =findViewById(R.id.lanjut);
        btnLogin.setOnClickListener(this);
        btnBantuan.setOnClickListener(this);
        //proses1 =findViewById(R.id.Edtangka1);
        //proses2 =findViewById(R.id.Edtangka2);

        //ArrayAdapter<String> adapter1=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,pilihan);
        //spinner.getAdapter(adapter1);

    }


    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }
    public void InputAngka(){
        Random myRandom = new Random();
        int num = myRandom.nextInt(10);
        int num1 = myRandom.nextInt(10);
        edtAngka1.setText(String.valueOf(num));
        edtAngka2.setText(String.valueOf(num1));}

    @Override

    public void onClick(View view) {


        if (view.getId() == R.id.button_result){
            String InputAngka1 =edtAngka1.getText().toString().trim();
            String InputAngka2 =edtAngka2.getText().toString().trim();
            String InputAngka5 =edtJawab.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(InputAngka1)){
                isEmptyFields=true;
                edtAngka1.setError("Field Ini Tidak Boleh Kosong");
            }
            if (TextUtils.isEmpty(InputAngka2)) {
                isEmptyFields = true;
                edtAngka2.setError("Field Ini Tidak Boleh Kosong");
            }
            Double Operand1 = toDouble(InputAngka1);
            Double Operand2 = toDouble(InputAngka2);


            if (Operand1 == null){
                isInvalidDouble = true;
                edtAngka1.setError("Field Ini Harus Berupa Angka");
            }
            if (Operand2 == null) {
                isInvalidDouble = true;
                edtAngka2.setError("Field Ini Harus Berupa Angka");
            }
            if (TextUtils.isEmpty(InputAngka5)) {
                isEmptyFields = true;
                edtJawab.setError("Field Ini Tidak Boleh Kosong");
            }


                if (!isEmptyFields && !isInvalidDouble) {
                double hasil = Operand1+Operand2;
                txtHasil.setText(String.valueOf(hasil));
                String InputAngka3 =edtJawab.getText().toString().trim();
                String InputAngka4 =txtHasil.getText().toString().trim();
                Double Operand3 = toDouble(InputAngka3);
                Double Operand4 = toDouble(InputAngka4);
                if (Operand3>Operand4){
                    txtHasil1.setText("salah");
                }else if (Operand3<Operand4){
                    txtHasil1.setText("salah");
                }else{
                    txtHasil1.setText("benar");
                }
                jawaban.add(txtHasil.getText().toString());
                jawaban1.add(txtHasil1.getText().toString());
                jawaban2.add(edtJawab.getText().toString());
                    System.out.println("angka benar"+jawaban);
                    System.out.println("          benar/salah"+jawaban1);
                    System.out.println("          input angka"+jawaban2);

            }



        }
        if (view.getId() == R.id.button_bantuan){
            edtJawab.setText(null);

        //    System.out.println("angka benar"+jawaban);
        //    System.out.println("          benar/salah"+jawaban1);
        //    System.out.println("          input angka"+jawaban2);
            InputAngka();


        }


        if (view.getId() == R.id.lanjut){
            String InputAngka1 =edtAngka1.getText().toString().trim();
            String InputAngka2 =edtAngka2.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(InputAngka1)){
                isEmptyFields=true;
                edtAngka1.setError("Field Ini Tidak Boleh Kosong");
            }
            if (TextUtils.isEmpty(InputAngka2)) {
                isEmptyFields = true;
                edtAngka2.setError("Field Ini Tidak Boleh Kosong");
            }
            Double Operand1 = toDouble(InputAngka1);
            Double Operand2 = toDouble(InputAngka2);

            if (Operand1 == null){
                isInvalidDouble = true;
                edtAngka1.setError("Field Ini Harus Berupa Angka");
            }
            if (Operand2 == null) {
                isInvalidDouble = true;
                edtAngka2.setError("Field Ini Harus berupa ANgka");
            }
            if (!isEmptyFields && !isInvalidDouble) {
                Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
                intent.putStringArrayListExtra("extra_jawaban",jawaban1);
                intent.putStringArrayListExtra("extra_jawaban1",jawaban);
                startActivity(intent);

            }

        }

    }



    //public void pindah1(View view) {

       // Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
        //startActivity(intent);
    //}
}
            /*String InputAngka1 =edtAngka1.getText().toString().trim();
            String InputAngka2 =edtAngka2.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(InputAngka1)){
                isEmptyFields=true;
                edtAngka1.setError("Field Ini Tidak Boleh Kosong");
            }
            if (TextUtils.isEmpty(InputAngka2)) {
                isEmptyFields = true;
                edtAngka2.setError("Field Ini Tidak Boleh Kosong");
            }
            Double Operand1 = toDouble(InputAngka1);
            Double Operand2 = toDouble(InputAngka2);

            if (Operand1 == null){
                isInvalidDouble = true;
                edtAngka1.setError("Field Ini Harus Berupa Angka");
            }
            if (Operand2 == null) {
                isInvalidDouble = true;
                edtAngka2.setError("Field Ini Harus berupa ANgka");
            }
            if (!isEmptyFields && !isInvalidDouble) {
                double hasil = Operand1+Operand2;
                edtJawab.setText(String.valueOf(hasil));

            }
                        String InputAngka3 =edtJawab.getText().toString().trim();
            String InputAngka4 =txtHasil.getText().toString().trim();
            Double Operand3 = toDouble(InputAngka3);
            Double Operand4 = toDouble(InputAngka4);
            if (Operand3>Operand4){
                Toast toast = Toast.makeText(getApplicationContext(), "salah",Toast.LENGTH_SHORT);
                toast.show();
            }else if (Operand3<Operand4){
                Toast toast = Toast.makeText(getApplicationContext(), "salah",Toast.LENGTH_SHORT);
                toast.show();
            }else{
                Toast toast = Toast.makeText(getApplicationContext(), "benar",Toast.LENGTH_SHORT);
                toast.show();
            }*/
