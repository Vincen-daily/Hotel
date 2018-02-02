package com.example.hotelapp;

import android.content.Context;
import android.renderscript.RenderScript;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hotelapp.model.CityData;
import com.example.hotelapp.network.Service;
import com.example.hotelapp.present.HotelPresenter;
import com.example.hotelapp.view.HotelAdapter;
import com.example.hotelapp.view.HotelView;

import javax.inject.Inject;

public class MainActivity extends BaseApp implements HotelView {

    private RecyclerView recyclerView;

    private ProgressBar progressBar;

    @Inject
    public Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAppComponent().inject(this);
        init();
        HotelPresenter presenter=new HotelPresenter(service,this);
        presenter.getCity();
    }

    private void init() {
        recyclerView=findViewById(R.id.list);
        progressBar=findViewById(R.id.progress);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showgetDataSuccess(CityData cityData) {
        HotelAdapter adapter=new HotelAdapter(cityData.getData(), getApplicationContext(), new HotelAdapter.OnItemClickListener() {
            @Override
            public void onClick(CityData.DataBean dataBean) {
                Toast.makeText(getApplicationContext(),dataBean.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
