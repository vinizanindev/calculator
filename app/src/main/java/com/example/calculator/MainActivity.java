package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove, ponto, soma, subtracao, multiplicacao, divisao, igual, botao_limpar;
    private TextView txtExpressao, txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        botao_limpar.setOnClickListener(v -> {
            txtExpressao.setText("");
            txtResultado.setText("");
        });

        backspace.setOnClickListener(v -> {
            String string = txtExpressao.getText().toString();
            if (!string.isEmpty()) {
                txtExpressao.setText(string.substring(0, string.length() - 1));
            }
            txtResultado.setText("");
        });

        igual.setOnClickListener(v -> {
            try {
                String expressaoTexto = txtExpressao.getText().toString().replace("÷", "/");
                if (!expressaoTexto.isEmpty()) {
                    Expression expressao = new ExpressionBuilder(expressaoTexto).build();
                    double resultado = expressao.evaluate();
                    txtResultado.setText(resultado == (int) resultado ? String.valueOf((int) resultado) : String.valueOf(resultado));
                }
            } catch (Exception e) {
                txtResultado.setText(getString(R.string.erro));
            }
        });
    }

    private void IniciarComponentes() {
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.numero_ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspacke);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.numero_zero) {
            AcrescentarUmaExpressao("0", true);
        } else if (view.getId() == R.id.numero_um) {
            AcrescentarUmaExpressao("1", true);
        } else if (view.getId() == R.id.numero_dois) {
            AcrescentarUmaExpressao("2", true);
        } else if (view.getId() == R.id.numero_tres) {
            AcrescentarUmaExpressao("3", true);
        } else if (view.getId() == R.id.numero_quatro) {
            AcrescentarUmaExpressao("4", true);
        } else if (view.getId() == R.id.numero_cinco) {
            AcrescentarUmaExpressao("5", true);
        } else if (view.getId() == R.id.numero_seis) {
            AcrescentarUmaExpressao("6", true);
        } else if (view.getId() == R.id.numero_sete) {
            AcrescentarUmaExpressao("7", true);
        } else if (view.getId() == R.id.numero_oito) {
            AcrescentarUmaExpressao("8", true);
        } else if (view.getId() == R.id.numero_nove) {
            AcrescentarUmaExpressao("9", true);
        } else if (view.getId() == R.id.numero_ponto) {
            AcrescentarUmaExpressao(".", true);
        } else if (view.getId() == R.id.soma) {
            AcrescentarUmaExpressao("+", false);
        } else if (view.getId() == R.id.subtracao) {
            AcrescentarUmaExpressao("-", false);
        } else if (view.getId() == R.id.multiplicacao) {
            AcrescentarUmaExpressao("×", false);
        } else if (view.getId() == R.id.divisao) {
            AcrescentarUmaExpressao("÷", false);
        }
    }

    public void AcrescentarUmaExpressao(String string, boolean limpar_dados) {
        if (limpar_dados && !txtResultado.getText().toString().isEmpty()) {
            txtExpressao.setText("");
        }
        txtExpressao.append(string);
    }
}
