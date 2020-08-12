package com.miguerohdez.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView txInNombre;
    private EditText txInFecNac;
    private TextView txInTel;
    private TextView txInEmail;
    private TextView txInDesc;


    private DatePickerDialog.OnDateSetListener txFecNacListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txInNombre = (TextView) findViewById(R.id.txInNombreC);
        txInFecNac = (EditText) findViewById(R.id.txInFechaNac);
        txInTel = (TextView) findViewById(R.id.txInTelefono);
        txInEmail = (TextView) findViewById(R.id.txInEmail);
        txInDesc = (TextView) findViewById(R.id.txInDesc);


        txInFecNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int anio = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        txFecNacListener, anio,mes,dia );

                dialog.show();

            }
        });

        txFecNacListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
               mes = mes+1;
               String fechaNac = dia+"/"+mes+"/"+anio;
               txInFecNac.setText(fechaNac);
            }
        };

        Button btnSiguiente = (Button) findViewById(R.id.btnSig);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtra("Nombre",txInNombre.getText().toString());
                intent.putExtra("FechaNac",txInFecNac.getText().toString());
                intent.putExtra("Telefono",txInTel.getText().toString());
                intent.putExtra("Email",txInEmail.getText().toString());
                intent.putExtra("Descripcion",txInDesc.getText().toString());


                startActivity(intent);
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        try {


            Bundle parametros = getIntent().getExtras();
            String nombre = parametros.getString("Nombre");
            String fechaNac = parametros.getString("FechaNac");
            String telefono = parametros.getString("Telefono");
            String email = parametros.getString("Email");
            String descripcion = parametros.getString("Descripcion");

            TextInputEditText tvNombre = (TextInputEditText) findViewById(R.id.txInNombreC);
            EditText tvFechaNac = (EditText) findViewById(R.id.txInFechaNac);
            TextInputEditText tvTelefono = (TextInputEditText) findViewById(R.id.txInTelefono);
            TextInputEditText tvEmail = (TextInputEditText) findViewById(R.id.txInEmail);
            TextInputEditText tvDescripcion = (TextInputEditText) findViewById(R.id.txInDesc);

            tvNombre.setText(nombre);
            tvFechaNac.setText(fechaNac);
            tvTelefono.setText(telefono);
            tvEmail.setText(email);
            tvDescripcion.setText(descripcion);
        }catch (Exception e){

        }
    }
}