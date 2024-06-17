package br.com.conversordemoedas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConverterUnidadesActivity extends AppCompatActivity {

    private EditText editQtdUnidade;
    private Spinner spinnerUnidadeDestino;
    private TextView textResultadoUnidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_unidades);

        editQtdUnidade = findViewById(R.id.editQtdUnidade);
        spinnerUnidadeDestino = findViewById(R.id.spinnerUnidadeDestino);
        textResultadoUnidade = findViewById(R.id.textResultUnidade);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.unidades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnidadeDestino.setAdapter(adapter);
    }

    public void converterUnidade(View view) {
        double qtdUnidade = Double.parseDouble(editQtdUnidade.getText().toString());
        String unidadeDestino = spinnerUnidadeDestino.getSelectedItem().toString();
        double resultado = 0.0;

        switch (unidadeDestino) {
            case "Quilômetros para Milhas":
                resultado = qtdUnidade * 0.621371;
                break;
            case "Milhas para Quilômetros":
                resultado = qtdUnidade * 1.60934;
                break;
            case "Metros para Pés":
                resultado = qtdUnidade * 3.28084;
                break;
            case "Pés para Metros":
                resultado = qtdUnidade * 0.3048;
                break;
        }

        textResultadoUnidade.setText(String.format("O valor %.2f corresponde a %s %.2f", qtdUnidade, unidadeDestino, resultado));
        editQtdUnidade.setText("");
        editQtdUnidade.requestFocus();
    }

    public void limparCamposUnidade(View view) {
        editQtdUnidade.setText("");
        textResultadoUnidade.setText("RESULTADO:");
    }

    public void voltarParaTelaPrincipal(View view) {
        finish(); // Fecha a activity atual e retorna à activity anterior (MainActivity)
    }
}
