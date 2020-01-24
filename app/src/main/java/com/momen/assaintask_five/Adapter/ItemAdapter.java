package com.momen.assaintask_five.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.momen.assaintask_five.AddCartActivity;
import com.momen.assaintask_five.Grid_Item_Activity;
import com.momen.assaintask_five.Model.Album;
import com.momen.assaintask_five.Model.itemModel;
import com.momen.assaintask_five.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

private Context mContext;
private List<Album> albumList;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView title, count;
    public ImageView thumbnail, overflow;

    public MyViewHolder(View view) {
        super(view);
        title =  view.findViewById(R.id.title);
        count =  view.findViewById(R.id.count);
        thumbnail =  view.findViewById(R.id.thumbnail);






     view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(getLayoutPosition()==0){
                    Intent intent= new Intent(v.getContext(), AddCartActivity.class);

                    v.getContext().startActivity(intent);





                    Toast.makeText(mContext, "check", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


    public ItemAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        return new ItemAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ItemAdapter.MyViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText("Price: "+album.getNumOfSongs() + " TK ");

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);


    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }
}