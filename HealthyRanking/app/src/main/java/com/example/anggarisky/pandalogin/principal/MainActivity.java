package com.example.anggarisky.pandalogin.principal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anggarisky.pandalogin.R;
import com.example.anggarisky.pandalogin.telas.CadastrarUsuario;
import com.example.anggarisky.pandalogin.telas.EsqueciSenha;
import com.example.anggarisky.pandalogin.testes.TesteActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv_cadastrar,tv_esqueciSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        tv_cadastrar = (TextView) findViewById(R.id.TV_TL_Cadastro);
        tv_cadastrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, CadastrarUsuario.class); // modificar aqui para ter acesso ao teste do banco de dados e apagar banco etc...
                startActivity(intent);
            }
        });


        tv_esqueciSenha = (TextView)findViewById(R.id.TV_TL_EsqueciSenha);
        tv_esqueciSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EsqueciSenha.class);
                startActivity(intent);

            }
        });

    }


    public void msg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
