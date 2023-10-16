package com.example.doctorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MoreInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        // Botón para regresar a DashboardActivity
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Regresar a la actividad DashboardActivity
                Intent intent = new Intent(MoreInfoActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish(); // Opcional: finaliza la actividad actual para que no quede en la pila de actividades
            }
        });

        TextView moreInfoTextView = findViewById(R.id.moreInfoTextView);

        // Aquí puedes establecer el texto con información adicional sobre la cirugía de corazón
        String moreInfoText = "La cirugía de corazón es un procedimiento médico que se realiza para corregir problemas en el corazón. " +
                "Este tipo de cirugía puede ser necesario en casos graves de enfermedades cardíacas. " +
                "El cirujano realiza la cirugía abriendo el pecho del paciente y trabajando directamente en el corazón. " +
                "Es importante seguir las indicaciones médicas antes y después de la cirugía.";

        moreInfoTextView.setText(moreInfoText);
    }
}
