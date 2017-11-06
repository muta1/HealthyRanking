package com.example.anggarisky.pandalogin.telas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anggarisky.pandalogin.R;

public class AreaUsuario extends Fragment {//extends AppCompatActivity

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.area_usuario,null);//atenção aki
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // todas ações que devem iniciar com a tela, ex: ligar botões...


    }

    //    Intent it;
//
//    TextView tv_teste;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.area_usuario);
//        it = getIntent();
//
//        tv_teste=(TextView)findViewById(R.id.TV_AU_Teste);
//
//        long codigo = it.getLongExtra("codigo", -1);
//
//        if(codigo != -1) {
//            Usuario u = Usuario.findById(Usuario.class, codigo);
//            tv_teste.setText( "Codigo do usuário =" + u!=null?u.toString():"" );
//        }else{
//            tv_teste.setText("Não conseguiu.");
//        }
//    }
}
