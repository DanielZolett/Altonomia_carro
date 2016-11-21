package com.example.dertem.altonomia_do_carro.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.dertem.altonomia_do_carro.Cadastro_de_abastecimento;
import com.example.dertem.altonomia_do_carro.R;

public class Adpter_Data extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adpter__data);

        final DatePicker dp = (DatePicker) findViewById(R.id.dtData);
        final Button Btn = (Button) findViewById(R.id.btVolta);
        Cadastro_de_abastecimento.valor(String.valueOf(dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear()));

    }

}
