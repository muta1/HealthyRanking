package com.example.anggarisky.pandalogin.testes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anggarisky.pandalogin.R;
import com.example.anggarisky.pandalogin.modelo.Usuario;
import com.example.anggarisky.pandalogin.tools.ToolsMsg;

import java.util.List;

public class TesteActivity extends AppCompatActivity {


    EditText et_nome,et_senha,et_confirmarSenha,et_perguntaSecreta,et_respostaSecreta;
    Button bt_cadastrar,bt_testar,bt_apagarTudo;

    TextView tv_mostrar;



    Usuario usu ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        ToolsMsg.msg("sei lá",this);

        tv_mostrar=(TextView)findViewById(R.id.TV_TT_MostraTeste);



        et_nome =(EditText)findViewById(R.id.ET_TT_Nome);
        et_senha = (EditText)findViewById(R.id.ET_TT_Senha);
        et_confirmarSenha= (EditText)findViewById(R.id.ET_TT_ConfirmarSenha);
        et_perguntaSecreta=(EditText)findViewById(R.id.ET_TT_PerguntaSecreta);
        et_respostaSecreta = (EditText)findViewById(R.id.ET_TT_RespostaSecreta);


        bt_testar = (Button)findViewById(R.id.BT_TT_Testar);
        bt_testar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.BT_TT_Testar){
                    List<Usuario> usuarioList;
                    usuarioList = usu.find(Usuario.class,null,null);
                    if(usuarioList!=null) {
                        tv_mostrar.setText(usuarioList.toString());
                    }
                }
            }
        });


        bt_cadastrar = (Button)findViewById(R.id.BT_TT_EfetuarCadastro);
        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.BT_TT_EfetuarCadastro){
                    usu = new Usuario(et_nome.getText().toString(),et_senha.getText().toString(),et_perguntaSecreta.getText().toString(),et_respostaSecreta.getText().toString());
                    usu.save();
                    //List<Usuario> usuarioList = usu.find(Usuario.class,"nome = ?",new String(usu.getNome()));
                }
            }
        });

        bt_apagarTudo=(Button)findViewById(R.id.BT_TT_ApagarTudo);
        bt_apagarTudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.BT_TT_ApagarTudo){
                    boolean b = TesteActivity.this.deleteDatabase("healthyranking");
                    if(b){
                        ToolsMsg.msg("Banco dropado com sucesso.",TesteActivity.this);
                    }
                }
            }
        });

    }



}
