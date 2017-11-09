package com.example.anggarisky.pandalogin.telas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.anggarisky.pandalogin.R;
import com.example.anggarisky.pandalogin.modelo.Equipe;
import com.example.anggarisky.pandalogin.testes.TesteAdapterButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mutao on 05/11/17.
 */

public class TelaEditarEquipes extends Fragment {

    ListView lv_itensEquipe;


    TesteAdapterButton tab;


    List<Equipe> equipesList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tela_editar_equipes, null);//atenção aki
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // todas ações que devem iniciar com a tela, ex: ligar botões...

        lv_itensEquipe = (ListView)getActivity().findViewById(R.id.LV_ITENS_EQUIPES);


        equipesList = Equipe.find(Equipe.class,null,null);



        tab = new TesteAdapterButton(getActivity().getBaseContext(),equipesList);


        lv_itensEquipe.setAdapter(tab);




    }

}
