package com.example.anggarisky.pandalogin.telas;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
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

/**
 * Created by mutao on 26/11/17.
 */

public class TelaCompeticoes extends Fragment implements View.OnClickListener {

    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction ft;
    DrawerLayout drawer;


    Button bt_novaCompeticao,bt_visualizarCompeticoes, bt_startSom,bt_stopSom;



    MediaPlayer mp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tela_competicoes, null);//atenção aki

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        bt_novaCompeticao = (Button)getActivity().findViewById(R.id.BT_TC_NovaCompeticao);
        bt_novaCompeticao.setOnClickListener(this);


        bt_startSom = (Button)getActivity().findViewById(R.id.BT_START_SOM);
        bt_startSom.setOnClickListener(this);


        bt_stopSom = (Button)getActivity().findViewById(R.id.BT_STOP_SOM);
        bt_stopSom.setOnClickListener(this);


        drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BT_TC_NovaCompeticao:
                fragment = new TelaNovaCompeticao();
                fragmentManager = getActivity().getSupportFragmentManager();
                ft = fragmentManager.beginTransaction();
                ft.replace(R.id.screen_area,fragment);
                ft.commit();


                drawer.closeDrawer(GravityCompat.START);
                break;


            case R.id.BT_START_SOM:

                mp = MediaPlayer.create(getContext(),R.raw.racionais);

                mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mp.start();
                    }
                });


                break;

            case R.id.BT_STOP_SOM:
                mp.stop();

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
//            case R.id.BT_EP_EditarEquipes:
//
//                fragment = new TelaEditarEquipes();
//                fragmentManager = getActivity().getSupportFragmentManager();
//                ft = fragmentManager.beginTransaction();
//                ft.replace(R.id.screen_area,fragment);
//                ft.commit();
//
//
//                drawer.closeDrawer(GravityCompat.START);
//
//                break;


        }
    }
}
