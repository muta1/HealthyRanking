package com.example.anggarisky.pandalogin.modelo;

import com.orm.SugarRecord;

/**
 * Created by mutao on 14/10/17.
 */

public class Usuario extends SugarRecord<Usuario> {

    private String nome;
    private String senha;

    public Usuario(){

    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
