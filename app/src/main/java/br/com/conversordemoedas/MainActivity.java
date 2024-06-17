// src/br/com/conversordemoedas/MainActivity.java
package br.com.conversordemoedas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToConverterActivity(View view) {
        Intent intent = new Intent(this, ConverterActivity.class);
        startActivity(intent);
    }

    public void voltarParaTelaPrincipal(View view) {
        finish();
    }

    public void abrirConversorTemperatura(View view) {
        Intent intent = new Intent(MainActivity.this, ConverterTemperaturaActivity.class);
        startActivity(intent);
    }

    public void abrirConversorUnidades(View view) {
        Intent intent = new Intent(MainActivity.this, ConverterUnidadesActivity.class);
        startActivity(intent);
    }



}
