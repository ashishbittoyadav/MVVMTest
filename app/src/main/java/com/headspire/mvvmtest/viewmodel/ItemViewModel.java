package com.headspire.mvvmtest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.headspire.mvvmtest.model.ItemModel;
import com.headspire.mvvmtest.repository.ItemRepository;

import java.util.List;

public class ItemViewModel extends ViewModel {
    private MutableLiveData<List<ItemModel>> items;
    private ItemRepository itemRepository;

    public void init()
    {
        if(itemRepository!=null)
        {
            return;
        }
        itemRepository= ItemRepository.getInstance();
        items=itemRepository.getItem();
    }

    public void addNewItem(final ItemModel itemModel)
    {
        List<ItemModel> currentItem=items.getValue();
        currentItem.add(itemModel);
        items.postValue(currentItem);
    }

    public LiveData<List<ItemModel>> getItems()
    {
        return items;
    }
}
