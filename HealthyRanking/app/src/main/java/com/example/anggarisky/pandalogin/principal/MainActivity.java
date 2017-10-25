package com.example.anggarisky.pandalogin.principal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anggarisky.pandalogin.R;
import com.example.anggarisky.pandalogin.modelo.Usuario;
import com.example.anggarisky.pandalogin.telas.AreaUsuario;
import com.example.anggarisky.pandalogin.telas.CadastrarUsuario;
import com.example.anggarisky.pandalogin.telas.EsqueciSenha;
import com.example.anggarisky.pandalogin.testes.TesteActivity;
import com.example.anggarisky.pandalogin.tools.ToolsDroid;

import junit.framework.Test;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv_cadastrar,tv_esqueciSenha;
    EditText et_nome,et_senha;

    Button bt_entrar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        et_nome=(EditText)findViewById(R.id.ET_TL_Nome);
        et_senha=(EditText)findViewById(R.id.ET_TL_Senha);



        tv_cadastrar = (TextView) findViewById(R.id.TV_TL_Cadastro);
        tv_cadastrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                intent = new Intent(MainActivity.this, CadastrarUsuario.class); // modificar aqui para ter acesso ao teste do banco de dados e apagar banco etc...
                startActivity(intent);
            }
        });


        tv_esqueciSenha = (TextView)findViewById(R.id.TV_TL_EsqueciSenha);
        tv_esqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,EsqueciSenha.class);
                startActivity(intent);

            }
        });


        bt_entrar = (Button)findViewById(R.id.BT_TL_Entrar);
        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.BT_TL_Entrar){
                    boolean user = true;
                    if(verificaEts()) {
                        List<Usuario> usuariosList = Usuario.listAll(Usuario.class);

                        for (Usuario u : usuariosList) { //Pegar validações da outra tela e usar aqui, setar os erros etc... aki
                            if (et_nome.getText().toString().equals(u.getNome()) && et_senha.getText().toString().equals(u.getSenha())) {
                                intent = new Intent(MainActivity.this, AreaUsuario.class);
                                startActivity(intent);
                                user = false;
                            }
                        }
                    }
                    if(user) {
                        ToolsDroid.msg("Usuário e senha inválidos...", MainActivity.this);
                    }
                }
            }
        });


    }

    public boolean verificaEts(){
        if(et_nome.getText().toString().trim().equals("")){
            et_nome.setText("");
            et_nome.setError("Por favor informe o nome.");
            return false;
        }else if(et_senha.getText().toString().trim().equals("")){
            et_senha.setText("");
            et_senha.setError("Por favor informe a senha.");
            return false;
        }
        return true;
    }

    public void msg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
