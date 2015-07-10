package br.com.hisamoto.gastosPorDia.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import br.com.hisamoto.gastosPorDia.R;

/**
 * @author Leandro Shindi
 * @version 1.0 10/07/15.
 */
public class Splash extends Activity implements Runnable {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        Handler handler = new Handler();
        handler.postDelayed(this, 8000);
    }

    @Override
    public void run() {

        startActivity(new Intent(this, GastosPorDiaActivity.class));
        finish();
    }
}