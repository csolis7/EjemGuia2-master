package com.example.guia2;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class SegundaPantalla extends AppCompatActivity implements View.OnLongClickListener {

    TextView lblNombre;
    ProgressBar ejemPBAR;
    Button btnHola;
    int progress = 0;
    AutoCompleteTextView ACTAnimal,ACTFruta,ACTLenguaje;
    String [] animal={"León", "Jirafa", "Oso", "Tigre"};
    String [] fruta={"Manzana", "Naranja", "Uva", "Mango"};
    String [] lenguaje={"C", "C#", "C++", "Java"};
    Toast t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        t1 = Toast.makeText(getApplicationContext(), null, Toast.LENGTH_LONG);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Holi");
        }
        String nombre= getIntent().getStringExtra("Nombre");
        String apellido= getIntent().getStringExtra("Apellido");

        lblNombre=findViewById(R.id.lblNombre);
        lblNombre.setText(nombre+" "+apellido);
        ACTAnimal=findViewById(R.id.ACTAnimal);
        ACTFruta=findViewById(R.id.ACTFruta);
        ACTLenguaje=findViewById(R.id.ACTLenguaje);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, animal);
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, fruta);
        ArrayAdapter<String> adapter3=new ArrayAdapter<>(this, android.R.layout.select_dialog_item, lenguaje);

        ACTAnimal.setThreshold(1);
        ACTAnimal.setAdapter(adapter);
        ACTFruta.setThreshold(1);
        ACTFruta.setAdapter(adapter2);
        ACTLenguaje.setThreshold(1);
        ACTLenguaje.setAdapter(adapter3);
        ejemPBAR=findViewById(R.id.ejemPBAR);
        btnHola=findViewById(R.id.btnHola);

        btnHola.setOnLongClickListener(this);
    }
    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.btnHola:
                setProgressValue(progress);

                break;
        }
        return true;
    }


    Handler h = new Handler() {
        public void handleMessage(Message msg){
            if(msg.what == 0) {

                t1.setText("Animal:"+ACTAnimal.getEditableText().toString()+"\n"+
                        ("Fruta:"+ACTFruta.getEditableText().toString())+"\n"+
                        ("Lenguaje:"+ACTLenguaje.getEditableText().toString()));
                t1.show();
                ejemPBAR.setVisibility(View.GONE);
            }
        }
    };
     private void setProgressValue(final int progress){
        ejemPBAR.setProgress(progress);
        Thread  thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                setProgressValue(progress+10);
                if(progress == 100){
                    h.sendEmptyMessage(0);
                }

            }


        });
         thread.start();
    }


}
