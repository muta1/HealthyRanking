package com.example.anggarisky.pandalogin.modelo;

import com.orm.SugarRecord;

/**
 * Created by mutao on 22/10/17.
 */

public class Competicao extends SugarRecord<Competicao> {
    private String nomeCompeticao;
    private String data_ini;
    private String data_fim;
    private Equipe equipe1 = new Equipe();
    private Equipe equipe2 = new Equipe();

    public Competicao() {
    }



    public Competicao(String nomeCompeticao, String data_ini, String data_fim, Equipe equipe1, Equipe equipe2) {
        this.nomeCompeticao = nomeCompeticao;
        this.data_ini = data_ini;
        this.data_fim = data_fim;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
    }

    public String getNomeCompeticao() {
        return nomeCompeticao;
    }

    public void setNomeCompeticao(String nomeCompeticao) {
        this.nomeCompeticao = nomeCompeticao;
    }

    public String getData_ini() {
        return data_ini;
    }

    public void setData_ini(String data_ini) {
        this.data_ini = data_ini;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    @Override
    public String toString() {
        return "Competicao{" +
                "nomeCompeticao='" + nomeCompeticao + '\'' +
                ", data_ini='" + data_ini + '\'' +
                ", data_fim='" + data_fim + '\'' +
                ", equipe1=" + equipe1 +
                ", equipe2=" + equipe2 +
                '}';
    }
}
