package com.example.doctorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;

public class activity_Register extends AppCompatActivity {

    private TextInputLayout nameTextInputLayout, edadTextInputLayout, emailTextInputLayout, passwordTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameTextInputLayout = findViewById(R.id.nameTextInputLayout);
        edadTextInputLayout = findViewById(R.id.edadTextInputLayout);
        emailTextInputLayout = findViewById(R.id.emailTextInputLayout);
        passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout);

        Button registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los valores de los campos
                String name = nameTextInputLayout.getEditText().getText().toString();
                String edad = edadTextInputLayout.getEditText().getText().toString();
                String email = emailTextInputLayout.getEditText().getText().toString();
                String password = passwordTextInputLayout.getEditText().getText().toString();

                // Validar los campos
                if (validateForm(name, edad, email, password)) {
                    // Guardar los datos del usuario en algún lugar (por ejemplo, base de datos)
                    // Aquí puedes implementar la lógica para guardar los datos

                    // Después de un registro exitoso, inicia la actividad de inicio de sesión
                    Intent intent = new Intent(activity_Register.this, activity_Login.class);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            }
        });
    }

    // Función para validar los campos del formulario de registro
    private boolean validateForm(String name, String edad, String email, String password) {
        boolean isValid = true;

        if (TextUtils.isEmpty(name)) {
            nameTextInputLayout.setError("Este campo es requerido");
            isValid = false;
        } else {
            nameTextInputLayout.setError(null);
        }

        if (TextUtils.isEmpty(edad)) {
            edadTextInputLayout.setError("Este campo es requerido");
            isValid = false;
        } else {
            edadTextInputLayout.setError(null);
        }

        if (TextUtils.isEmpty(email)) {
            emailTextInputLayout.setError("Este campo es requerido");
            isValid = false;
        } else {
            emailTextInputLayout.setError(null);
        }

        if (TextUtils.isEmpty(password)) {
            passwordTextInputLayout.setError("Este campo es requerido");
            isValid = false;
        } else {
            passwordTextInputLayout.setError(null);
        }

        return isValid;
    }
}
