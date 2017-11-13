package com.example.anggarisky.pandalogin.testes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaCodec;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.anggarisky.pandalogin.R;

import com.example.anggarisky.pandalogin.modelo.Equipe;
import com.example.anggarisky.pandalogin.telas.DialogLayoutBtnEditar;
import com.example.anggarisky.pandalogin.telas.TelaEditarEquipes;
import com.example.anggarisky.pandalogin.tools.ToolsMsg;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.ViewHolder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by aluno on 06/11/17.
 */

public class AdapterButton extends ArrayAdapter<Equipe> {

    final List<Equipe> equipes;
    Equipe equipe;
    final Context context;

    public AdapterButton(@NonNull Context context, List<Equipe> equipes) {
        super(context, 0, equipes);
        this.equipes = equipes;
        this.context = context;
    }

    Intent it;

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int posicaoItem = position;
        equipe = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_equipes, parent, false);
        }
        // Lookup view for data population
        final View cv = convertView;

        final long codigo = equipe.getId();

        final Equipe equipeFinal = getItem(position);

        final String integrantes = equipeFinal.getIntegrantesString();

        final String[] listaIntegrantesArr = integrantes.split(Pattern.quote(","));



        TextView tv_item_nomeEquipe = (TextView)convertView.findViewById(R.id.TV_Item_NomeEquipe);
        tv_item_nomeEquipe.setText(equipeFinal.getNome());

        TextView tv_item_content = (TextView)convertView.findViewById(R.id.TV_Item_Content);
        tv_item_content.setText(""+listaIntegrantesArr.length);




        //EDITAR
        Button bt_item_edit =(Button) convertView.findViewById(R.id.BT_ListItem_Editar);
        bt_item_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaEditarEquipes.irParaTelaDialogLayoutBtnEditar(codigo);
                //ToolsMsg.msg(""+equipeFinal.toString(),getContext());
            }
        });

        //DELETAR
        Button bt_item_delete =(Button) convertView.findViewById(R.id.BT_ListItem_Delete);
        bt_item_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPlus dialog = DialogPlus.newDialog(cv.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialog_layout_simounao))
                        .setCancelable(true)
                        .setGravity(Gravity.CENTER)
                        .setExpanded(true)
                        .setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(DialogPlus dialog, View view) {

                                if(view.getId() == R.id.BT_DialogItem_Sim){
                                    //Equipe equip = Equipe.findById(Equipe.class,position);


                                    Equipe equipeRemover = equipes.get(position);
                                    int idx = position;
                                    if(equipeRemover!=null){

                                        //Log.i("importante: ","1 - Imp--> "+ equipes.get(idx).getNome());
                                        //Log.i("importante: ","2 - Imp--> "+ equipeRemover.getNome());
                                        equipeRemover.delete();
                                        equipes.remove(equipeRemover);
                                        TelaEditarEquipes.atualizarAdapterRemocao();
                                        dialog.dismiss();
                                    }else{
                                        Log.i("importante: ","Impossível deletar equipe.");
                                    }


                                    //Log.i("importante: ","position --> " + position);

                                }

                                if(view.getId() == R.id.BT_DialogItem_Nao){
                                    dialog.dismiss();
                                }

                            }
                        })
                        .create();
                dialog.show();
            }
        });
        // Populate the data into the template view using the data object

        // Return the completed view to render on screen
        return convertView;
    }
}
