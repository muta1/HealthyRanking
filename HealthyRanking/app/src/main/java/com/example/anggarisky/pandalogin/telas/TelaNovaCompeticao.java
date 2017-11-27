package com.example.anggarisky.pandalogin.telas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.example.anggarisky.pandalogin.R;
import com.example.anggarisky.pandalogin.modelo.Competicao;
import com.example.anggarisky.pandalogin.modelo.Equipe;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mutao on 12/11/17.
 */

public class TelaNovaCompeticao extends Fragment implements View.OnClickListener {
    EditText et_nomeCompeticao;
    Button bt_NovaCompeticao;
    Spinner sp_equipe1, sp_equipe2;
    List<Equipe> equipeList = new ArrayList<>();
    ArrayAdapter<Equipe> arrayAdapterEquipe;
    DatePicker dp_dataHora;


    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction ft;
    DrawerLayout drawer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tela_nova_competicao, null);//atenção aki
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Equipe> arrayListEquipe = Equipe.find(Equipe.class, null, null);

        et_nomeCompeticao = (EditText) getActivity().findViewById(R.id.ET_TC_NomeCompeticao);

        dp_dataHora = (DatePicker) getActivity().findViewById(R.id.DP_TC_Data);

        ScrollView scrollView = (ScrollView)getActivity().findViewById(R.id.scrollView);
        scrollView.computeScroll();
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
        scrollView.setFocusable(true);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setFillViewport(true);
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.requestFocusFromTouch();
                return false;
            }
        });


        if (arrayListEquipe != null) {
            equipeList.addAll(arrayListEquipe);
            //ToolsMsg.msg("deu certo -----", getContext());
            arrayAdapterEquipe = new ArrayAdapter<Equipe>(getContext(), android.R.layout.simple_list_item_1, equipeList);
        }

        if (arrayAdapterEquipe != null) {
            sp_equipe1 = (Spinner)getActivity().findViewById(R.id.SP_TC_Equipe1);
            sp_equipe2 = (Spinner)getActivity().findViewById(R.id.SP_TC_Equipe2);

            sp_equipe1.setAdapter(arrayAdapterEquipe);
            sp_equipe2.setAdapter(arrayAdapterEquipe);
        }

        bt_NovaCompeticao = (Button) getActivity().findViewById(R.id.BT_TC_NovaCompeticao);
        bt_NovaCompeticao.setOnClickListener(this);


        drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.BT_TC_NovaCompeticao){

            if(et_nomeCompeticao.getText().toString().equalsIgnoreCase("")){
                et_nomeCompeticao.setError("Nome da competição é obrigatório.");
                et_nomeCompeticao.setText("");
            }else {

                String nomeCompeticao = et_nomeCompeticao.getText().toString();
                Equipe equipe1 = (Equipe) sp_equipe1.getSelectedItem();
                Equipe equipe2 = (Equipe) sp_equipe2.getSelectedItem();

                //Calendar calendar = new GregorianCalendar(dp_dataHora.getYear(),dp_dataHora.getMonth(),dp_dataHora.getDayOfMonth()+1);
                int dia, mes, ano;
                dia = dp_dataHora.getDayOfMonth();
                mes = dp_dataHora.getMonth() + 1;
                ano = dp_dataHora.getYear();
                String datacomp = dia+"/"+ mes + "/" + ano;
                //            ToolsMsg.msg(" 1 --> "+ equipe1.getNome() + "\n 2 --> " + equipe2.getNome()+ "\n\n Dia: " + dp_dataHora.getDayOfMonth() + " Mês: " + String.valueOf(dp_dataHora.getMonth()+1)+ " Ano: " + dp_dataHora.getYear(), getContext() );

                Competicao competicao = new Competicao();

                competicao.setNomeCompeticao(nomeCompeticao);
                competicao.setData_ini(datacomp);
                competicao.setEquipe1(equipe1);
                competicao.setEquipe2(equipe2);

                if(competicao!=null) {
                    competicao.save();

                    fragment = new TelaCompeticoes();
                    fragmentManager = getActivity().getSupportFragmentManager();
                    ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.screen_area,fragment);
                    ft.commit();

                }else{
                    Log.i("ERROR TelaNovaComp-->","IMPOSSIVEL SALVAR");
                }
            }
        }

    }


}
