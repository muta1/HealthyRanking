package com.example.anggarisky.pandalogin.telas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.anggarisky.pandalogin.R;
import com.example.anggarisky.pandalogin.tools.ToolsMsg;

/**
 * Created by mutao on 05/11/17.
 */

public class VisualizarEquipes extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tela_visualizar_equipes,null);//atenção aki
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);










        // todas ações que devem iniciar com a tela, ex: ligar botões...

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.BT_EP_NovaEquipe:
                break;

            case R.id.BT_EP_VisualizarEquipes:
                break;



        }

    }
}
