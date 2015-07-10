package br.com.hisamoto.gastosPorDia.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;
import br.com.hisamoto.gastosPorDia.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class GastosPorDiaActivity extends Activity {

    private Button processar;
    private EditText energia;
    private EditText gas;
    private EditText agua;
    private EditText carne;
    private EditText verdura;
    private EditText compra;
    private EditText dias_calc;
    private EditText dias;
    private EditText valor_dias;
    private ScrollView scrollView;
    private Float val_dias;
    private EditText qtd_pessoas;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.tela_principal);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        energia = (EditText) findViewById(R.id.energia);
        agua = (EditText) findViewById(R.id.agua);
        gas = (EditText) findViewById(R.id.gas);
        carne = (EditText) findViewById(R.id.carne);
        verdura = (EditText) findViewById(R.id.verdura);
        dias = (EditText) findViewById(R.id.dias);
        compra = (EditText) findViewById(R.id.compra);
        qtd_pessoas = (EditText) findViewById(R.id.qtd_pessoas);
        dias_calc = (EditText) findViewById(R.id.dias_calc);

        valor_dias = (EditText) findViewById(R.id.valor_dias);

        energia.setInputType(InputType.TYPE_CLASS_NUMBER);
        dias.setInputType(InputType.TYPE_CLASS_NUMBER);
        qtd_pessoas.setInputType(InputType.TYPE_CLASS_NUMBER);
        valor_dias.setInputType(InputType.TYPE_CLASS_NUMBER);
        agua.setInputType(InputType.TYPE_CLASS_NUMBER);
        gas.setInputType(InputType.TYPE_CLASS_NUMBER);
        carne.setInputType(InputType.TYPE_CLASS_NUMBER);
        verdura.setInputType(InputType.TYPE_CLASS_NUMBER);
        compra.setInputType(InputType.TYPE_CLASS_NUMBER);
        dias_calc.setInputType(InputType.TYPE_CLASS_NUMBER);
        valor_dias.setEnabled(false);

        compra.addTextChangedListener(new TextWatcher() {

            private boolean isUpdating = false;

            // Pega a formatacao do sistema, se for brasil R$ se EUA US$
            private NumberFormat nf = NumberFormat.getCurrencyInstance();

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int after) {

                // Removendo R$
                DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
                decimalFormatSymbols.setCurrencySymbol("");
                ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);

                DecimalFormat df = (DecimalFormat) nf;
                df.setMinimumFractionDigits(2);

                // Evita que o método seja executado varias vezes.
                // Se tirar ele entre em loop
                if (isUpdating) {

                    isUpdating = false;
                    return;
                }

                isUpdating = true;
                String str = s.toString();

                // Verifica se já existe a máscara no texto.
                boolean hasMask = ((str.indexOf(".") > -1 || str.indexOf(",") > -1));

                // Verificamos se existe máscara
                if (hasMask) {

                    // Retiramos a máscara.
                    str = str.replaceAll("[,]", "").replaceAll("[.]", "");
                }

                try {

                    // Transformamos o número que está escrito no EditText em monetário.
                    str = df.format(Double.parseDouble(str) / 100);

                    compra.setText(str);

                    compra.setSelection(compra.getText().length());
                } catch (NumberFormatException e) {

                    s = "";
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // Não utilizamos
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Não utilizamos
            }
        });

        agua.addTextChangedListener(new TextWatcher() {

            private boolean isUpdating = false;

            // Pega a formatacao do sistema, se for brasil R$ se EUA US$
            private NumberFormat nf = NumberFormat.getCurrencyInstance();

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int after) {

                // Removendo R$
                DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
                decimalFormatSymbols.setCurrencySymbol("");
                ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);

                DecimalFormat df = (DecimalFormat) nf;
                df.setMinimumFractionDigits(2);

                // Evita que o método seja executado varias vezes.
                // Se tirar ele entre em loop
                if (isUpdating) {

                    isUpdating = false;
                    return;
                }

                isUpdating = true;
                String str = s.toString();

                // Verifica se já existe a máscara no texto.
                boolean hasMask = ((str.indexOf(".") > -1 || str.indexOf(",") > -1));

                // Verificamos se existe máscara
                if (hasMask) {

                    // Retiramos a máscara.
                    str = str.replaceAll("[,]", "").replaceAll("[.]", "");
                }

                try {

                    // Transformamos o número que está escrito no EditText em monetário.
                    str = df.format(Double.parseDouble(str) / 100);

                    agua.setText(str);

                    agua.setSelection(agua.getText().length());
                } catch (NumberFormatException e) {

                    s = "";
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // Não utilizamos
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Não utilizamos
            }
        });

        verdura.addTextChangedListener(new TextWatcher() {

            private boolean isUpdating = false;

            // Pega a formatacao do sistema, se for brasil R$ se EUA US$
            private NumberFormat nf = NumberFormat.getCurrencyInstance();

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int after) {

                // Removendo R$
                DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
                decimalFormatSymbols.setCurrencySymbol("");
                ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);

                DecimalFormat df = (DecimalFormat) nf;
                df.setMinimumFractionDigits(2);

                // Evita que o método seja executado varias vezes.
                // Se tirar ele entre em loop
                if (isUpdating) {

                    isUpdating = false;
                    return;
                }

                isUpdating = true;
                String str = s.toString();

                // Verifica se já existe a máscara no texto.
                boolean hasMask = ((str.indexOf(".") > -1 || str.indexOf(",") > -1));

                // Verificamos se existe máscara
                if (hasMask) {

                    // Retiramos a máscara.
                    str = str.replaceAll("[,]", "").replaceAll("[.]", "");
                }

                try {

                    // Transformamos o número que está escrito no EditText em monetário.
                    str = df.format(Double.parseDouble(str) / 100);

                    verdura.setText(str);

                    verdura.setSelection(verdura.getText().length());
                } catch (NumberFormatException e) {

                    s = "";
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // Não utilizamos
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Não utilizamos
            }
        });

        carne.addTextChangedListener(new TextWatcher() {

            private boolean isUpdating = false;

            // Pega a formatacao do sistema, se for brasil R$ se EUA US$
            private NumberFormat nf = NumberFormat.getCurrencyInstance();

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int after) {

                // Removendo R$
                DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
                decimalFormatSymbols.setCurrencySymbol("");
                ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);

                DecimalFormat df = (DecimalFormat) nf;
                df.setMinimumFractionDigits(2);

                // Evita que o método seja executado varias vezes.
                // Se tirar ele entre em loop
                if (isUpdating) {

                    isUpdating = false;
                    return;
                }

                isUpdating = true;
                String str = s.toString();

                // Verifica se já existe a máscara no texto.
                boolean hasMask = ((str.indexOf(".") > -1 || str.indexOf(",") > -1));

                // Verificamos se existe máscara
                if (hasMask) {

                    // Retiramos a máscara.
                    str = str.replaceAll("[,]", "").replaceAll("[.]", "");
                }

                try {

                    // Transformamos o número que está escrito no EditText em monetário.
                    str = df.format(Double.parseDouble(str) / 100);

                    carne.setText(str);

                    carne.setSelection(carne.getText().length());
                } catch (NumberFormatException e) {

                    s = "";
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // Não utilizamos
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Não utilizamos
            }
        });

        gas.addTextChangedListener(new TextWatcher() {

            private boolean isUpdating = false;

            // Pega a formatacao do sistema, se for brasil R$ se EUA US$
            private NumberFormat nf = NumberFormat.getCurrencyInstance();

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int after) {

                // Removendo R$
                DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
                decimalFormatSymbols.setCurrencySymbol("");
                ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);

                DecimalFormat df = (DecimalFormat) nf;
                df.setMinimumFractionDigits(2);

                // Evita que o método seja executado varias vezes.
                // Se tirar ele entre em loop
                if (isUpdating) {

                    isUpdating = false;
                    return;
                }

                isUpdating = true;
                String str = s.toString();

                // Verifica se já existe a máscara no texto.
                boolean hasMask = ((str.indexOf(".") > -1 || str.indexOf(",") > -1));

                // Verificamos se existe máscara
                if (hasMask) {

                    // Retiramos a máscara.
                    str = str.replaceAll("[,]", "").replaceAll("[.]", "");
                }

                try {

                    // Transformamos o número que está escrito no EditText em monetário.
                    str = df.format(Double.parseDouble(str) / 100);

                    gas.setText(str);

                    gas.setSelection(gas.getText().length());
                } catch (NumberFormatException e) {

                    s = "";
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // Não utilizamos
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Não utilizamos
            }
        });

        energia.addTextChangedListener(new TextWatcher() {

            private boolean isUpdating = false;

            // Pega a formatacao do sistema, se for brasil R$ se EUA US$
            private NumberFormat nf = NumberFormat.getCurrencyInstance();

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int after) {

                // Removendo R$
                DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
                decimalFormatSymbols.setCurrencySymbol("");
                ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);

                DecimalFormat df = (DecimalFormat) nf;
                df.setMinimumFractionDigits(2);

                // Evita que o método seja executado varias vezes.
                // Se tirar ele entre em loop
                if (isUpdating) {

                    isUpdating = false;
                    return;
                }

                isUpdating = true;
                String str = s.toString();

                // Verifica se já existe a máscara no texto.
                boolean hasMask = ((str.indexOf(".") > -1 || str.indexOf(",") > -1));

                // Verificamos se existe máscara
                if (hasMask) {

                    // Retiramos a máscara.
                    str = str.replaceAll("[,]", "").replaceAll("[.]", "");
                }

                try {

                    // Transformamos o número que está escrito no EditText em monetário.
                    str = df.format(Double.parseDouble(str) / 100);

                    energia.setText(str);

                    energia.setSelection(energia.getText().length());
                } catch (NumberFormatException e) {

                    s = "";
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // Não utilizamos
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Não utilizamos
            }
        });

        processar = (Button) findViewById(R.id.processar);
        processar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Não fazer com que ao ser clicado no botão, não ir para o topo do scrowView
                v.requestFocusFromTouch();

                calcularGasto();
            }
        });

        calcularGasto();

        // Não focar o primeiro campo do formulário
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(energia.getWindowToken(), 0);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


    }

    public boolean validarCompos() {
        if(dias.getText().toString().trim().equals("") || Integer.parseInt(dias.getText().toString().trim()) == 0) {

            Toast.makeText(getApplicationContext(), "Campo dias não pode ser zero",Toast.LENGTH_LONG).show();
            return false;
        }

        if(qtd_pessoas.getText().toString().trim().equals("") || Integer.parseInt(qtd_pessoas.getText().toString().trim()) == 0) {

            Toast.makeText(getApplicationContext(), "Campo Quantidade de pessoas não pode ser zero",Toast.LENGTH_LONG).show();
            return false;
        }

        if(dias_calc.getText().toString().trim().equals("") || Integer.parseInt(dias_calc.getText().toString().trim()) == 0) {

            Toast.makeText(getApplicationContext(), "Campo Quantidade dias para cálculo não pode ser zero",Toast.LENGTH_LONG).show();
            return false;
        }
        //

        return true;
    }

    public void calcularGasto() {

        if(!validarCompos()) {
            return;
        }

        val_dias = Float.parseFloat(dias.getText().toString());
        Float val_dias_calc = Float.parseFloat(dias_calc.getText().toString());

        String valor_energia = energia.getText().toString().replaceAll("[.]", "").replaceAll("[,]", ".");
        String valor_agua = agua.getText().toString().replaceAll("[.]", "").replaceAll("[,]", ".");
        String valor_gas = gas.getText().toString().replaceAll("[.]", "").replaceAll("[,]", ".");
        String valor_carne = carne.getText().toString().replaceAll("[.]", "").replaceAll("[,]", ".");
        String valor_verdura = verdura.getText().toString().replaceAll("[.]", "").replaceAll("[,]", ".");
        String valor_compra = compra.getText().toString().replaceAll("[.]", "").replaceAll("[,]", ".");

        Float val_energia = Float.parseFloat(valor_energia);
        Float val_agua = Float.parseFloat(valor_agua);
        Float val_gas = Float.parseFloat(valor_gas);
        Float val_carne = Float.parseFloat(valor_carne);
        Float val_verdura = Float.parseFloat(valor_verdura);
        Float val_compra = Float.parseFloat(valor_compra);

        Float total = processRegraDeTres(val_energia) +
                processRegraDeTres(val_gas) +
                processRegraDeTres(val_agua) +
                processRegraDeTres(val_verdura) +
                processRegraDeTres(val_carne) +
                processRegraDeTres(val_compra);

        total = val_dias_calc * (total / Float.parseFloat(qtd_pessoas.getText().toString()));

        valor_dias.setTextColor(Color.GREEN);
        valor_dias.setTextSize(40);

        // Pega a formatacao do sistema, se for brasil R$ se EUA US$
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        DecimalFormat df2 = (DecimalFormat) nf;
        df2.setMinimumFractionDigits(2);

        String result = df2.format(Double.parseDouble(total.toString()));

        valor_dias.setText(result);
    }

    public Float processRegraDeTres(Float valor) {

        if (val_dias == 0.00) {

            return null;
        }

        Log.i("Hisamoto", "Valor:" + valor + " Valor dias:" + val_dias + " Result:" + valor / val_dias);
        return valor / val_dias;
    }

    public void onClickHome(View v) {

        trace("Tela home");
    }

    public void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private void trace(String msg) {
        toast(msg);
    }


}
