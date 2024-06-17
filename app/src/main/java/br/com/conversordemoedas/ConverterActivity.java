// src/br/com/conversordemoedas/ConverterActivity.java
package br.com.conversordemoedas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class ConverterActivity extends AppCompatActivity {

    private EditText editQtdReal;
    private Spinner spinnerMoedaDestino;
    private TextView textResultado;

    private Map<String, Double> taxasDeConversao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_activity);

        editQtdReal = findViewById(R.id.editQtdReal);
        spinnerMoedaDestino = findViewById(R.id.spinnerMoedaDest);
        textResultado = findViewById(R.id.textResult);

        taxasDeConversao = new HashMap<>();
        taxasDeConversao.put("Real Brasileiro (BRL)", 1.0);
        taxasDeConversao.put("Dólar (USD)", 0.19);
        taxasDeConversao.put("Euro (EUR)", 0.15);
        taxasDeConversao.put("Libra (GBP)", 0.13);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.moedas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMoedaDestino.setAdapter(adapter);
    }

    public void converter(View view) {
        double qtdReal = Double.parseDouble(editQtdReal.getText().toString());
        String moedaDestino = spinnerMoedaDestino.getSelectedItem().toString();

        if (taxasDeConversao.containsKey(moedaDestino)) {
            double taxaDeConversao = taxasDeConversao.get(moedaDestino);
            double resultado = qtdReal * taxaDeConversao;

            textResultado.setText(String.format("O valor R$ %.2f corresponde a %s %.2f", qtdReal, moedaDestino, resultado));
            editQtdReal.setText("");
            editQtdReal.requestFocus();
        } else {
            textResultado.setText("Moeda de destino não encontrada no mapa de taxas de conversão.");
        }
    }

    public void limparCampos(View view) {
        editQtdReal.setText("");
        textResultado.setText("RESULTADO:");
    }
}
