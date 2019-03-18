package com.headspire.mvvmtest.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.headspire.mvvmtest.R;
import com.headspire.mvvmtest.model.ItemModel;
import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ItemView> {
    private List<ItemModel> list;
    private Context context;
    public AdapterList(Context context,List<ItemModel> list)
    {
        this.list=list;
        this.context=context;
    }
    @NonNull
    @Override
    public ItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_layout,viewGroup,false);
        ItemView itemView=new ItemView(view);
        return itemView;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemView itemView, int i) {
        itemView.name.setText(list.get(i).getName());
        itemView.address.setText(list.get(i).getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemView extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView address;
        public ItemView(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.itemname);
            address=itemView.findViewById(R.id.itemaddress);
        }
    }
}
