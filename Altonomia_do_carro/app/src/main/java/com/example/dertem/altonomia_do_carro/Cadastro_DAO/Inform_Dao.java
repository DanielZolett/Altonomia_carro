package com.example.dertem.altonomia_do_carro.Cadastro_DAO;

import com.example.dertem.altonomia_do_carro.Modelo.Alto_informa;

import java.util.ArrayList;

/**
 * Created by daniel on 20/11/2016.
 */

public class Inform_Dao {

    private static ArrayList<Alto_informa> listaCadastro;


    private static void inicializarLista(){
        if(Inform_Dao.listaCadastro == null){
            Inform_Dao.listaCadastro = new ArrayList<>();
        }
    }

    public static void salvar(Alto_informa cadastro){
        inicializarLista();
        listaCadastro.add(cadastro);
    }

    public static ArrayList<Alto_informa> obterLista(){
        inicializarLista();
        return  listaCadastro;
    }

}
