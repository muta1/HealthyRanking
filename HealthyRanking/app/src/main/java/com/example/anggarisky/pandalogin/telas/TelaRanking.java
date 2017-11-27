package com.example.anggarisky.pandalogin.telas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.anggarisky.pandalogin.R;
import com.example.anggarisky.pandalogin.adapters.SimpleMutaoImageAdapter;

/**
 * Created by mutao on 26/11/17.
 */

public class TelaRanking extends Fragment implements View.OnClickListener {

    public static String[] images = {
            "https://www.lucascaton.com.br/assets/images/2013/09/android.png",
            "https://www.timeshighereducation.com/sites/default/files/styles/the_breaking_news_image_style/public/Pictures/web/n/c/o/numbers_on_podium.jpg?itok=-nVlhkPx",
            "http://uschallenge.com.br/images/news/news01/ranking.png",
            "https://media.licdn.com/mpr/mpr/p/5/005/038/33a/269063d.jpg",
            "http://rawpowerlifting.com/wp-content/uploads/2017/01/ranking-1.jpg"
    };

    GridView gv_gridRank;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tela_ranking, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gv_gridRank = (GridView) getActivity().findViewById(R.id.GV_TR_GridRanking);
        gv_gridRank.setAdapter(
                new SimpleMutaoImageAdapter(getContext(), TelaRanking.images)

        );

    }

    @Override
    public void onClick(View view) {

    }
}
