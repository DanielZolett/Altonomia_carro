package com.example.dertem.altonomia_do_carro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dertem.altonomia_do_carro.Cadastro_DAO.Inform_Dao;
import com.example.dertem.altonomia_do_carro.Modelo.Alto_informa;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private Button btAdicionar_abas;
    private Button btVisualiza_abas;
    private TextView tvMedicao_altonomia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMedicao_altonomia = (TextView) findViewById(R.id.tvMedicao_altonomia);

        float altonomia = getIntent().getFloatExtra("tvMedicao_altonomia",0);
        tvMedicao_altonomia .setText(String.valueOf(altonomia));
    }

    public void Adicionar (View origem){
        Intent abridor = new Intent(this.getApplicationContext(), Cadastro_de_abastecimento.class);
        startActivity(abridor);
    }

    public void Visualiza (View origem){
        Intent abridor = new Intent(this.getApplicationContext(), Visualiza.class);
        startActivity(abridor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
