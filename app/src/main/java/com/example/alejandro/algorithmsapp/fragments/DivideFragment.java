package com.example.alejandro.algorithmsapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.example.alejandro.algorithmsapp.Adaptadores.TestRecyclerViewAdapter;
import com.example.alejandro.algorithmsapp.Algorithm;
import com.example.alejandro.algorithmsapp.R;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInRightAnimator;
import jp.wasabeef.recyclerview.animators.adapters.AlphaInAnimationAdapter;

/**
 * Created by Alejandro on 16/02/2017.
 */

public class DivideFragment extends android.support.v4.app.Fragment {

    static final boolean GRID_LAYOUT = false;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Algorithm> mContentItems = new ArrayList<>();

    public static DivideFragment newInstance() {
        return new DivideFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //mRecyclerView.setItemAnimator(new FadeInAnimator());
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager;

        // ANIMACION
        mRecyclerView.setItemAnimator(new SlideInRightAnimator());

        if (GRID_LAYOUT) {
            layoutManager = new GridLayoutManager(getActivity(), 2);
        } else {
            layoutManager = new LinearLayoutManager(getActivity());
        }


        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mAdapter = new TestRecyclerViewAdapter(mContentItems);

        //ANIMACION
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
        alphaAdapter.setFirstOnly(false);
        alphaAdapter.setDuration(2000);
        alphaAdapter.setInterpolator(new OvershootInterpolator(.5f));
        mRecyclerView.setAdapter(alphaAdapter);
        {
            poblarListaDivide();
            mAdapter.notifyDataSetChanged();
        }

    }

    private void poblarListaDivide(){
        mContentItems.add(new Algorithm(R.drawable.merge, "Combinación", "Recomendado en: Cuando se trabaja en paralelo."));
        mContentItems.add(new Algorithm(R.drawable.quick, "Rápido", "Recomendado en: Normalmente el más rápido."));
    }
}