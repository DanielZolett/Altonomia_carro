package com.example.dertem.altonomia_do_carro;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.dertem.altonomia_do_carro.Adapter.Adpter_Data;
import com.example.dertem.altonomia_do_carro.Cadastro_DAO.Inform_Dao;
import com.example.dertem.altonomia_do_carro.Modelo.Alto_informa;

import java.util.ArrayList;

public class Cadastro_de_abastecimento extends Activity {

    private EditText etQuilometro;
    private EditText etLitro;
    private TextView tvdata_abast;
    private static String data_Atual="";
    private float total_quilometro=0;
    private float total_litro=0;
    private float total_altonomia=0;
    Spinner Posto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_abastecimento);

        etQuilometro = (EditText) findViewById(R.id.etQuilomatro);
        etLitro = (EditText) findViewById(R.id.etLitros);
        tvdata_abast = (TextView) findViewById(R.id.tvdata_abast);
        Posto = (Spinner) findViewById(R.id.spPosto);

        ArrayAdapter adpter = ArrayAdapter.createFromResource(this,R.array.nome_Postos,android.R.layout.simple_spinner_item);
        Posto.setAdapter(adpter);
    }

    public boolean Verifica_cadastro ( ArrayList<Alto_informa> lista){
        int tma = lista.size();
        String[] data_separada = data_Atual.split("/");

        if(etQuilometro.getText().toString().trim().equals("")){
            return false;
        }
        if(etLitro.getText().toString().trim().equals("")){
            return false;
        }

        if (tma > 0 ){
            if (lista.get(tma-1).getQuilometragem() > Float.parseFloat(etQuilometro.getText().toString())){
                return false;
            }
            String[] data_ant = lista.get(tma-1).getData_abas().split("/");

            if(Verifica_data(data_ant,data_separada) == false){
                return false;
            }
        }

        if(etLitro.getText().toString().trim().equals("")){
            return false;
        }

        if(data_Atual.equals("")){
            return false;
        }

        return true;
    }

    public  boolean Verifica_data(String[] data_ant,String[] data_separada){

        if(Float.parseFloat(data_ant[2]) > Float.parseFloat(data_separada[2])){
            return false;
        }
        if(Float.parseFloat(data_ant[1]) > Float.parseFloat(data_separada[1]) || ( Float.parseFloat(data_ant[1]) > Float.parseFloat(data_separada[1]) && Float.parseFloat(data_ant[2]) < Float.parseFloat(data_separada[2]))){
            return false;
        }
        if(Float.parseFloat(data_ant[0]) > Float.parseFloat(data_separada[0]) || ( Float.parseFloat(data_ant[0]) > Float.parseFloat(data_separada[0]) && Float.parseFloat(data_ant[1]) < Float.parseFloat(data_separada[1]) && Float.parseFloat(data_ant[2]) < Float.parseFloat(data_separada[2]))){
            return false;
        }
        return true;
    }

    public void Cadastra (View origin){
        ArrayList<Alto_informa> lista = Inform_Dao.obterLista();

        if (Verifica_cadastro(lista)==false){
            Toast toast = Toast.makeText(this.getApplicationContext(), "Prencher com dados adquados", Toast.LENGTH_LONG);
            toast.show();
        }else {

            Alto_informa cadas = new Alto_informa();
            cadas.setQuilometragem(Integer.valueOf(etQuilometro.getText().toString()));
            cadas.setLitros(Integer.valueOf(etLitro.getText().toString()));
            cadas.setData_abas(data_Atual);
            cadas.setPosto(Numero_do_posto(Posto.getSelectedItem().toString()));

            Inform_Dao.salvar(cadas);

            for (int i = 0; i < lista.size(); i++) {
                total_quilometro = total_quilometro + lista.get(i).getQuilometragem();
                total_litro = total_litro + lista.get(i).getLitros();
            }

            total_altonomia = total_altonomia + (total_quilometro / total_litro);

            Intent abridor = new Intent(this.getApplicationContext(), MainActivity.class);
            abridor.putExtra("tvMedicao_altonomia", total_altonomia);
            startActivity(abridor);
        }
    }

    public int Numero_do_posto(String nome_posto){
        int numero=0;
        switch (nome_posto){
            case "Ipiranga":
                numero = 1;
                break;
            case "Petrobras":
                numero = 2;
                break;
            case "Shell":
                numero = 3;
                break;
            case "Ale":
                numero = 4;
                break;
        }
        return numero;
    }

    public void Busca_Data (View c){
        final Dialog dialog = new Dialog(Cadastro_de_abastecimento.this);
        dialog.setContentView(R.layout.activity_adpter__data);
        dialog.show();

        final DatePicker datar =(DatePicker) dialog.findViewById(R.id.dtData);
        Button acionador =(Button) dialog.findViewById(R.id.btVolta);

        acionador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data_Atual = (String.valueOf(datar.getDayOfMonth() + "/" + datar.getMonth() + "/" + datar.getYear()));
                dialog.cancel();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro_de_abastecimento, menu);
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

    public static void valor(String cadastro){
        data_Atual = cadastro;
    }
}
