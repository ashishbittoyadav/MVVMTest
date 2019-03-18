package com.headspire.mvvmtest;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.headspire.mvvmtest.adapter.AdapterList;
import com.headspire.mvvmtest.model.ItemModel;
import com.headspire.mvvmtest.viewmodel.ItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mrecyclerView;
    private AdapterList adapterList;
    private Button addItem;
    private ItemViewModel itemViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mrecyclerView=findViewById(R.id.myrecyclerview);
        itemViewModel= ViewModelProviders.of(this).get(ItemViewModel.class);
        addItem=findViewById(R.id.additem);
        addItem.setOnClickListener(this);
        itemViewModel.init();

        itemViewModel.getItems().observe(this, new Observer<List<ItemModel>>() {
            @Override
            public void onChanged(List<ItemModel> itemModels) {
                adapterList.notifyDataSetChanged();
            }
        });
        initRecyclerView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.additem:
                itemViewModel.addNewItem(new ItemModel("xyz","dehli"));
                break;
        }
        Toast.makeText(this,"added",Toast.LENGTH_SHORT).show();
    }

    private void initRecyclerView() {
        adapterList=new AdapterList(this,itemViewModel.getItems().getValue());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setOrientation(RecyclerView.VERTICAL);
        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(adapterList);
    }
}
