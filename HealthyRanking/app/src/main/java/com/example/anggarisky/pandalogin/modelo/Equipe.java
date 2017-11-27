package com.example.anggarisky.pandalogin.modelo;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mutao on 22/10/17.
 */

public class Equipe extends SugarRecord<Equipe>{

    private String nome;
    private String melhorResultado;
    private String piorResultado;
    private String dataUltimoJogo;
    private String dataProximoJogo;
    private long totalPontos;
    private long totalVitorias;
    private long totalDerrotas;
    //private List<String> integrantes = new ArrayList<String>();
    private String integrantesString;

    public Equipe() {
    }

    public Equipe(String nome, String melhorResultado, String piorResultado, String dataUltimoJogo, String dataProximoJogo, long totalPontos, long totalVitorias, long totalDerrotas /*, List<String> integrantes*/) {
        this.nome = nome;
        this.melhorResultado = melhorResultado;
        this.piorResultado = piorResultado;
        this.dataUltimoJogo = dataUltimoJogo;
        this.dataProximoJogo = dataProximoJogo;
        this.totalPontos = totalPontos;
        this.totalVitorias = totalVitorias;
        this.totalDerrotas = totalDerrotas;
      //  this.integrantes = integrantes;
    }

    public String getIntegrantesString() {
        return integrantesString;
    }

    public void setIntegrantesString(String integrantesString) {
        this.integrantesString = integrantesString;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMelhorResultado() {
        return melhorResultado;
    }

    public void setMelhorResultado(String melhorResultado) {
        this.melhorResultado = melhorResultado;
    }

    public String getPiorResultado() {
        return piorResultado;
    }

    public void setPiorResultado(String piorResultado) {
        this.piorResultado = piorResultado;
    }

    public String getDataUltimoJogo() {
        return dataUltimoJogo;
    }

    public void setDataUltimoJogo(String dataUltimoJogo) {
        this.dataUltimoJogo = dataUltimoJogo;
    }

    public String getDataProximoJogo() {
        return dataProximoJogo;
    }

    public void setDataProximoJogo(String dataProximoJogo) {
        this.dataProximoJogo = dataProximoJogo;
    }

    public long getTotalPontos() {
        return totalPontos;
    }

    public void setTotalPontos(long totalPontos) {
        this.totalPontos = totalPontos;
    }

    public long getTotalVitorias() {
        return totalVitorias;
    }

    public void setTotalVitorias(long totalVitorias) {
        this.totalVitorias = totalVitorias;
    }

    public long getTotalDerrotas() {
        return totalDerrotas;
    }

    public void setTotalDerrotas(long totalDerrotas) {
        this.totalDerrotas = totalDerrotas;
    }

//    public List<String> getIntegrantes() {
//        return integrantes;
//    }
//
//    public void setIntegrantes(List<String> integrantes) {
//        this.integrantes.addAll(integrantes);
//    }

    @Override
    public String toString() {
        return nome;
    }
}
