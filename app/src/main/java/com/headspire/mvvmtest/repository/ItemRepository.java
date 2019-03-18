package com.headspire.mvvmtest.repository;

import androidx.lifecycle.MutableLiveData;

import com.headspire.mvvmtest.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    private static ItemRepository instance;
    private ArrayList<ItemModel> data=new ArrayList<>();

    //singleton pattern
    public static ItemRepository getInstance()
    {
        if(instance==null)
            return new ItemRepository();
        else
            return instance;
    }

    public MutableLiveData<List<ItemModel>> getItem()
    {
        setItem();
        MutableLiveData<List<ItemModel>> item=new MutableLiveData<>();
        item.setValue(data);
        return item;
    }

    public void setItem()
    {
        data.add(new ItemModel("ashish","dehradun"));
        data.add(new ItemModel("bitto","gurugram"));
    }
}
