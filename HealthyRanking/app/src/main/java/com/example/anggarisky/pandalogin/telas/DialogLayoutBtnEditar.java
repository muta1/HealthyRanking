package com.example.anggarisky.pandalogin.telas;

import android.annotation.SuppressLint;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.anggarisky.pandalogin.R;
import com.example.anggarisky.pandalogin.modelo.Equipe;
import com.example.anggarisky.pandalogin.tools.ToolsMsg;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by mutao on 11/11/17.
 */

public class DialogLayoutBtnEditar extends Fragment implements View.OnClickListener {


    //vars para trocar tela para DialogLayoutBtnEditar

    Button bt_addIntegrante, bt_remIntegrante, bt_attEquipe;
    EditText et_nomeEquipe, et_nomeIntegrante;

    Spinner sp_integrantes;
    List<String> integrantesStringList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;


    static Fragment fragment;
    static FragmentManager fragmentManager;
    static FragmentTransaction ft;
    static DrawerLayout drawer;

    static FragmentActivity fragmentActivity = new FragmentActivity();

    static long codigo;

    Equipe equipe = new Equipe();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_layout_btneditar, null);//atenção aki
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        linkComponents();

        codigo = getArguments().getLong("codigo");//testezinho
        equipe = Equipe.findById(Equipe.class, codigo);


        et_nomeEquipe.setText(equipe.getNome());

        String semVirgula = equipe.getIntegrantesString();

        String[] arrStr = semVirgula.split(Pattern.quote(","));

        for (String xtring : arrStr) {
            this.integrantesStringList.add(xtring);
        }


        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, this.integrantesStringList);
        sp_integrantes.setAdapter(arrayAdapter);


        this.fragmentActivity = getActivity();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.BT_EE_AddIntegrante:
                //ToolsMsg.msg("" + equipe.toString(), getContext());
                if (!et_nomeIntegrante.getText().toString().equalsIgnoreCase("")) {
                    this.integrantesStringList.add(et_nomeIntegrante.getText().toString());
                    arrayAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, this.integrantesStringList);
                } else {
                    et_nomeIntegrante.setError("Insira um nome válido.");
                }

                sp_integrantes.setAdapter(arrayAdapter);

                break;

            case R.id.BT_EE_RemIntegrante:
                if (sp_integrantes.getSelectedItem() != null) {
                    this.integrantesStringList.remove(sp_integrantes.getSelectedItem());
                    arrayAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, this.integrantesStringList);
                    ToolsMsg.msg("Integrante removido com sucesso.", this.getActivity());
                } else {
                    ToolsMsg.msg("Nenhum item selecionado.", this.getActivity());
                }

                sp_integrantes.setAdapter(arrayAdapter);

                break;

            case R.id.BT_EE_AtualizarEquipe:

                if (et_nomeEquipe.getText().toString().equalsIgnoreCase("")) {
                    et_nomeEquipe.setError("Insira um nome válido.");
                }

                if (et_nomeIntegrante.getText().toString().equalsIgnoreCase("")) {
                    et_nomeIntegrante.setError("Insira um nome válido.");
                }

                if (integrantesStringList.size() == 0) {
                    ToolsMsg.msg("Nenhum integrante cadastrado.", this.getActivity());
                }

                if (integrantesStringList.size() > 0 && et_nomeEquipe.getText().toString().length() > 0) {

                    //equipe = new Equipe();

                    equipe.setNome(et_nomeEquipe.getText().toString());

                    String inte = "";

                    for (String str : integrantesStringList) {
                        inte += "," + str;
                    }
                    inte = inte.replaceFirst(",", "");
                    equipe.setIntegrantesString(inte);


                    equipe.save();


                    ToolsMsg.msg("Equipe atualizada com sucesso!", this.getActivity());


                    Fragment fragment = new TelaEquipes();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.screen_area, fragment);
                    ft.commit();

                    this.drawer.closeDrawer(GravityCompat.START);


                }


                break;

        }

    }


    public static void irParaTelaEditarEquipes() {
        fragment = new TelaEditarEquipes();
        fragmentManager = fragmentActivity.getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();
        ft.replace(R.id.screen_area, fragment);
        ft.commit();

        drawer.closeDrawer(GravityCompat.START);
    }

    public void linkComponents() {

        sp_integrantes = (Spinner) getActivity().findViewById(R.id.SP_EE_Integrantes);

        et_nomeEquipe = (EditText) getActivity().findViewById(R.id.ET_EE_NomeEquipe);
        et_nomeIntegrante = (EditText) getActivity().findViewById(R.id.ET_EE_Integrante);

        bt_addIntegrante = (Button) getActivity().findViewById(R.id.BT_EE_AddIntegrante);
        bt_addIntegrante.setOnClickListener(this);

        bt_remIntegrante = (Button) getActivity().findViewById(R.id.BT_EE_RemIntegrante);
        bt_remIntegrante.setOnClickListener(this);

        bt_attEquipe = (Button) getActivity().findViewById(R.id.BT_EE_AtualizarEquipe);
        bt_attEquipe.setOnClickListener(this);

    }


}
