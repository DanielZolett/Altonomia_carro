package com.example.dertem.altonomia_do_carro.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dertem.altonomia_do_carro.Modelo.Alto_informa;
import com.example.dertem.altonomia_do_carro.R;

import java.util.ArrayList;

/**
 * Created by daniel on 20/11/2016.
 */

public class Adapter_Carta extends RecyclerView.Adapter {

    private ArrayList<Alto_informa> listaDeCadastro;
    private Context context;

    public Adapter_Carta(Context c, ArrayList<Alto_informa> p) {
        this.listaDeCadastro = p;
        this.context = c;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carta_de_apresentacao, parent, false);
        PessoaViewHolder retorno = new PessoaViewHolder(view);
        return retorno;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        PessoaViewHolder caixinha = (PessoaViewHolder) holder;
        Alto_informa p = listaDeCadastro.get(position);
        caixinha.seAtualiza(p);

    }

    @Override
    public int getItemCount() {
        return listaDeCadastro.size();
    }

    public class PessoaViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPosto;
        private TextView tvData;
        private TextView tvKm;
        private TextView tvLitros;

        public PessoaViewHolder(View itemView) {
            super(itemView);

            this.ivPosto = (ImageView) itemView.findViewById(R.id.ivPosto);
            this.tvData = (TextView) itemView.findViewById(R.id.tvData);
            this.tvKm = (TextView) itemView.findViewById(R.id.tvKm);
            this.tvLitros = (TextView) itemView.findViewById(R.id.tvLitros);

        }

        public void seAtualiza(Alto_informa quemDevoMostrar) {
            tvData.setText(quemDevoMostrar.getData_abas());
            tvKm.setText(Float.toString(quemDevoMostrar.getQuilometragem()));
            tvLitros.setText(Float.toString(quemDevoMostrar.getLitros()));

            switch (quemDevoMostrar.getPosto()){

                case 1:
                    ivPosto.setImageResource(R.drawable.ipranga);
                    break;
                case 2:
                    ivPosto.setImageResource(R.drawable.petrobras);
                    break;
                case 3:
                    ivPosto.setImageResource(R.drawable.shell);
                    break;
                case 4:
                    ivPosto.setImageResource(R.drawable.ale);
                    break;
            }
        }

    }
}
