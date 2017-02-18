package com.example.alejandro.algorithmsapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alejandro.algorithmsapp.Adaptadores.TestRecyclerViewAdapter;
import com.example.alejandro.algorithmsapp.Algorithm;
import com.example.alejandro.algorithmsapp.R;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandro on 17/02/2017.
 */

public class RestrictedFragment extends android.support.v4.app.Fragment {

    static final boolean GRID_LAYOUT = false;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Algorithm> mContentItems = new ArrayList<>();

    public static RestrictedFragment newInstance() {
        return new RestrictedFragment();
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
        //mAdapter

        //mAdapter = new RecyclerViewMaterialAdapter();

//        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
        //mRecyclerView.setAdapter(new ScaleInAnimationAdapter(mAdapter));
        mRecyclerView.setAdapter(mAdapter);

        {
            poblarListaRestricted();
            mAdapter.notifyDataSetChanged();
        }

    }

    private void poblarListaRestricted(){
        mContentItems.add(new Algorithm(R.drawable.count, "Conteo", "Recomendado en: Cuando las entradas están restringidas en un rango."));
        mContentItems.add(new Algorithm(R.drawable.radix, "Base", "Recomendado en: Con enteros limitados, o cadenas de longitud fija"));
    }
}
