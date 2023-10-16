package com.example.doctorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DoctorDavidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_david);
        Button btnEnviarSolicitud = findViewById(R.id.btnEnviarSolicitud);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        btnEnviarSolicitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el RadioButton seleccionado
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

                if (selectedRadioButton != null) {
                    // Mostrar un mensaje de solicitud enviada
                    Toast.makeText(DoctorDavidActivity.this, "Solicitud enviada", Toast.LENGTH_SHORT).show();

                    // Enviar un mensaje a otro Activity (reemplaza 'OtroActivity.class' por la clase del Activity destino)
                    Intent intent = new Intent(DoctorDavidActivity.this, MensajesdeSolicitudActivity.class);
                    intent.putExtra("mensaje", "Solicitud aceptada por el Dr.David Cortes " );
                    startActivity(intent);
                } else {
                    // Si no se seleccionó un RadioButton, mostrar un mensaje de error
                    Toast.makeText(DoctorDavidActivity.this, "Selecciona una opción", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
