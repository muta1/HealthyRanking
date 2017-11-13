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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.anggarisky.pandalogin.R;
import com.example.anggarisky.pandalogin.modelo.Equipe;
import com.example.anggarisky.pandalogin.tools.ToolsMsg;

import java.util.ArrayList;
import java.util.List;

public class CadastrarEquipe extends Fragment implements View.OnClickListener {//extends AppCompatActivity

    Equipe equipe;
    List<String> integrantesStringList = new ArrayList<>();

    TextView tv_qtdIntegrantes;


    Button bt_addIntegrante,bt_remIntegrante,bt_cadastrarEquipe;

    Spinner sp_integrantes;
    ArrayAdapter<String> arrayAdapter;

    EditText et_integranteNome,et_equipeNome;
    DrawerLayout drawer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tela_cadastrar_equipe, null);//atenção aki
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // todas ações que devem iniciar com a tela, ex: ligar botões...

        tv_qtdIntegrantes = (TextView) getActivity().findViewById(R.id.TV_CE_QtdIntegrantes);

        bt_addIntegrante = (Button) getActivity().findViewById(R.id.BT_CE_AddIntegrante);
        bt_addIntegrante.setOnClickListener(this);

        bt_remIntegrante = (Button) getActivity().findViewById(R.id.BT_CE_RemIntegrante);
        bt_remIntegrante.setOnClickListener(this);

        bt_cadastrarEquipe = (Button) getActivity().findViewById(R.id.BT_CE_CadastrarEquipe);
        bt_cadastrarEquipe.setOnClickListener(this);


        et_integranteNome = (EditText) getActivity().findViewById(R.id.ET_CE_Integrante);
        et_equipeNome = (EditText) getActivity().findViewById(R.id.ET_CE_NomeEquipe);

        sp_integrantes = (Spinner) getActivity().findViewById(R.id.SP_CE_Integrantes);

        atualizaQtdIntegrantes();
        drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.BT_CE_AddIntegrante:

                if (!et_integranteNome.getText().toString().equalsIgnoreCase("")) {
                    this.integrantesStringList.add(et_integranteNome.getText().toString());
                    arrayAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, this.integrantesStringList);
                }else {
                    et_integranteNome.setError("Insira um nome válido.");
                }


                atualizaQtdIntegrantes();
                sp_integrantes.setAdapter(arrayAdapter);

                break;

            case R.id.BT_CE_RemIntegrante:
                if (sp_integrantes.getSelectedItem() != null) {
                    this.integrantesStringList.remove(sp_integrantes.getSelectedItem());
                    arrayAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, this.integrantesStringList);
                    ToolsMsg.msg("Integrante removido com sucesso.",this.getActivity());
                }else{
                    ToolsMsg.msg("Nenhum item selecionado.",this.getActivity());
                }

                atualizaQtdIntegrantes();
                sp_integrantes.setAdapter(arrayAdapter);

                break;

            case R.id.BT_CE_CadastrarEquipe:

                if(et_equipeNome.getText().toString().equalsIgnoreCase("")){
                    et_equipeNome.setError("Insira um nome válido.");
                }

                if (et_integranteNome.getText().toString().equalsIgnoreCase("")){
                    et_integranteNome.setError("Insira um nome válido.");
                }

                if(integrantesStringList.size() == 0){
                    ToolsMsg.msg("Nenhum integrante cadastrado.",this.getActivity());
                }

                if(integrantesStringList.size() > 0 && et_equipeNome.getText().toString().length() > 0){

                    equipe = new Equipe();

                    equipe.setNome(et_equipeNome.getText().toString());
                    //equipe.setIntegrantes(this.integrantesStringList);

                    String integrantes="";


                    for(String str :integrantesStringList){
                        integrantes += ","+str;
                    }
                    integrantes = integrantes.replaceFirst(",","");
                    equipe.setIntegrantesString(integrantes);


                    equipe.save();


                    ToolsMsg.msg("Equipe cadastrada com sucesso!",this.getActivity());


                    Fragment fragment = new TelaEquipes();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.screen_area,fragment);
                    ft.commit();

                    drawer.closeDrawer(GravityCompat.START);


                }


                break;

        }
    }

    public void atualizaQtdIntegrantes(){
       tv_qtdIntegrantes.setText(""+this.integrantesStringList.size());
    }

}
