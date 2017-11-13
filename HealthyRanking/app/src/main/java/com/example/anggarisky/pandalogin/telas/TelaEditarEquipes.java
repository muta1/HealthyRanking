package com.example.anggarisky.pandalogin.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.anggarisky.pandalogin.R;
import com.example.anggarisky.pandalogin.modelo.Equipe;
import com.example.anggarisky.pandalogin.testes.AdapterButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mutao on 05/11/17.
 */

public class TelaEditarEquipes extends Fragment {

    static ListView lv_itensEquipe;

    static AdapterButton tab;

    static List<Equipe> equipesList = new ArrayList<>();

    static FragmentActivity fragmentActivity;



    //vars para trocar tela para DialogLayoutBtnEditar

    static Fragment fragment;
    static FragmentManager fragmentManager;
    static FragmentTransaction ft;
    static DrawerLayout drawer;


    //static long codigo;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tela_editar_equipes, null);//atenção aki
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // todas ações que devem iniciar com a tela, ex: ligar botões...
        this.drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        atualizaLista();

    }


    public void atualizaLista(){

        this.lv_itensEquipe = (ListView)getActivity().findViewById(R.id.LV_ITENS_EQUIPES);

        this.equipesList = Equipe.find(Equipe.class,null,null);

        this.tab = new AdapterButton(getActivity().getBaseContext(),equipesList);

        this.lv_itensEquipe.setAdapter(tab);

        this.fragmentActivity = getActivity();

    }

    public static void atualizarAdapterRemocao(){
        tab.notifyDataSetChanged();
        lv_itensEquipe.setAdapter(tab);
    }

    public static void atualizarAdapterEdicao(){

        lv_itensEquipe = (ListView)fragmentActivity.findViewById(R.id.LV_ITENS_EQUIPES);

        equipesList = Equipe.find(Equipe.class,null,null);

        tab = new AdapterButton(fragmentActivity.getBaseContext(),equipesList);

        lv_itensEquipe.setAdapter(tab);

    }




    public static void irParaTelaDialogLayoutBtnEditar(long cod){
        //long codigo = cod;

        fragment = new DialogLayoutBtnEditar();
        Bundle args = new Bundle();
        args.putLong("codigo",cod);
        fragment.setArguments(args);

        fragmentManager = fragmentActivity.getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.screen_area,fragment);
        ft.commit();

        drawer.closeDrawer(GravityCompat.START);


    }



}
