package com.miguerohdez.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNac;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("Nombre");
        String fechaNac = parametros.getString("FechaNac");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String descripcion = parametros.getString("Descripcion");

        tvNombre = (TextView) findViewById(R.id.txNombreC);
        tvFechaNac = (TextView) findViewById(R.id.txFecNac);
        tvTelefono = (TextView) findViewById(R.id.txTel);
        tvEmail = (TextView) findViewById(R.id.txEmail);
        tvDescripcion = (TextView) findViewById(R.id.txDesc);

        tvNombre.setText(nombre);
        tvFechaNac.setText(fechaNac);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        Button btnEditar = (Button) findViewById(R.id.btEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                intent.putExtra("Nombre",tvNombre.getText().toString());
                intent.putExtra("FechaNac",tvFechaNac.getText().toString());
                intent.putExtra("Telefono",tvTelefono.getText().toString());
                intent.putExtra("Email",tvEmail.getText().toString());
                intent.putExtra("Descripcion",tvDescripcion.getText().toString());
                startActivity(intent);
            }
        });

    }
}