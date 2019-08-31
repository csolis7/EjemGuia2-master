package com.example.guia2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtNombre, edtApellido, edtCarrera, edtPasatiempo;
    Button btnGuardar, btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
        edtNombre=findViewById(R.id.edtNombre);
        edtApellido=findViewById(R.id.edtApellido);
        edtCarrera=findViewById(R.id.edtCarrera);
        edtPasatiempo=findViewById(R.id.edtPasatiempo);
        btnGuardar=findViewById(R.id.btnGuardar);
        btnCancelar=findViewById(R.id.btnCancelar);

        btnGuardar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardar:{
                String nombre=edtNombre.getText().toString();
                String apellido=edtApellido.getText().toString();
                String carrera=edtCarrera.getText().toString();
                String pasatiempo=edtPasatiempo.getText().toString();

                Intent in=new Intent(this, SegundaPantalla.class);
                in.putExtra("Nombre", nombre);
                in.putExtra("Apellido", apellido);
                startActivity(in);
            }
            break;
        }
    }
}
