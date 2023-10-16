package com.example.doctorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MensajesdeSolicitudActivity extends AppCompatActivity {

    Button btnRegresarAlMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajesde_solicitud);
         Button btnRegresarAlMenu = findViewById(R.id.btnRegresarAlMenu);

        btnRegresarAlMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MensajesdeSolicitudActivity.this, DashboardActivity.class));
            }
        });



        // Obtener el mensaje enviado desde DoctorDavidActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String mensaje = extras.getString("mensaje");

            // Mostrar el mensaje en un TextView en la actividad MensajesdeSolicitudActivity
            TextView textViewMensaje = findViewById(R.id.textViewMensaje);
            if (textViewMensaje != null) {
                textViewMensaje.setText(mensaje);
            }
        }
    }
}
