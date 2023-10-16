package com.example.doctorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;

import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    Button CirugiadeCorazonn;
    Button CirugiadeDientes;
    Button cardiologistButton;
    Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        CirugiadeCorazonn = findViewById(R.id.CirugiadeCorazonn);
        CirugiadeDientes = findViewById(R.id.CirugiadeDientes);
        cardiologistButton = findViewById(R.id.cardiologistButton);
        menuButton = findViewById(R.id.menubtn);

        // Configura el clic del botón para mostrar el menú emergente
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu();
            }
        });

        // Asigna clics a los botones para abrir actividades
        cardiologistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, DoctorDavidActivity.class));
            }
        });
        CirugiadeCorazonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, activity_cirugiadecorazon.class));
            }
        });
        CirugiadeDientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, cirugiadedientes_Activity.class));
            }
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    // Maneja clics en el ícono del menú en la barra de acción
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this, menuButton);
        popupMenu.inflate(R.menu.menu_popup);

        // Maneja las acciones de clic en los elementos del menú emergente
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_perfil:
                        // Abre la pantalla de perfil
                        // Aquí puedes iniciar la actividad correspondiente
                        return true;
                    case R.id.menu_ayuda:
                        // Abre la pantalla de ayuda
                        // Aquí puedes iniciar la actividad correspondiente
                        return true;
                    case R.id.menu_configuracion:
                        // Abre la pantalla de configuración
                        // Aquí puedes iniciar la actividad correspondiente
                        return true;
                    case R.id.menu_idioma:
                        // Abre la pantalla de selección de idioma
                        // Aquí puedes iniciar la actividad correspondiente
                        return true;
                    case R.id.menu_doctor:
                        // Abre la pantalla de selección de doctor
                        // Aquí puedes iniciar la actividad correspondiente
                        return true;
                    default:
                        return false;
                }
            }
        });

        // Muestra el menú emergente
        popupMenu.show();
    }
}
