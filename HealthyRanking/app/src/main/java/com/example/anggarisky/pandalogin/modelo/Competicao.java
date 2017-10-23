package com.example.anggarisky.pandalogin.modelo;

import com.orm.SugarRecord;

/**
 * Created by mutao on 22/10/17.
 */

public class Competicao extends SugarRecord<Competicao> {
    private String nomeCompeticao;
    private String data_ini;
    private String data_fim;
    private Equipe equipe;

    public Competicao() {
    }

    public Competicao(String nomeCompeticao, String data_ini, String data_fim, Equipe equipe) {
        this.nomeCompeticao = nomeCompeticao;
        this.data_ini = data_ini;
        this.data_fim = data_fim;
        this.equipe = equipe;
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

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return "Competicao{" +
                "nomeCompeticao='" + nomeCompeticao + '\'' +
                ", data_ini='" + data_ini + '\'' +
                ", data_fim='" + data_fim + '\'' +
                ", equipe=" + equipe +
                '}';
    }
}
