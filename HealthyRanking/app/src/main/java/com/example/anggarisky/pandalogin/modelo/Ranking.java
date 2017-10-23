package com.example.anggarisky.pandalogin.modelo;

import com.orm.SugarRecord;

/**
 * Created by mutao on 22/10/17.
 */

public class Ranking extends SugarRecord<Ranking> {
    private int posicao;
    private Equipe equipe;

    public Ranking() {
    }

    public Ranking(int posicao, Equipe equipe) {
        this.posicao = posicao;
        this.equipe = equipe;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "posicao=" + posicao +
                ", equipe=" + equipe +
                '}';
    }
}
