package com.example.anggarisky.pandalogin.telas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.anggarisky.pandalogin.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;


/**
 * Created by mutao on 12/11/17.
 */

public class TelaCompeticoes extends Fragment implements View.OnClickListener {

    Button bt_teste;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tela_competicoes, null);//atenção aki
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bt_teste = (Button)getActivity().findViewById(R.id.BT_TESTE_TESTE_TESTE);
        bt_teste.setOnClickListener(this);


        // todas ações que devem iniciar com a tela, ex: ligar botões...
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.BT_TESTE_TESTE_TESTE){
            
        }
    }


}
