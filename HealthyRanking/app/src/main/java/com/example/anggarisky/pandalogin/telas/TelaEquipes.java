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

public class TelaEquipes extends Fragment implements View.OnClickListener{

    Button bt_novaEquipe,bt_visualizarEquipes,bt_editarEquipes;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction ft;
    DrawerLayout drawer;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tela_equipes,null);//atenção aki
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        // todas ações que devem iniciar com a tela, ex: ligar botões...

        bt_editarEquipes=(Button)getActivity().findViewById(R.id.BT_EP_EditarEquipes);
        bt_editarEquipes.setOnClickListener(this);

//        bt_visualizarEquipes=(Button)getActivity().findViewById(R.id.BT_EP_VisualizarEquipes);
//        bt_visualizarEquipes.setOnClickListener(this);

        bt_novaEquipe=(Button)getActivity().findViewById(R.id.BT_EP_NovaEquipe);
        bt_novaEquipe.setOnClickListener(this);

        drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.BT_EP_NovaEquipe:
                fragment = new CadastrarEquipe();
                fragmentManager = getActivity().getSupportFragmentManager();
                ft = fragmentManager.beginTransaction();
                ft.replace(R.id.screen_area,fragment);
                ft.commit();


                drawer.closeDrawer(GravityCompat.START);
            break;

//            case R.id.BT_EP_VisualizarEquipes:
//                fragment = new VisualizarEquipes();
//                fragmentManager = getActivity().getSupportFragmentManager();
//                ft = fragmentManager.beginTransaction();
//                ft.replace(R.id.screen_area,fragment);
//                ft.commit();
//
//
//                drawer.closeDrawer(GravityCompat.START);
//                break;
            case R.id.BT_EP_EditarEquipes:

                fragment = new TelaEditarEquipes();
                fragmentManager = getActivity().getSupportFragmentManager();
                ft = fragmentManager.beginTransaction();
                ft.replace(R.id.screen_area,fragment);
                ft.commit();


                drawer.closeDrawer(GravityCompat.START);

                break;


        }

    }
}
