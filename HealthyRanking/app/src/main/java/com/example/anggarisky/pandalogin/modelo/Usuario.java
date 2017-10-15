package com.example.anggarisky.pandalogin.modelo;

import com.orm.SugarRecord;

/**
 * Created by mutao on 14/10/17.
 */

public class Usuario extends SugarRecord<Usuario> {

    private String nome;
    private String senha;
    private String perguntaSecreta;
    private String resposta;

    public Usuario(){

    }

    public Usuario(String nome, String senha, String perguntaSecreta, String resposta) {
        this.nome = nome;
        this.senha = senha;
        this.perguntaSecreta = perguntaSecreta;
        this.resposta = resposta;
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

    public String getPerguntaSecreta() {
        return perguntaSecreta;
    }

    public void setPerguntaSecreta(String perguntaSecreta) {
        this.perguntaSecreta = perguntaSecreta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", perguntaSecreta='" + perguntaSecreta + '\'' +
                ", resposta='" + resposta + '\'' +
                '}';
    }
}
