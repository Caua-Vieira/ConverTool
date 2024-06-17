package br.com.conversordemoedas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConverterTemperaturaActivity extends AppCompatActivity {

    private EditText editQtdTemperatura;
    private Spinner spinnerTempDestino;
    private TextView textResultadoTemperatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_temperatura);

        editQtdTemperatura = findViewById(R.id.editQtdTemperatura);
        spinnerTempDestino = findViewById(R.id.spinnerTempDestino);
        textResultadoTemperatura = findViewById(R.id.textResultTemperatura);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temperaturas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTempDestino.setAdapter(adapter);
    }

    public void converterTemperatura(View view) {
        double qtdTemp = Double.parseDouble(editQtdTemperatura.getText().toString());
        String tempDestino = spinnerTempDestino.getSelectedItem().toString();
        double resultado = 0.0;

        switch (tempDestino) {
            case "Celsius para Fahrenheit":
                resultado = (qtdTemp * 9/5) + 32;
                break;
            case "Fahrenheit para Celsius":
                resultado = (qtdTemp - 32) * 5/9;
                break;
            case "Celsius para Kelvin":
                resultado = qtdTemp + 273.15;
                break;
            case "Kelvin para Celsius":
                resultado = qtdTemp - 273.15;
                break;
        }

        textResultadoTemperatura.setText(String.format("%.2f corresponde a %s %.2f", qtdTemp, tempDestino, resultado));
        editQtdTemperatura.setText("");
        editQtdTemperatura.requestFocus();
    }


    public void limparCamposTemperatura(View view) {
        editQtdTemperatura.setText("");
        textResultadoTemperatura.setText("RESULTADO:");
    }

    public void voltarParaTelaPrincipal(View view) {
        finish(); // Fecha a activity atual e retorna à activity anterior (MainActivity)
    }
}
