package com.example.anggarisky.pandalogin.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anggarisky.pandalogin.R;
import com.example.anggarisky.pandalogin.modelo.Usuario;
import com.example.anggarisky.pandalogin.principal.MainActivity;
import com.example.anggarisky.pandalogin.tools.ToolsDroid;

import java.util.List;

public class CadastrarUsuario extends AppCompatActivity implements View.OnClickListener {
    String nome,senha,perguntaSecreta,resposta;
    TextView tv_jaCadastrado;
    EditText et_nome,et_senha,et_perguntaSecreta,et_resposta;
    Intent it;
    Button bt_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_usuario);
        ligaTv();
        ligaBtn();
        ligaEt();
    }

    public void ligaTv(){
        tv_jaCadastrado = (TextView)findViewById(R.id.TV_TC_JaCadastrado);
        tv_jaCadastrado.setOnClickListener(this);
    }

    public void ligaBtn(){
        bt_cadastrar=(Button)findViewById(R.id.BT_TC_Cadastrar);
        bt_cadastrar.setOnClickListener(this);
    }

    public void ligaEt(){
        et_nome=(EditText)findViewById(R.id.ET_TC_NomeCompleto);
        et_senha=(EditText)findViewById(R.id.ET_TC_Senha);
        et_perguntaSecreta=(EditText)findViewById(R.id.ET_TC_PerguntaSecreta);
        et_resposta=(EditText)findViewById(R.id.ET_TC_Resposta);
    }

    public void limpaEt(){
        et_nome.setText("");
        et_senha.setText("");
        et_perguntaSecreta.setText("");
        et_resposta.setText("");
    }

    public boolean naoExisteUsuarioComEsteNome(){
        List<Usuario> usuarios = Usuario.find(Usuario.class,null,null);
        boolean semDuplicado=true;
        for(Usuario u :usuarios){
            if(u.getNome().equals(et_nome.getText().toString())){
                ToolsDroid.msg("Já existe um usuário cadastrado com este nome.",CadastrarUsuario.this);
                limpaEt();
                semDuplicado=false;
                break;
            }
        }
        return semDuplicado;
    }

    public void verificaEts(){

        if(et_nome.getText().toString().trim().equals("")){
            et_nome.setText("");
            et_nome.setError("Por favor informe o nome.");
        }else if(et_senha.getText().toString().trim().equals("")){
            et_senha.setText("");
            et_senha.setError("Por favor informe a senha.");
        }else if(et_perguntaSecreta.getText().toString().trim().equals("")){
            et_perguntaSecreta.setText("");
            et_perguntaSecreta.setError("Por favor informe a pergunta secreta.");
        }else if(et_resposta.getText().toString().trim().equals("")){
            et_resposta.setText("");
            et_resposta.setError("Por favor informe a resposta.");
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.TV_TC_JaCadastrado:
                it = new Intent(CadastrarUsuario.this, MainActivity.class);
                startActivity(it);
                break;
            case R.id.BT_TC_Cadastrar:
                verificaEts();
                if(naoExisteUsuarioComEsteNome()){
                    //Usuario user = new Usuario()
                    ToolsDroid.msg("entrou aqui",this);
                }

                break;
            default:

        }


    }
}
