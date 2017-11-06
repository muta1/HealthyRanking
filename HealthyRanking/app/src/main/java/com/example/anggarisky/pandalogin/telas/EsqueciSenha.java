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
import com.example.anggarisky.pandalogin.tools.ToolsMsg;

import java.util.List;

public class EsqueciSenha extends AppCompatActivity {

    EditText et_nome,et_pergunta,et_resposta,et_novaSenha;
    TextView tv_msgSenha;
    Button bt_buscar,bt_verificarResposta,bt_alterarSenha;
    Intent it;
    private final int limite = 3;
    private int tentativas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.esqueci_senha);

        resetTry();
        initApp();

    }


    public void initApp(){
        tv_msgSenha=(TextView)findViewById(R.id.TV_ES_MensagemSenha);

        et_nome = (EditText)findViewById(R.id.ET_ES_Nome);
        et_pergunta=(EditText)findViewById(R.id.ET_ES_Pergunta);
        et_resposta=(EditText)findViewById(R.id.ET_ES_Resposta);

        et_novaSenha=(EditText)findViewById(R.id.ET_ES_NovaSenha);
        bt_alterarSenha=(Button)findViewById(R.id.BT_ES_NovaSenhaConfirma);

        bt_verificarResposta = (Button)findViewById(R.id.BT_ES_VerificarResposta);

        bt_buscar = (Button)findViewById(R.id.BT_ES_Buscar);
        bt_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(verificaEtNome()) {
                    if (v.getId() == R.id.BT_ES_Buscar) {
                        List<Usuario> usuariosList = Usuario.find(Usuario.class,"nome = ?",et_nome.getText().toString());
                        if(usuariosList.size() > 0){
                            tv_msgSenha.setVisibility(View.VISIBLE);
                            et_pergunta.setVisibility(View.VISIBLE);
                            et_resposta.setVisibility(View.VISIBLE);
                            bt_verificarResposta.setVisibility(View.VISIBLE);

                            final Usuario user = (Usuario)usuariosList.get(0);
                            final String resp = user.getResposta();

                            if(user!= null){
                                et_pergunta.setText(user.getPerguntaSecreta());
                                et_pergunta.setEnabled(false);

                                bt_verificarResposta.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(verificaEtResposta()){
                                            if(v.getId() == R.id.BT_ES_VerificarResposta){

                                                if(resp.equals(et_resposta.getText().toString())){//se as respostas corresponderem, liberar campo alterar senha.


                                                    et_novaSenha.setVisibility(View.VISIBLE);
                                                    bt_alterarSenha.setVisibility(View.VISIBLE);

                                                    bt_alterarSenha.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {

                                                            if(v.getId() == R.id.BT_ES_NovaSenhaConfirma) {
                                                                if(!et_novaSenha.getText().toString().equals("")){
                                                                    user.setSenha(et_novaSenha.getText().toString());
                                                                    user.save();

                                                                    et_novaSenha.setError("Senha alterada com sucesso.");

                                                                    it = new Intent(EsqueciSenha.this,MainActivity.class);
                                                                    startActivity(it);

                                                                }else{
                                                                    et_novaSenha.setError("O campo Nova Senha está vazio.");
                                                                }
                                                            }
                                                        }
                                                    });

                                                    ToolsMsg.msg("Altere sua senha... ",EsqueciSenha.this);

                                                }else{
                                                    if(tentativas < limite){ // com um limite de 3 tentativas, ou redireciona para tela principal
                                                        increaseTry();
                                                        //ToolsMsg.msg("Aumentando tentativas = "+ tentativas,EsqueciSenha.this);
                                                    }else{
                                                        ToolsMsg.msg("Número limite de tentativas atingido...",EsqueciSenha.this);
                                                        it = new Intent(EsqueciSenha.this, MainActivity.class);
                                                        startActivity(it);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                });


                            }

                        }else{
                            ToolsMsg.msg("Usuário não encontrado.",EsqueciSenha.this);
                            tv_msgSenha.setVisibility(View.INVISIBLE);
                            et_pergunta.setVisibility(View.INVISIBLE);
                            et_resposta.setVisibility(View.INVISIBLE);
                            bt_verificarResposta.setVisibility(View.INVISIBLE);
                        }
                    }
                }
            }
        });
    }

    public void increaseTry(){
        this.tentativas++;
    }

    public void resetTry(){
        this.tentativas = 0;
    }

    public boolean verificaEtNome(){
        if(et_nome.getText().toString().trim().equals("")){
            et_nome.setText("");
            et_nome.setError("Por favor informe o nome.");
            return false;
        }
        return true;
    }

    public boolean verificaEtResposta(){
        if(et_resposta.getText().toString().trim().equals("")){
            et_resposta.setText("");
            et_resposta.setError("Por favor informe a resposta.");
            return false;
        }
        return true;
    }
}
