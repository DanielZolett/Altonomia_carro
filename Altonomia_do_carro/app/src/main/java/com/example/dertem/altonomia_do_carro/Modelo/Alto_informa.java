package com.example.dertem.altonomia_do_carro.Modelo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by daniel on 20/11/2016.
 */

public class Alto_informa implements Parcelable {

    private float quilometragem;
    private float litros;
    private String data_abas;
    private int posto;


    public Alto_informa(){

    }

    protected  Alto_informa (Parcel in){

        quilometragem = in.readFloat();
        litros = in.readFloat();
        data_abas = in.readString();
        posto  = in.readInt();
    }


    public static final Creator<Alto_informa> CREATOR = new Creator<Alto_informa>() {
        @Override
        public Alto_informa createFromParcel(Parcel in) {
            return new Alto_informa(in);
        }

        @Override
        public Alto_informa[] newArray(int size) {
            return new Alto_informa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(quilometragem);
        parcel.writeFloat(litros);
        parcel.writeString(data_abas);
        parcel.writeInt(posto);
    }

    public float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public float getLitros() {
        return litros;
    }

    public void setLitros(float litros) {
        this.litros = litros;
    }

    public String getData_abas() {
        return data_abas;
    }

    public void setData_abas(String data_abas) {
        this.data_abas = data_abas;
    }

    public int getPosto() {
        return posto;
    }

    public void setPosto(int posto) {
        this.posto = posto;
    }

}
