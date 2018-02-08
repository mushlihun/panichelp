package com.listcreative.panichelp;

/**
 * Created by SONY-VAIO on 3/15/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class RecyclerViewAdapterJSON extends RecyclerView.Adapter<RecyclerViewAdapterJSON.ViewHolder> {

    Context context;

    List<GetDataAdapter> getDataAdapter;

    public RecyclerViewAdapterJSON(List<GetDataAdapter> getDataAdapter, Context context){

        super();

        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        GetDataAdapter getDataAdapter1 =  getDataAdapter.get(position);

        holder.personName.setText(getDataAdapter1.getName());

        //holder.IdTextView.setText(String.valueOf(getDataAdapter1.getId()));

        holder.personAddress.setText(getDataAdapter1.getDeskripsi());

        holder.personPhoto.setImageResource(getDataAdapter1.getFoto());

    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView personName;
        public TextView personAddress;
        public ImageView personPhoto;


        public ViewHolder(View itemView) {

            super(itemView);

            personName = (TextView)itemView.findViewById(R.id.list_title);
            personAddress = (TextView)itemView.findViewById(R.id.list_desc);
            personPhoto = (ImageView)itemView.findViewById(R.id.list_avatar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });


        }
    }
}
