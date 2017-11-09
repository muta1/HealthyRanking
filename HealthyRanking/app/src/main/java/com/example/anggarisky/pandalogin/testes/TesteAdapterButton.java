package com.example.anggarisky.pandalogin.testes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.anggarisky.pandalogin.R;

import com.example.anggarisky.pandalogin.modelo.Equipe;
import com.example.anggarisky.pandalogin.tools.ToolsMsg;

import java.util.List;

/**
 * Created by aluno on 06/11/17.
 */

public class TesteAdapterButton extends ArrayAdapter<Equipe> {

    List<Equipe> equipes;
    Equipe equipe;

    public TesteAdapterButton(@NonNull Context context, List<Equipe> equipes) {
        super(context, 0, equipes);
        this.equipes = equipes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        equipe = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_equipes, parent, false);
        }
        // Lookup view for data population


        long codigo = equipe.getId();

        TextView tv_item_teste = (TextView)convertView.findViewById(R.id.TV_Item_NomeEquipe);

        final String outroTeste = equipe.getNome();
        tv_item_teste.setText(equipe.getNome());
        Log.i("Teste: ", " --- "+equipe.hashCode() + "  codigo: " + codigo);

        Button bt_item_equip =(Button) convertView.findViewById(R.id.BT_ListItem_Delete);
        bt_item_equip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToolsMsg.msg("Teste: " + outroTeste, getContext());
                Log.i("Teste2: ", " --- "+equipe.hashCode() + "  codigo: ");
            }
        });
        // Populate the data into the template view using the data object

        // Return the completed view to render on screen
        return convertView;
    }
}
