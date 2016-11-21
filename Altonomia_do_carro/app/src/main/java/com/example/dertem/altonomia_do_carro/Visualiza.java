package com.example.dertem.altonomia_do_carro;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dertem.altonomia_do_carro.Adapter.Adapter_Carta;
import com.example.dertem.altonomia_do_carro.Cadastro_DAO.Inform_Dao;
import com.example.dertem.altonomia_do_carro.Modelo.Alto_informa;

import java.util.ArrayList;

public class Visualiza extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiza);

        ArrayList<Alto_informa> lista = Inform_Dao.obterLista();

        RecyclerView rvListaPessoas = (RecyclerView) findViewById(R.id.rvListaPessoas);

        RecyclerView.LayoutManager formaApresentacao = new LinearLayoutManager(this.getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        rvListaPessoas.setLayoutManager(formaApresentacao);
        Adapter_Carta adaptador = new Adapter_Carta(this.getApplicationContext(), lista);
        rvListaPessoas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_visualiza, menu);
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
